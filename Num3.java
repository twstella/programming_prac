import java.util.Scanner;
public class Num3 {
	static short[][] dp;
	public static short Jump(int left, int inc) {
		if (left == 0) return 0;
		else if (left <0) return 20000;
		if (dp[left][inc] != -1) return dp[left][inc];
		short t1= Jump(left-inc, inc+1);
		short t2= Jump(left-1, 2);
		if (t1 < t2) dp[left][inc]=t1;	
		else dp[left][inc]=t2;
		dp[left][inc]++;
		return dp[left][inc];
	}
	
	public static void main(String[] args) {
		dp  = new short[10001][10001];
		for (int i=0; i<10001; i++)
			for (int j=0; j<10001; j++)
				dp[i][j] = -1;
		
//System.out.println(Jump(14,1) +" "+dp[14][1]);

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=0; t<T; t++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			short max = -1;
			for (int i=n1; i<=n2; i++) {
				short u = Jump(i,1);
				if ( u> max) max = u;
			}
			System.out.println("Case #"+(t+1));
			System.out.println(max);
		}
		sc.close();
	}
}
