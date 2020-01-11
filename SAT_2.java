import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;
public class SAT_2 {
	static int K,n,V;
	static ArrayList<ArrayList<Integer>> G;
	static ArrayList<ArrayList<Integer>> Gr;
	static ArrayList<ArrayList<Integer>> R;
	static Stack<Integer> stack;
	static boolean[] visited;
	static void add(int x,int y) {
		int f1,f2;
		f1=-x;f2=y;
		if(f1<0) f1=V/2-f1;
		if(f2<0) f2=V/2-f2;
		G.get(f1-1).add(f2-1);
		Gr.get(f2-1).add(f1-1);
		f1=-y;f2=x;
		if(f1<0) f1=V/2-f1;
		if(f2<0) f2=V/2-f2;
		G.get(f1-1).add(f2-1);
		Gr.get(f2-1).add(f1-1);
	}
	static void dfs(int n) {
		visited[n]=true;
		for(int u:G.get(n)) {
			if(!visited[u])
				dfs(u);
		}
		stack.push(n);
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
	static boolean check() {
		int o=V/2;
		for(ArrayList<Integer> u:R) {
			int l=u.size();
			for(int i=0;i<l;i++) {
				for(int j=i+1;j<l;j++) {
					int r=Math.abs(u.get(j)-u.get(i));
					if(r==o)
						return false;
				}
			}
		}
		return true;
	}
	static void topoSort() {
		int[] map=new int[V];
		for(int i=0;i<R.size();i++)
			for(int u:R.get(i)) map[u]=i;
		ArrayList<ArrayList<Integer>> cl=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<R.size();i++) {
			cl.add(new ArrayList<Integer>());
		}
		int[] incnt=new int[R.size()];
		for(int i=0;i<V;i++) {
			int c1=map[i];
			for(int u:G.get(i)) {
				int c2=map[u];
				if(c1!=c2) {
					cl.get(c1).add(c2);
					incnt[c2]++;
				}
			}
		}
		int[] val=new int[K];
		for(int i=0;i<K;i++)
			val[i]=-1;
		ArrayList<Integer>q=new ArrayList<Integer>();
		for(int i=0;i<incnt.length;i++)
			if(incnt[i]==0)
				q.add(i);
		while(!q.isEmpty()) {
			int e=q.remove(0);
			for(int u:R.get(e)) {
				if(u<K&&val[u]!=-1) continue;
				if(u>=K&&val[u-K]!=-1) continue;
				if(u>=K) val[u-K]=1;
				else val[u]=0;
			}
			for(int u:cl.get(e)) {
				incnt[u]--;
				if(incnt[u]==0)
					q.add(u);
			}
		}
		String r="";
		for(int i=0;i<K;i++)
			if(val[i]==0) r+="B";
			else r+="R";
		System.out.println(r);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		G=new ArrayList<ArrayList<Integer>>();
		Gr=new ArrayList<ArrayList<Integer>>();
		K=sc.nextInt();
		n=sc.nextInt();
		V=2*K;
		for(int i=0;i<V;i++) {
			G.add(new ArrayList<Integer>());
			Gr.add(new ArrayList<Integer>());
		}
		for(int i=0;i<n;i++) {
			int n1=sc.nextInt();
			if(sc.next().charAt(0)=='B')
				n1=-n1;
			int n2=sc.nextInt();
			if(sc.next().charAt(0)=='B')
				n2=-n2;
			int n3=sc.nextInt();
			if(sc.next().charAt(0)=='B')
				n3=-n3;
			add(n1,n2);
			add(n2,n3);
			add(n3,n1);
		}
		topo();
		reverse();
		if(check())
			topoSort();
		else 
			System.out.println("-1");
	}

}
