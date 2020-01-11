import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;
/*
class RPoint{
	int r,c;
	RPoint(int r,int c){
		this.r=r;
		this.c=c;
	}
}
*/
public class Tomato {
	static Queue <RPoint> q=new LinkedList();
	public static int M,N;
	public static int[][] box;
	
	public static int eval() {
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(box[i][j]==0)
					return 0;
		return 1;
	}
	public static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				System.out.print(box[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}
	public static int dayPast() {
		int day=1,cnt=0;
		int tmp=q.size();
		if(eval()!=0)
			return 0;
		while(!q.isEmpty()) {
			RPoint t=q.poll();
			cnt++;
			if((t.r-1>=0)&&box[t.r-1][t.c]==0) {
				box[t.r-1][t.c]=1;
				q.offer(new RPoint(t.r-1,t.c));
			}
			if((t.c-1>=0)&&box[t.r][t.c-1]==0) {
				box[t.r][t.c-1]=1;
				q.offer(new RPoint(t.r,t.c-1));
			}
			if((t.r+1<N)&&box[t.r+1][t.c]==0) {
				box[t.r+1][t.c]=1;
				q.offer(new RPoint(t.r+1,t.c));
			}
			if((t.c+1<M)&&box[t.r][t.c+1]==0) {
				box[t.r][t.c+1]=1;
				q.offer(new RPoint(t.r,t.c+1));
			}
			if(eval()!=0)
				return day;
			//System.out.println(tmp+" "+cnt);
			if(tmp==cnt) {
				tmp=q.size();
				cnt=0;
				//System.out.println("Day "+day);
				//print();
				day++;
			}
			
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key =new Scanner(System.in);
		M=key.nextInt();
		N=key.nextInt();
		box=new int[N][M];
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				box[i][j]=key.nextInt();
		//print();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(box[i][j]==1) {
					q.offer(new RPoint(i,j));
				}
			}
		}
		System.out.println(dayPast());
		
	}

}
