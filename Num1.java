import java.util.Scanner;

public class Num1 {
	static int[] dp;
	static int N;
	static int[] tree = new int[1000001];
	
	public static int Calc(int n) {
		int t;
		if (dp[n] != 0) return dp[n];
		if (n ==1) return 0;
		if (n % 2 == 1) {
			t = Calc(n+1);
		}
		else {
			t = Calc(n/2);
		}
		dp[n] = t+1;
		return t+1;
	}
	
	public static void Update(int i, int diff) {
		while (i < N) {
			tree[i] += diff;
			i+= (i & -i);
		}
	}
	
	public static int SumTo (int i) {
		int ans =0;
		while (i>0) {
			ans += tree[i];
			i -= (i & -i);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		dp = new int[1000001];
		int[] A = new int[T];
		int[] B = new int[T];
		int max = -1;
		for (int t=0; t<T; t++) {
			A[t] = sc.nextInt();
			B[t] = sc.nextInt();
			if (max < B[t]) max = B[t];
		}
		N = max+1;
		for (int i=1; i<=max; i++)
			Calc(i);
		
		for (int i=1; i< N; i++)
			Update(i, dp[i]);

		for (int t=0; t<T; t++) {
			System.out.println("Case #"+(t+1));
			System.out.println(SumTo(B[t]) - SumTo(A[t]-1) );
		}
		sc.close();
	}

}
