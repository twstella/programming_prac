package codeGround;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Similarity {
	static int[] A, B;
	static short[][] dp;
	static short[][] dps;
	static int N;
	
	public static void FillDp() {
	
// odd numbers
		for (int i=0; i<N; i++) {
			int f =i, t=i;
			if (A[f] == B[t]) dp[f][t] =1;
			else dp[f][t] =0;
			while (f-1>=0 && t+1<N) {
				short cnt = dp[f][t];
				if (A[f-1] == B[t+1]) cnt++;
				if (B[f-1] == A[t+1]) cnt++;
				dp[f-1][t+1] = cnt ;
				f--; t++;
			}
		}

// even numbers
		for (int i=0; i<N-1; i++) {
			int f =i, t=i+1;
			short cnt = 0;
			if (A[f] == B[t]) cnt++;
			if (B[f] == A[t]) cnt++;
			dp[f][t] =cnt;
			
			while (f-1>=0 && t+1<N) {
				cnt = dp[f][t];
				if (A[f-1] == B[t+1]) cnt++;
				if (B[f-1] == A[t+1]) cnt++;
				dp[f-1][t+1] = cnt ;
				f--; t++;
			}
		}
	}
	public static void FillSdp() {
		for (int i=0; i<N; i++) {
			if (A[i] == B[i]) dps[i][i] = 1;
			else dps[i][i] = 0;
			for (int j=i+1; j<N; j++) {
				dps[i][j] = dps[i][j-1];
				if (A[j] == B[j])
					dps[i][j]++;
			}	
		}
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer( br.readLine() );	
			int T = Integer.parseInt(st.nextToken());
			
			for (int t =0; t<T; t++) {
				st = new StringTokenizer( br.readLine() );
				N = Integer.parseInt(st.nextToken());
				A = new int[N];
				B = new int[N];
				st = new StringTokenizer( br.readLine() );
				for (int i=0; i<N;i++)
					A[i] = Integer.parseInt(st.nextToken());
				st = new StringTokenizer( br.readLine() );
				for (int i=0; i<N;i++)
					B[i] = Integer.parseInt(st.nextToken());
				
				dp = new short[N][N];
				dps = new short[N][N];
		
				FillDp();
				FillSdp();
	
				
				int max = dps[0][N-1];
				for (int i=0; i<N; i++)
					for (int j=i; j<N; j++) {
						int cnt =0;
						if (i-1 >=0) cnt = dps[0][i-1];
						if (j-1 >= i) cnt += dp[i][j];
						if (j+1 < N) cnt += dps[j+1][N-1];
						if (cnt > max) max = cnt;
		//				System.out.println(cnt);
					}
				String res = "Case #"+(t+1) +"\n"+max;
				System.out.println(res);
			}
		}
	    catch (IOException e) {
	         System.out.println("Error: " + e);
	    }
	}
}