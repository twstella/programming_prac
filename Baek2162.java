import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
class Location{
	int ux,uy,dx,dy;
	Location(int ux,int uy,int dx,int dy){
		this.ux=ux;
		this.uy=uy;
		this.dx=dx;
		this.dy=dy;
	}
}

public class Baek2162 {
	static int N;
	static int[] parent;
	static int[] rank;
	static Location[] line;
	static void reset() {
		for(int i=0;i<N;i++) {
			parent[i]=i;
		}
	}
	
	static void union(int i,int j) {
		i=find(i);
		j=find(j);
		if(i==j) return;
		if(rank[i]<rank[j]) {
			parent[i]=j;
		}
		else {
			parent[j]=i;
			if(rank[i]==rank[j]) rank[i]++;
		}
	}
	static int find(int n) {
		if(parent[n]==n) return n;
		else {
			return find(parent[n]);
		}
	}
	static void connect() {
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				if(solution(line[i].ux,line[i].uy,line[i].dx,line[i].dy,line[j].ux,line[j].uy,line[j].dx,line[j].dy)==true)
					if(find(i)!=find(j))
						union(i,j);
			}
		}
	}
	static int area(long x1,long y1,long x2,long y2,long x3,long y3) {
		long sum;
		sum=x1*y2-x2*y1;
		sum+=x2*y3-x3*y2;
		sum+=x3*y1-x1*y3;
		if(sum<0) return -1;
		else if(sum==0) return 0;
		else return 1;
	}
	static boolean solution(int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4) {
		boolean flag=false;
		int t1=area(x1,y1,x2,y2,x3,y3);
		int t2=area(x1,y1,x2,y2,x4,y4);
		int t3=area(x3,y3,x4,y4,x1,y1);
		int t4=area(x3,y3,x4,y4,x2,y2);
		if(t1*t2<0&&t3*t4<0) flag=true;
		else if(t1*t2==0&&t3*t4<0) flag=true;
		else if(t1*t2<0&&t3*t4==0) flag=true;
		else if(t1*t2==0&&t3*t4==0) {
			int[] d=new int[4];
			d[0]=(x1-x3)*(x1-x3)+(y1-y3)*(y1-y3);
			d[1]=(x1-x4)*(x1-x4)+(y1-y4)*(y1-y4);
			d[2]=(x2-x3)*(x2-x3)+(y2-y3)*(y2-y3);
			d[3]=(x2-x4)*(x2-x4)+(y2-y4)*(y2-y4);
			Arrays.sort(d);
			int s1=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
			int s2=(x3-x4)*(x3-x4)+(y3-y4)*(y3-y4);
			if(Math.sqrt(d[3])>Math.sqrt(s1)+Math.sqrt(s2)) flag=false;
			else flag=true;
		}
		return flag;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		N=s.nextInt();
		parent=new int[N];
		rank=new int[N];
		line=new Location[N];
		reset();
		for(int i=0;i<N;i++) {
				line[i]=new Location(s.nextInt(),s.nextInt(),s.nextInt(),s.nextInt());
		}
		connect();
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<N;i++) {
			int q=find(i);
			if(map.containsKey((Integer)q)==true)
				map.put((Integer)q,map.get((Integer)q)+1);
			else map.put((Integer)q,1);
		}
		int cnt=0,max=0;
		for(Integer key:map.keySet()) {
			cnt++;
			int t=map.get(key);
			if(max<t) max=t;
		}
		System.out.println(cnt+"\n"+max);
	}

}
