import java.util.Arrays;
import java.util.Scanner;

public class Wheel {
	public static int change(int n,int[][] a,int m) {
		int i,s=0;
		for(i=0;i<m;i++)
			s=10*s+a[n][i];
		return s;
	}
	public static int toNum(int a[]) {
		int s=0,i;
		for(i=0;i<a.length;i++)
			s=10*s+a[i];
		return s;
	}
	public static int Answer(int x,int y,int a[]) {
		int i,count=0;
		for(i=0;i<a.length;i++) {
			if((x<=a[i])&&(a[i]<=y))
				count++;
		}
		return count;
	}
	public static void main(String[] args) {
		int i,j,k,N,M,T,s,x,y;
		
		Scanner key=new Scanner(System.in);
		T=key.nextInt();
		for(s=0;s<T;s++) {	
			N=key.nextInt();
			M=key.nextInt();
			int[] X=new int[M];
			int[] Y=new int[M];
			int[] pWheel=new int[N];
			int[][] num=new int[N][M];
			int[] c=new int[N];
			for(i=0;i<M;i++)
				X[i]=key.nextInt();
			for(i=0;i<M;i++)
				Y[i]=key.nextInt();
			x=toNum(X);
			y=toNum(Y);
			for(i=0;i<N;i++)
				pWheel[i]=key.nextInt();
			for(i=0;i<N;i++) {
				j=0;
					for(k=i;k<=i+M-1;k++) {
						if(k>=N)
							num[i][j++]=pWheel[k-N];
						else
						num[i][j++]=pWheel[k];
					}
			}
			for(i=0;i<N;i++) {
					c[i]=change(i,num,M);
			}
			//System.out.println(x+" "+y);
			System.out.println(Answer(x,y,c));
		}
		key.close();
	}

}
