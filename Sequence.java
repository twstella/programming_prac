import java.util.Scanner;

public class Sequence {
	static int N;
	static int[] S;
	static int[] R;
	static void printS() {
		for(int i=0;i<N;i++)
			System.out.print(S[i]+" ");
		System.out.println();
	}
	static void printR() {
		for(int i=0;i<N;i++)
			System.out.print(R[i]+" ");
		System.out.println();
	}
	static void func() {
		int j,k;
		for(int i=0;i<N;i++) {
			for(j=N-1;j>=0;j--) {
				if(R[j]==0)
					break;
			}
			if(j==-1) {
				System.out.println("IMPOSSIBLE");
				return;
			}
			S[j]=i+1;R[j]=N+1;
			for(k=j+1;k<N;k++)
				R[k]--;
		}
		printS();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		int t=key.nextInt();
		for(int i=0;i<t;i++) {
			N=key.nextInt();
			S=new int[N];
			R=new int[N];

			for(int j=0;j<N;j++) {
				R[j]=key.nextInt();
			}
			func();
		}
	}

}
