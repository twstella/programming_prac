package progrmmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;
class CGraph{
	ArrayList<Computer> adj;
	CGraph(){
		adj=new ArrayList<Computer>();
	}
}
class Computer{
	int num;
	int weight;
	Computer(int n,int w){
		num=n;
		weight=w;
	}
}
public class NetworkRestore {
	static CGraph[] gr;
	static int[] visited;
	static int[] dist;
	static int[] parent;
	static int N,M;
	static int getMin() {
		int minI=-1,min=100000000;
		for(int i=0;i<N;i++) {
			if(min>=dist[i]&&visited[i]==0) {
				min=dist[i];
				minI=i;
			}
		}
		return minI;
	}
	static void dij(int s) {
		dist[s]=0;
		for(int i=0;i<N;i++) {
			int e=getMin();
			visited[e]=1;
			ArrayList<Computer> tmp=gr[e].adj;
			for(int j=0;j<tmp.size();j++) {
				Computer t=tmp.get(j);
				if(visited[t.num]==0&&dist[t.num]>dist[e]+t.weight) {
					dist[t.num]=dist[e]+t.weight;
					parent[t.num]=e;
				}
			}
		}
	}
	static void printGraph() {
		for(int i=0;i<N;i++) {
			System.out.print(i+")");
			ArrayList<Computer> t=gr[i].adj;
			for(int j=0;j<t.size();j++) {
				System.out.print(t.get(j).num+" ");
			}
			System.out.println();
		}
		for(int j=0;j<N;j++)
			System.out.print(dist[j]+" ");
		System.out.println();
		for(int k=0;k<N;k++)
			System.out.print(parent[k]+" ");
		System.out.println();
	}
	public static void main(String[] args) {
		try {
			BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(in.readLine());
			N=Integer.parseInt(s.nextToken());
			M=Integer.parseInt(s.nextToken());
			gr=new CGraph[N];
			visited=new int[N];
			dist=new int[N];
			parent=new int[N];
			for(int i=0;i<N;i++) {
				gr[i]=new CGraph();
				visited[i]=0;
				dist[i]=100000000;
				parent[i]=-1;
			}
			for(int i=0;i<M;i++) {
				s=new StringTokenizer(in.readLine());
				int f=Integer.parseInt(s.nextToken())-1;
				int t=Integer.parseInt(s.nextToken())-1;
				int w=Integer.parseInt(s.nextToken());
				gr[f].adj.add(new Computer(t,w));
				gr[t].adj.add(new Computer(f,w));
			}
			dij(0);
			System.out.println(N-1);
			for(int i=0;i<parent.length;i++) {
				if(parent[i]==-1)
					continue;
				System.out.println((parent[i]+1)+" "+(i+1));
			}
		}
		catch(IOException e) {
			return;
		}
	}
}
