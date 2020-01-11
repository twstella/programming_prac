package recursion;
import java.util.Scanner;
public class StartLink {
	public static int N;
	public static int[][] S;
	public static int[] A;
	public static int cnt1;
	public static int min=10000;
	public static void Dump() {
		/*
		for(int i=0;i<N;i++)
			System.out.print(A[i]);
		System.out.println(" gap:"+getGap());
		*/
		if(min>getGap())
			min=getGap();
	}
	public static int getGap() {
		int s=0,l=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(A[i]==A[j]&&A[i]==0)
					s+=S[i][j];
				if(A[i]==A[j]&&A[i]==1)
					l+=S[i][j];
			}
		}
		return Math.abs(s-l);
	}

	public static void combi(int n,int m,int loc){	
		if(m==0) {
			for(int i=loc;i<N;i++)
				A[i]=0;
			Dump();
			return;
		}
		else if(m==n) {
			for(int i=loc;i<N;i++)
				A[i]=1;
			Dump();
			return;
		}
		else {
			A[loc]=0;
			combi(n-1,m,loc+1);
			A[loc]=1;
			combi(n-1,m-1,loc+1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		N=key.nextInt();
		S=new int[N][N];
		A=new int[N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				S[i][j]=key.nextInt();
			}
		}
		combi(N,N/2,0);
		System.out.println(min);
		key.close();
	}

}
