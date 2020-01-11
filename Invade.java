import java.util.Stack;
import java.util.Scanner;

class Point{
	int r,c;
	Point(int r,int c){
		this.r=r;
		this.c=c;
	}
}
public class Invade{
	static Stack<Point> stack=new Stack();
	static int M,N;
	static int[][] matter,visited;
	public static int function() {
		int ans=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				for(int k=0;k<N;k++)
					visited[j][k]=0;
			if(matter[0][i]==0&&visited[0][i]==0) {
				stack.push(new Point(0,i));
				visited[0][i]=1;
				//System.out.println("("+0+","+i+")");
			}
		
			while(!stack.isEmpty()) {
				Point t=stack.remove(stack.size()-1);
				//System.out.println(t.r+","+t.c);
				if(t.r-1>=0&&matter[t.r-1][t.c]==0&&visited[t.r-1][t.c]==0) {
					stack.push(new Point(t.r-1,t.c));
					visited[t.r-1][t.c]=1;
				}
				if(t.c-1>=0&&matter[t.r][t.c-1]==0&&visited[t.r][t.c]==0) {
					stack.push(new Point(t.r,t.c-1));
					visited[t.r][t.c-1]=1;
				}
				if(t.r+1<M&&matter[t.r+1][t.c]==0&&visited[t.r+1][t.c]==0) {
					stack.push(new Point(t.r+1,t.c));
					visited[t.r+1][t.c]=1;
				}
				if(t.r+1==M-1) {
					ans=1;
					return ans;
				}
				if(t.c+1<N&&matter[t.r][t.c+1]==0&&visited[t.r][t.c+1]==0) {
					stack.push(new Point(t.r,t.c+1));
					visited[t.r][t.c+1]=1;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner key=new Scanner(System.in);
		M=key.nextInt();
		N=key.nextInt();
		matter=new int[M][N];
		visited=new int[M][N];
		for(int i=0;i<M;i++) {
			String s=key.next();
			for(int j=0;j<N;j++)
				matter[i][j]=s.charAt(j)-'0';
		}
		int ans=function();
		if(ans==1)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
}
/*
import java.util.Scanner;
import java.util.Stack;

class RPoint{
	int r,c;
	RPoint(int r,int c){
		this.r=r;
		this.c=c;
	}
}

public class Invade{
	static Stack <RPoint> stack=new Stack();
	public static int[][] fabric;
	public static int[][] visited;
	public static int M,N;
	public static int check() {
		int ans=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++)
				for(int k=0;k<N;k++)
					visited[j][k]=0;
			if(fabric[0][i]==0&&visited[0][i]==0) {
				stack.push(new RPoint(0,i));
				//System.out.println("(0,"+i+")");
			visited[0][i]=1;
			}
			while(!stack.isEmpty()) {
				RPoint t=stack.remove(stack.size()-1);
				//System.out.println("("+t.r+","+t.c+")");
				if(t.r-1>=0&&fabric[t.r-1][t.c]==0&&visited[t.r-1][t.c]==0) {
					stack.push(new RPoint(t.r-1,t.c));
					visited[t.r-1][t.c]=1;
				}
				if(t.c-1>=0&&fabric[t.r][t.c-1]==0&&visited[t.r][t.c-1]==0) {
					stack.push(new RPoint(t.r,t.c-1));
					visited[t.r][t.c-1]=1;
				}
				if(t.r+1<M&&fabric[t.r+1][t.c]==0&&visited[t.r+1][t.c]==0) {
					stack.push(new RPoint(t.r+1,t.c));
					visited[t.r+1][t.c]=1;
				}
				if(t.r+1==M) {
					ans=1;
					return ans;
				}
				if(t.c+1<N&&fabric[t.r][t.c+1]==0&&visited[t.r][t.c+1]==0) {
					stack.push(new RPoint(t.r,t.c+1));
					visited[t.r][t.c+1]=1;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		int ans=0;
		 M=key.nextInt();
		 N=key.nextInt();
		fabric=new int[M][N];
		visited=new int[M][N];
		for(int i=0;i<M;i++) {
			String s=key.next();
			for(int j=0;j<N;j++)
				fabric[i][j]=s.charAt(j)-'0';
		}
			
		ans=check();
		if(ans==1)
			System.out.println("YES");
		else
			System.out.println("NO");
		}
}

*/