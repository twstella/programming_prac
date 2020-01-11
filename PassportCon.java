import java.util.Scanner;
import java.util.ArrayList;
public class PassportCon {
	static int N,K;
	static ArrayList<ArrayList<Integer>> G;
	static int[] arr;
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
	public static boolean check() {
		visited=new int[N];
		color=new int[N];
		for(int i=0;i<N;i++)color[i]=-1;
		for(int i=0;i<N;i++) {
			if(visited[i]==1) continue;
			if(bfs(i)==false) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		K=sc.nextInt();
		arr=new int[N];
		G=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<N;i++)
			G.add(new ArrayList<Integer>());
		for(int i=0;i<N;i++)
			arr[i]=sc.nextInt();
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(arr[i]>arr[j]) {
					G.get(arr[i]-1).add(arr[j]-1);
					G.get(arr[j]-1).add(arr[i]-1);
				}
			}
		}
		
		if(check())
			System.out.println("YES");
		else System.out.println("NO");
	}

}
