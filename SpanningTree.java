import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
class Edge implements Comparable<Edge>{
	int n1,n2,weight;
	Edge(int n,int m,int w){
		n1=n;n2=m;weight=w;
	}
	public int compareTo(Edge o) {
		return this.weight-o.weight;
	}
}
public class SpanningTree {
	static int[] parent;
	static int[] rank;
	static PriorityQueue<Edge> q=new PriorityQueue<Edge>();
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
			Edge e=q.remove();
			int u1=find(e.n1-1);
			int u2=find(e.n2-1);
			if(u1==u2) continue;
			union(u1,u2);
			sum+=e.weight;
			n++;
			if(n==V-1) break;
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(br.readLine());
			V=Integer.parseInt(s.nextToken());
			E=Integer.parseInt(s.nextToken());
			parent=new int[V];
			rank=new int[V];
			for(int i=0;i<E;i++) {
				s=new StringTokenizer(br.readLine());
				q.add(new Edge(Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken())));
			}
			System.out.println(kruskal());
		}
		catch(IOException e) {}
	}

}
