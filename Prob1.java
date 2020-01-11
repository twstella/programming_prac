import java.util.ArrayList;
/*
 class RPoint{
	 public static int r,c;
	 public static RPoint(r,c){
		 this.r=r;
		 this.c=c;
	 }
 }
 */
public class Prob1 {
	static ArrayList<RPoint> Queue=new ArrayList<RPoint>();
	public static int M;
	public static int N;
	public static int[][] visited;

	
	public static int count(int[][] picture) {
		int cnt=0;
		while(!Queue.isEmpty()) {
			RPoint t=Queue.remove(0);
			//visited[t.r][t.c]=1;
			//System.out.println("("+t.r+","+t.c+")");
			cnt++;
			if((t.r-1>=0)&&(visited[t.r-1][t.c]==0)&&(picture[t.r][t.c]==picture[t.r-1][t.c])) {
				visited[t.r-1][t.c]=1;
				Queue.add(new RPoint(t.r-1,t.c));
			}
			if((t.c-1>=0)&&(visited[t.r][t.c-1]==0)&&(picture[t.r][t.c]==picture[t.r][t.c-1])) {
				visited[t.r][t.c-1]=1;
				Queue.add(new RPoint(t.r,t.c-1));
			}
			if((t.r+1<M)&&(visited[t.r+1][t.c]==0)&&(picture[t.r][t.c]==picture[t.r+1][t.c])) {
				visited[t.r+1][t.c]=1;
				Queue.add(new RPoint(t.r+1,t.c));
			}
			if((t.c+1<N)&&(visited[t.r][t.c+1]==0)&&(picture[t.r][t.c]==picture[t.r][t.c+1])) {
				visited[t.r][t.c+1]=1;
				Queue.add(new RPoint(t.r,t.c+1));
			}
			
		}
		return cnt;
	}
	
	public static int[] solution(int m, int n, int[][] picture) {
		M=m;
		N=n;
		visited=new int[M][N];
		
		int area=0;
		int max=0;
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]==0&&picture[i][j]!=0) {
					area++;
					Queue.add(new RPoint(i,j));
					visited[i][j]=1;
					int t=count(picture);
					if(t>max)
						max=t;	
				}
			}
		}
		int[] r= new int[2];
		r[0] = area; r[1] = max;
		return(r);
	}

	public static void main(String[] args) {
		int[][] picture = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
		int[] r = solution(6, 4, picture);
		System.out.println(r[0] + " " +r[1]);
		
		int[][] pic1 = {{1,1,1,0,1},{1,2,2,0,2},
				{1,0,0,1,4},{0,0,0,1,4},{0,0,0,3,4},{0,0,0,3,4}};
		r = solution(6, 5, pic1);
		System.out.println(r[0] + " " +r[1]);
	}
}
