package progrmmers;
import java.util.Scanner;
public class Floyd {
	static int N,M;
	static int[][] adjMat;
	static void allPath() {
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
					adjMat[i][j]=Math.min(adjMat[i][j],adjMat[i][k]+adjMat[k][j]);
		}
	}
	static void showMat() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				if(adjMat[i][j]==100000000)
					System.out.print(0+" ");
				else 
					System.out.print(adjMat[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s,t,w;
		Scanner key=new Scanner(System.in);
		N=key.nextInt();
		adjMat=new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				if(i==j)
					adjMat[i][j]=0;
				else
					adjMat[i][j]=100000000;
		M=key.nextInt();
		for(int i=0;i<M;i++) {
			s=key.nextInt()-1;
			t=key.nextInt()-1;
			w=key.nextInt();
			if(adjMat[s][t]>w)
				adjMat[s][t]=w;
		}
		key.close();
		allPath();
		showMat();
	}
}
