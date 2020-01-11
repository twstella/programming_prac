import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
public class SCC {
	static ArrayList<ArrayList<Integer>> G;
	static ArrayList<ArrayList<Integer>> Gr;
	static Stack<Integer> stack;
	static ArrayList<ArrayList<Integer>> R;
	static boolean[] visited;
	static int V,E;
	public static void dfs(int n) {
		visited[n]=true;
		for(int u:G.get(n)) {
			if(!visited[u])
				dfs(u);
		}
		stack.push(n);
		return;
	}
	static void topo() {
		stack=new Stack<Integer>();
		visited=new boolean[V];
		for(int i=0;i<V;i++) {
			if(!visited[i])
				dfs(i);
		}
	}
	static void reverse() {
		visited=new boolean[V];
		R=new ArrayList<ArrayList<Integer>>();
		while(!stack.isEmpty()) {
			int n=stack.pop();
			if(visited[n]) continue;
			ArrayList<Integer> t=new ArrayList<Integer>();
			visited[n]=true;
			t.add(n);
			R.add(t);
			Rdfs(n,t);
		}
	}
	static void Rdfs(int n,ArrayList<Integer> t) {
		for(int u:Gr.get(n)) {
			if(!visited[u]) {
				visited[u]=true;
				t.add(u);
				Rdfs(u,t);
			}
		}
	}
	static void Arrange() {
		for(ArrayList<Integer> u:R) {
			Collections.sort(u);
		}
		Collections.sort(R,new Comparator<ArrayList<Integer>>() {
			public int compare(ArrayList<Integer> o1,ArrayList<Integer>o2) {
				return o1.get(0)-o2.get(0);
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A,B;
		try {
			BufferedReader rd=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(rd.readLine());
			V=Integer.parseInt(s.nextToken());
			E=Integer.parseInt(s.nextToken());
			G=new ArrayList<ArrayList<Integer>>();
			Gr=new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<V;i++) {
				G.add(new ArrayList<Integer>());
				Gr.add(new ArrayList<Integer>());
			}
			for(int i=0;i<E;i++) {
				s=new StringTokenizer(rd.readLine());
				A=Integer.parseInt(s.nextToken())-1;
				B=Integer.parseInt(s.nextToken())-1;
				G.get(A).add(B);
				Gr.get(B).add(A);
			}
			topo();
			reverse();
			System.out.println(R.size());
			Arrange();
			for(int i=0;i<R.size();i++) {
				for(int u:R.get(i))
					System.out.print(u+1+" ");
				System.out.println(-1);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
