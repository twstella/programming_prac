package progrmmers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class PGraph{
	HashMap<Integer,Integer> adj;
	PGraph(){
		adj=new HashMap<Integer,Integer>();
	}
}
class EnterQ implements Comparable<EnterQ>{
	int node,cost;
	EnterQ(int n,int c){
		node=n;
		cost=c;
	}
	public int compareTo(EnterQ o) {
		return cost-o.cost;
	}
}
public class ShortestPath {
	static int N,M,S,D;
	static PGraph[] gr;
	static void printGraph() {
		for(int i=0;i<N;i++) {
			System.out.print(i+") ");
			for(Integer key:gr[i].adj.keySet()) {
				System.out.print(key+":"+gr[i].adj.get(key)+" ");
			}
			System.out.println();
		}
	}
	static void showCost(int[] c) {
		for(int i=0;i<N;i++) {
			if(c[i]==Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(c[i]);
		}
	}
	static void PriQDijk(int from) {
		int[] visited=new int[N];
		PriorityQueue<EnterQ> pq=new PriorityQueue<EnterQ>();
		int[] cost=new int[N];
		for(int i=0;i<N;i++) {
			if(i==from) {
				cost[from]=0;
				pq.add(new EnterQ(from,0));
			}
			else {
				cost[i]=Integer.MAX_VALUE;
				pq.add(new EnterQ(i,Integer.MAX_VALUE));
			}
		}
		while(true) {
			EnterQ q=pq.poll();
			if(q.cost==Integer.MAX_VALUE)
				break;
			int see=q.node;
			if(visited[see]==1)
				continue;
			visited[see]=1;
			for(Integer u:gr[see].adj.keySet()) {
				int cr=gr[see].adj.get((Integer)u);
				if(visited[u]==0)
					if(cost[u]>cost[see]+cr) {
						cost[u]=cost[see]+cr;
						pq.add(new EnterQ(u,cost[u]));
					}
			}
		}
		showCost(cost);
	}
	public static void main(String[] args) {
		try {
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(in.readLine());
			N=Integer.parseInt(s.nextToken());
			M=Integer.parseInt(s.nextToken());
			s=new StringTokenizer(in.readLine());
			S=Integer.parseInt(s.nextToken())-1;
			gr=new PGraph[N];
			for(int i=0;i<N;i++)
				gr[i]=new PGraph();
			for(int i=0;i<M;i++) {
				s=new StringTokenizer(in.readLine());
				int n=Integer.parseInt(s.nextToken())-1;
				int m=Integer.parseInt(s.nextToken())-1;
				int w=Integer.parseInt(s.nextToken());
				if(gr[n].adj.containsKey(m)) {
					int cur=gr[n].adj.get(m);
					if(cur>w)
						gr[n].adj.put(m,w);
				}
				else gr[n].adj.put(m,w);
			}
			//printGraph();
			PriQDijk(S);
			
		}
		catch(IOException e) {
			return;
		}
	}
}
