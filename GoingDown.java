import java.util.Scanner;

public class GoingDown {
	
	public static int[][] board;
	public static int M;
	public static int[][] dp;
	
	public static int minGoDown(int r,int c) {
		//System.out.println(r+","+c);
		if(r==M-1) {
			//dp[r][c]=board[r][c];
			return board[r][c];
		}
		if(dp[r][c]!=-1) {
			return dp[r][c];
		}
		
		int t[]=new int[3];
		
		if(c==0) {
			t[0]=1000000000;
			t[1]=minGoDown(r+1,0);
			t[2]=minGoDown(r+1,1);
		}
		else if(c==1) {
			t[0]=minGoDown(r+1,0);
			t[1]=minGoDown(r+1,1);
			t[2]=minGoDown(r+1,2);
		}
		else{
			t[0]=minGoDown(r+1,1);
			t[1]=minGoDown(r+1,2);
			t[2]=1000000000;
		}
		int min=t[0];
		for(int i=1;i<3;i++)
			if(min>t[i])
				min=t[i];
	//System.out.println("min:"+min);
		dp[r][c]=board[r][c]+min;
		return dp[r][c];
	}
	
	public static int maxGoDown(int r,int c) {
		//System.out.println(r+","+c);
		
		if(r==M-1) {
			dp[r][c]=board[r][c];
			return dp[r][c];
		}
		
		if(dp[r][c]!=-1)
			return dp[r][c];
		
		int t[]=new int[3];
		if(c==0) {
			t[0]=0;
			t[1]=maxGoDown(r+1,0);
			t[2]=maxGoDown(r+1,1);
		}
		else if(c==1) {
			t[0]=maxGoDown(r+1,0);
			t[1]=maxGoDown(r+1,1);
			t[2]=maxGoDown(r+1,2);
		}
		else{
			t[0]=maxGoDown(r+1,1);
			t[1]=maxGoDown(r+1,2);
			t[2]=0;
		}
		int max=t[0];
		for(int i=1;i<3;i++)
			if(max<t[i])
				max=t[i];
		//System.out.println("max:"+max);
		dp[r][c]=max+board[r][c];
		return dp[r][c];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		M=key.nextInt();
		board=new int[M][3];
		for(int i=0;i<M;i++)
			for(int j=0;j<3;j++)
				board[i][j]=key.nextInt();
		key.close();
		
		int min=100000000;
		int max=-1;
		dp=new int[M][3];
		
		for(int i=0;i<M;i++)
			for(int j=0;j<3;j++)
				dp[i][j]=-1;
		
		for(int i=0;i<3;i++) {
			int tmp=minGoDown(0,i);
			if(tmp<min)
				min=tmp;
		}
		
		for(int i=0;i<M;i++)
			for(int j=0;j<3;j++)
				dp[i][j]=-1;
		
		for(int i=0;i<3;i++) {
			int tp=maxGoDown(0,i);
			if(tp>max)
				max=tp;
		}
		System.out.println(max+" "+min);
	}

}
