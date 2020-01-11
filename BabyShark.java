import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
class Position{
	int r,c;
	Position(int x,int y){
		r=x;
		c=y;
	}
}
class SortObj implements Comparator<Position>{
	public int compare(Position o1,Position o2) {
		int result=o1.r-o2.r;
		if(result==0) {
			result=o1.c-o2.c;
		}
		return result;
	}
}
public class BabyShark{
	static int N,sr,sc,L=2,left=2;
	static int[][] sea;
	static int[][] visited;
	static int getDist() {
		Position p;
		int r,c;
		ArrayList<Position> q=new ArrayList<Position>();
		visited=new int[N][N];
		SortObj sort=new SortObj();
		q.add(new Position(sr,sc));
		int cnt=0;
		visited[sr][sc]=1;
		while(!q.isEmpty()) {
			int len=q.size();
			Collections.sort(q,sort);
			for(int i=0;i<len;i++) {
				p=q.remove(0);
				r=p.r;
				c=p.c;
				if(sea[r][c]>0&&sea[r][c]<L) {
					sea[r][c]=0;
					sea[sr][sc]=0;
					sr=r;
					sc=c;
					left--;
					if(left==0) {
						L++;
						left=L;
					}
					return cnt;
				}
				if(r-1>=0&&visited[r-1][c]==0&&sea[r-1][c]<=L) {
					visited[r-1][c]=1;
					q.add(new Position(r-1,c));
				}
				if(r+1<N&&visited[r+1][c]==0&&sea[r+1][c]<=L) {
					visited[r+1][c]=1;
					q.add(new Position(r+1,c));
				}
				if(c-1>=0&&visited[r][c-1]==0&&sea[r][c-1]<=L) {
					visited[r][c-1]=1;
					q.add(new Position(r,c-1));
				}
				if(c+1<N&&visited[r][c+1]==0&&sea[r][c+1]<=L) {
					visited[r][c+1]=1;
					q.add(new Position(r,c+1));
				}
			}
			cnt++;
		}
		return 0;
	}
	public static void main(String[] args) {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(br.readLine());
			N=Integer.parseInt(s.nextToken());
			sea=new int[N][N];
			for(int i=0;i<N;i++) {
				s=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					int t=Integer.parseInt(s.nextToken());
					sea[i][j]=t;
					if(t==9) {
						sr=i;
						sc=j;
					}
				}
			}
			int sum=0,t=0;
			do {
				t=getDist();
				sum+=t;
			}while(t!=0);
			System.out.println(sum);
		}
		catch(IOException e) {
			e.printStackTrace(System.err);
		}
	}
}