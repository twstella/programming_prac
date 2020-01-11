import java.util.Arrays;
import java.util.Scanner;

public class LogJump {

		public static void main(String[] args) {
			int n,i,j,m,md,S,s;
			Scanner key=new Scanner(System.in);
			S=key.nextInt();	
			for(s=0;s<S;s++) {
				n=key.nextInt();
				int[] t=new int[n];
				for(i=0;i<n;i++)
					t[i]=key.nextInt();

				Arrays.sort(t);
				int[] a=new int[n];
				int f=0,r=n-1;
				for(i=0;i<n;i++) {
					if((i%2)==0)
						a[f++]=t[i];
					else
						a[r--]=t[i];
				}
				/*
				for(i=0;i<n;i++) {
					System.out.printf("%d ",a[i]);
				}
				System.out.println();
				*/
				m=0;
				md=Math.abs(a[0]-a[n-1]);
				for(i=0;i<n-1;i++) {
					md=Math.abs(a[i]-a[i+1]);
					if(m<md)
						m=md;
				}
				System.out.print(m);
				System.out.println();
			}
			key.close();
	}

}
