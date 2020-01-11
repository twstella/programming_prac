import java.util.Scanner;
import java.util.ArrayList;
public class Coloring1 {
	static int V,E,K;
	static ArrayList<ArrayList<Integer>> G;
	static int[] visited;
	static int[] color;
	public static boolean bfs(int n) {
		ArrayList<Integer> q=new ArrayList<Integer>();
		q.add(n);
		visited[n]=1;
		while(!q.isEmpty()) {
			int e=q.remove(0);
			int[] used=new int[K];
			for(int u:G.get(e)) {
				if(color[u]==-1) continue;
				used[color[u]]=1;
			}
			for(int i=0;i<K;i++) {
				if(used[i]==0) {
					color[e]=i;
					break;
				}
			}
			if(color[e]==-1) return false;
			for(int u:G.get(e)) {
				if(visited[u]==0) {
					visited[u]=1;
					q.add(u);
				}
			}
		}
		return true;
	}
	public static boolean Check() {
		visited=new int[V];
		color=new int[V];
		for(int i=0;i<V;i++) color[i]=-1;
		for(int i=0;i<V;i++) {
			if(visited[i]==1) continue;
			if(bfs(i)==false) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		K=2;
		int T=sc.nextInt();
		for(int t=0;t<T;t++) {
			V=sc.nextInt(); E=sc.nextInt();
			G=new ArrayList<ArrayList<Integer>>();	
			for(int i=0;i<V;i++) {
				ArrayList<Integer> tmp=new ArrayList<Integer>();
				G.add(tmp);
			}
				
			for(int i=0;i<E;i++) {
				int n1=sc.nextInt()-1;
				int n2=sc.nextInt()-1;
				//System.out.println(n1+" "+n2);
				G.get(n1).add(n2);
				G.get(n2).add(n1);
			}
			if(Check()==true)
				System.out.println("possible");
			else
				System.out.println("impossible");
		}
		sc.close();
	}

}
