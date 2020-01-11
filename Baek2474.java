import java.util.Scanner;
import java.util.Arrays;
class Node implements Comparable<Node>{
	int num,up,down;
	Node(int n,int u,int d){
		num=n;up=u;down=d;
	}
	public int compareTo(Node o) {
		int r=up+down-o.up-o.down;
		if(r==0) r=up-o.up;
		return r;
	}
}
public class Baek2474 {
	static int N;
	static int[] parent;
	static int[] rank;
	static Node[] line;
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
	static int area(long x1,long y1,long x2,long y2,long x3,long y3) {
		long sum;
		sum=x1*y2-x2*y1;
		sum+=x2*y3-x3*y2;
		sum+=x3*y1-x1*y3;
		if(sum<0) return -1;
		else if(sum==0) return 0;
		else return 1;
	}
	//y1=2,y2=1
	static int solution(int x1,int x2,int x3,int x4) {
		int t1=area(x1,2,x2,1,x3,2); int t2=area(x1,2,x2,1,x4,1);
		int t3=area(x3,2,x4,1,x1,2); int t4=area(x3,2,x4,1,x2,1);
		if(t1*t2<0&&t3*t4<0) return 1;
		else return 0;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		N=s.nextInt();
		line=new Node[N];
		parent=new int[N];
		rank=new int[N];
		reset();
		for(int i=0;i<N;i++) {
			line[i]=new Node(i,s.nextInt(),s.nextInt());
		}
		Arrays.sort(line);
		for(int i=0;i<N-1;i++) {
			if(solution(line[i].up,line[i].down,line[i+1].up,line[i+1].down)==1)
				union(line[i].num,line[i+1].num);
		}
		int max=-1,cnt=0;
		if(N==1) max=1;
		for(int i=0;i<N;i++)
			System.out.print(parent[i]+" ");
		System.out.println();
		for(int i=0;i<N-1;i++) {
			cnt++;
			if(parent[i]!=parent[i+1]) {
				if(max<cnt) max=cnt;
				cnt=0;
			}
		}
		if(max<cnt) max=cnt;
		System.out.println(max);
	}
}
