import java.util.Scanner;
public class GoingDown {
	static int N;
	static int[][] cost;
	static int[][] dyn;
	public static int minDown(int r,int c) {
		int i,t;
		int min=100000000;
		if(r==N-1) return cost[r][c];
		if(dyn[r][c]!=-1) return dyn[r][c];
		if(c==0) {
			t=minDown(r+1,0);
			if(min>t) min=t;
			t=minDown(r+1,1);
			if(min>t) min=t;
		}
		else if(c==1) {
			t=minDown(r+1,0);
			if(min>t) min=t;
			t=minDown(r+1,1);
			if(min>t) min=t;
			t=minDown(r+1,2);
			if(min>t) min=t;
		}
		else {
			t=minDown(r+1,1);
			if(min>t) min=t;
			t=minDown(r+1,2);
			if(min>t) min=t;
		}
		dyn[r][c]=min+cost[r][c];
		return dyn[r][c];
	}
	public static int maxDown(int r,int c) {
		int i,t;
		int max=-1;
		if(r==N-1) return cost[r][c];
		if(dyn[r][c]!=-1) return dyn[r][c];
		if(c==0) {
			t=maxDown(r+1,0);
			if(max<t) max=t;
			t=maxDown(r+1,1);
			if(max<t) max=t;
		}
		else if(c==1) {
			t=maxDown(r+1,0);
			if(max<t) max=t;
			t=maxDown(r+1,1);
			if(max<t) max=t;
			t=maxDown(r+1,2);
			if(max<t) max=t;
		}
		else {
			t=maxDown(r+1,1);
			if(max<t) max=t;
			t=maxDown(r+1,2);
			if(max<t) max=t;
		}
		dyn[r][c]=max+cost[r][c];
		return dyn[r][c];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		N=s.nextInt();
		cost=new int[N][3];
		dyn=new int[N][3];
		for(int i=0;i<N;i++) {
			for(int j=0;j<3;j++) {
				cost[i][j]=s.nextInt();
				dyn[i][j]=-1;
			}
		}
		s.close();
		int min=100000000;
		for(int i=0;i<3;i++) {
			int t=minDown(0,i);
			if(t<min) min=t;
		}
		for(int i=0;i<N;i++)
			for(int j=0;j<3;j++)
				dyn[i][j]=-1;
		int max=-1;
		for(int j=0;j<3;j++) {
			int t=maxDown(0,j);
			if(max<t) max=t;
		}
		System.out.println(max+" "+min);
	}

}
