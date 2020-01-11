
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Coloring {
	static int N, M, K;
	static int[][] arr;
	static boolean[][] visited;
	static ArrayList<Integer> q;
	
	public static int bfs(int r, int c) {
		visited[r][c] = true;
		q.add(r*N+c);
		
		int cnt=0;
		while (q.isEmpty() != true) {
			int e = q.remove(0);
			cnt++;
			int R = e / N, C= e%N;
			visited[R][C] = true;
			if (R -1>=0 && arr[R-1][C]==0 && visited[R-1][C] == false) {
				visited[R-1][C] = true;
				q.add((R-1)*N+C);
			}
			if (R +1 <M && arr[R+1][C]==0 && visited[R+1][C] == false ) {
				visited[R+1][C] = true;
				q.add((R+1)*N+C);
			}
			if (C -1>=0 && arr[R][C-1]==0 && visited[R][C-1] == false ) {
				visited[R][C-1] = true;
				q.add(R*N+C-1);
			}
			if (C +1 <N && arr[R][C+1]==0 &&visited[R][C+1] == false ) {
				visited[R][C+1] = true;
				q.add(R*N+C+1);
			}
		}
		return cnt;
	}
	
	public static void ShowGrid() {
		for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++)
				System.out.print(arr[i][j] +" ");
			System.out.println();
		}
	}
		
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		M = key.nextInt();
		N = key.nextInt();
		K = key.nextInt();
		arr = new int[M][N];
		visited = new boolean[M][N];
		
		for (int i=0; i<K; i++) {
			int lx = key.nextInt();
			int ly = key.nextInt();
			int rx = key.nextInt();
			int ry = key.nextInt();
			for (int r=ly; r<ry; r++)
				for (int c=lx; c<rx; c++)
					arr[r][c] = 1;
		}
		key.close();
		
//		ShowGrid();
		
		ArrayList<Integer> list = new ArrayList<Integer> ();
		for (int i=0; i<M; i++) {
			for (int j=0; j<N;j++) {
				if (arr[i][j] ==0 && visited[i][j] == false) {
					q = new ArrayList<Integer> ();
					int e = bfs(i, j);
//					System.out.println(e);
					list.add(e);
				}
			}
		}

		int S = list.size();
		int A[] = new int[S];
		int idx=0;
		for (int u: list) 
			A[idx++] = u;
		Arrays.sort(A);
		System.out.println(S);
		for (int i=0; i<S; i++)
			System.out.print(A[i]+" ");
		System.out.println();
		
	}
}
