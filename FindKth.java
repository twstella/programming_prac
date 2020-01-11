package basic;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class FindKth {
	static int N,K;
	static int[] A,B,C,F;
	
	public static void ShowVec(int[] v) {
		for(int i=0;i<N/2;i++)
			System.out.print(v[i]+" ");
		System.out.println();
		for(int i=N/2;i<N;i++)
			System.out.print(v[i]+" ");
		System.out.println();
		System.out.println();
	}
	public static void RadixSort(int[] A) {
		int[] B=new int[N];
		int[] C=new int[10];
		int[] F=new int[10];
		int[] t1,t2;
		int m=1;
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++)
				C[j]=0;
			if(i%2==0) {
				t1=A;t2=B;
			}
			else {
				t1=B;
				t2=A;
			}
			for(int j=0;j<N;j++) {
				int u=(t1[j]/m)%10;
				C[u]++;
			}
			F[0]=0;
			for(int j=1;j<10;j++)
				F[j]=F[j-1]+C[j-1];
			for(int j=0;j<N;j++) {
				int u=(t1[j]/m)%10;
				t2[F[u]++]=t1[j];
			}
			m*=10;
		}
		return;
	}
	public static void main(String[] args) {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(br.readLine());
			N=Integer.parseInt(s.nextToken());
			K=Integer.parseInt(s.nextToken());
			A=new int[N];
			s=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
				A[i]=Integer.parseInt(s.nextToken())+1000000000;
			RadixSort(A);
			System.out.println(A[K-1]-1000000000);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
