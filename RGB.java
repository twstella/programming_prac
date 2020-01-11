 import java.util.Scanner;

public class RGB {
	public static int[] house;
	public static int M;
	public static char[] color= {'R','G','B'};
	public static int[][] price;
	public static int[][] dp;
	public static int sum=0;
	public static int proc(int n,int col) {
		house[n] =col;
		if(dp[n][col]!=-1)
			return dp[n][col];
		int min=1000000000;
		if (n == M -1 ) {
			//Dump();
			dp[n][col]=price[n][col];
			return dp[n][col];
		}
		else {
			int t1=proc(n+1,(col+1)%3);
			int t2=proc(n+1,(col+2)%3);
			if(t1<t2)
				min=t1;
			else
				min=t2;
		}
		dp[n][col]=min+price[n][col];
		return dp[n][col];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		int min=10000000;
		M=key.nextInt();
		house=new int[M];
		price=new int[M][3];
		dp=new int[M][3];
		for(int i=0;i<M;i++) {
			for(int k=0;k<3;k++) {
				price[i][k]=key.nextInt();
				dp[i][k]=-1;
			}
		}
			for(int i=0;i<3;i++) {
				int t=proc(0,i);	
				if(min>t)
					min=t;
			}

		System.out.println(min);
	}
	

}
