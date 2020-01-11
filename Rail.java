import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
class Location implements Comparable<Location>{
	int x,y;
	Location(int x,int y){
		if(x<y) {
			this.x=x;
			this.y=y;
		}
		else {
			this.x=y;
			this.y=x;
		}
	}
	public int compareTo(Location o) {
		int res=this.y-o.y;
		if(res==0)
			res=this.x-o.x;
		return res;
	}
}
public class Rail {
	public static int M;
	public static int D;
	static PriorityQueue <Integer> queue=new PriorityQueue();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		M=key.nextInt();
		int[][] p=new int[M][2];
		for(int i=0;i<M;i++)
			for(int j=0;j<2;j++)
				p[i][j]=key.nextInt();
		Location[] r=new Location[M];
		D=key.nextInt();
		key.close();
		for(int i=0;i<M;i++) {
			r[i]=new Location(p[i][0],p[i][1]);
		}
		Arrays.sort(r);
		int max=0;
		for(int i=0;i<M;i++) {
			queue.add(r[i].x);
			while((!queue.isEmpty())&&(r[i].y-queue.peek()>D))
				queue.poll();
			if(max<queue.size())
				max=queue.size();
		}
		System.out.println(max);
	}

}
