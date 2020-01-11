import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class BipartiteMatching {	
	static ArrayList<ArrayList<Integer>> adj=new ArrayList<ArrayList<Integer>>();
	static int N,M;
	static boolean[] visited;
	static int[] A;
	static int[] B;
	static void Clear() {
		for(int i=0;i<N;i++)
			visited[i]=false;
	}
	static boolean dfs(int a) {
		visited[a]=true;
		for(int b:adj.get(a)) {
			if(B[b]==-1||!visited[B[b]]&&dfs(B[b])) {
				A[a]=b;
				B[b]=a;
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(br.readLine());
			N=Integer.parseInt(s.nextToken());
			M=Integer.parseInt(s.nextToken());
			visited=new boolean[N];
			A=new int[N];
			B=new int[N];
			for(int i=0;i<N;i++) {
				adj.add(new ArrayList<Integer>());
				A[i]=-1;
				B[i]=-1;
			}
			for(int m=0;m<M;m++) {
				s=new StringTokenizer(br.readLine());
				int t=Integer.parseInt(s.nextToken())-1;
				int p=Integer.parseInt(s.nextToken())-1;
				adj.get(t).add(p);
			}
			int cnt=0;
			for(int i=0;i<N;i++) {
				if(A[i]==-1) {
					Clear();
					if(dfs(i))
						cnt++;
				}
			}
			System.out.println(cnt);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
