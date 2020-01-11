package progrmmers;

public class Ranking {
	static int[][] adj;
	static void Floyd() {
		for(int k=0;k<adj.length;k++) {
			for(int i=0;i<adj.length;i++)
				for(int j=0;j<adj.length;j++)
					adj[i][j]=Math.min(adj[i][j],adj[i][k]+adj[k][j]);
		}
	}
	static void printGraph() {
		for(int i=0;i<adj.length;i++) {
			System.out.print(i+") ");
			for(int j=0;j<adj.length;j++)
				if(adj[i][j]==100000000)
					System.out.print(0+" ");
				else 
					System.out.print(adj[i][j]+" ");
			System.out.println();
		}
	}
	static int solution(int n,int[][] results) {
		int ans=0;
		adj=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(i==j)
					adj[i][j]=0;
				else 
					adj[i][j]=100000000;
		for(int i=0;i<results.length;i++) {
			adj[results[i][0]-1][results[i][1]-1]=1;
		}
		//printGraph();
		Floyd();
		for(int i=0;i<n;i++) {
			boolean avail=true;
			for(int j=0;j<n;j++) {
				if(i==j)
					continue;
				if(adj[i][j]!=0&&adj[i][j]!=100000000)
					continue;
				else {
					if(adj[j][i]!=0&&adj[j][i]!=100000000)
						continue;
					else
						avail=false;
				}
			}
			if(avail==true) {
				ans++;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int n=5;
		int[][] results= {{4,3},{4,2},{3,2},{1,2},{2,5}};
		*/
		int n=6;
		int[][] results= {{1,2},{1,3},{2,4},{3,4},{4,5},{4,6},{6,5}};
		System.out.println(solution(n,results));
	}

}
