import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
class BPoint{
	int x,y;
	BPoint(int x,int y){
		this.x=x;
		this.y=y;
	}
}

public class Jump {
	static Stack<BPoint> stack=new Stack<BPoint>();
	public static int[][] board;
	static int[][] visited;
	static int N,cnt=0;

	static int func() {
		stack.push(new BPoint(0,0));
		visited[0][0]=1;
		while(!stack.isEmpty()) {
			BPoint t=stack.pop();
			int m=board[t.x][t.y];
			System.out.println("("+t.x+","+t.y+")"+" m:"+m);
			if(t.x-m==N-1&&t.y==N-1||t.x==N-1&&t.y-m==N-1||t.x+m==N-1&&t.y==N-1||t.x==N-1&&t.y+m==N-1) {
				cnt++;
				System.out.println("-------------------------------------------------");
				//return cnt;
			}
			if(t.x-m>=0&&board[t.x-m][t.y]!=0&&visited[t.x-m][t.y]==0) {
				stack.push(new BPoint(t.x-m,t.y));
				visited[t.x-m][t.y]=1;
			}
			if(t.y-m>=0&&board[t.x][t.y-m]!=0&&visited[t.x][t.y-m]==0) {
				stack.push(new BPoint(t.x,t.y-m));
				visited[t.x][t.y-m]=1;
			}
			if(t.x+m<N&&board[t.x+m][t.y]!=0&&visited[t.x+m][t.y]==0) {
				stack.push(new BPoint(t.x+m,t.y));
				visited[t.x+m][t.y]=1;
			}
			if(t.y+m<N&&board[t.x][t.y+m]!=0&&visited[t.x][t.y+m]==0) {
				stack.push(new BPoint(t.x,t.y+m));
				visited[t.x][t.y+m]=1;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		N=key.nextInt();
		board=new int[N][N];
		visited=new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				board[i][j]=key.nextInt();
				visited[i][j]=0;
			}
		}
		System.out.println(func());
		
	}

}
