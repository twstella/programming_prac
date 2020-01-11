import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;
class Coor3D{
	int id,x,y,z;
	Coor3D(int i,int x,int y,int z){
		id=i;
		this.x=x;this.y=y;this.z=z;
	}
}
class Li implements Comparable<Li>{
	int n1,n2,weight;
	Li(int n,int m,int w){
		n1=n;n2=m;weight=w;
	}
	public int compareTo(Li o) {
		return this.weight-o.weight;
	}
}
public class Baek2887 {
	static int[] parent;
	static int[] rank;
	static Coor3D[] node;
	static PriorityQueue<Li> q=new PriorityQueue<Li>();
	static int V,E;
	
	static void reset() {
		for(int i=0;i<V;i++) {
			parent[i]=-1;
			rank[i]=0;
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
		if(parent[n]==-1) return n;
		else {
			return find(parent[n]);
		}
	}
	static long kruskal() {
		long sum=0;
		int n=0;
		reset();
		for(int i=0;i<E;i++) {
			Li e=q.remove();
			int u1=find(e.n1-1);
			int u2=find(e.n2-1);
			if(u1==u2) continue;
			union(u1,u2);
			sum+=e.weight;
			n++;
			if(n==V-2) break;
		}
		return sum;
	}
	public static void main(String[] args) {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(br.readLine());
			int t=Integer.parseInt(s.nextToken());
			node=new Coor3D[t];
			for(int i=0;i<t;i++) {
				s=new StringTokenizer(br.readLine());
				node[i]=new Coor3D(i,Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken()));
				
			}
			Arrays.sort(node,new Comparator<Coor3D>() {
				public int compare(Coor3D o1,Coor3D o2) {
					return o1.x-o2.x;
				}
			});
			for(int i=0;i<t-1;i++) {
				q.add(new Li(node[i].id,node[i+1].id,node[i+1].x-node[i].x));
			}
			Arrays.sort(node,new Comparator<Coor3D>() {
				public int compare(Coor3D o1,Coor3D o2) {
					return o1.y-o2.y;
				}
			});
			for(int i=0;i<t-1;i++) {
				q.add(new Li(node[i].id,node[i+1].id,node[i+1].y-node[i].y));
			}
			Arrays.sort(node,new Comparator<Coor3D>() {
				public int compare(Coor3D o1,Coor3D o2) {
					return o1.z-o2.z;
				}
			});
			for(int i=0;i<t-1;i++) {
				q.add(new Li(node[i].id,node[i+1].id,node[i+1].z-node[i].z));
			}
			System.out.println(kruskal());
		}
		catch(IOException e) {}
	}
}