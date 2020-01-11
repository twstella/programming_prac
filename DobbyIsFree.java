package recursion;
import java.util.Scanner;
public class DobbyIsFree {
	public static int[] T;
	public static int[] P;
	public static int N;
	public static int[] a;
	public static int sum=0;
	public static int max=0;
	public static void Dump() {
		/*
		for(int i=0;i<N;i++) {
			System.out.print(a[i]);
		}
		System.out.print(" valid:"+valid(a));
		*/
		sum=0;
		if(valid(a)==1) {
			for(int i=0;i<N;i++)
				if(a[i]==1)
					sum+=P[i];
		}
		else sum=0;
		//System.out.println(" sum:"+sum);
		//System.out.println();
		if(max<sum)
			max=sum;
	}
	public static void traverse(int loc) {
		if(loc==N) {
			Dump();
		}
		else {
			for(int i=0;i<=1;i++) {
				a[loc]=i;
				traverse(loc+1);
			}
		}
	}
	
	public static int valid(int[] b) {
		for(int i=0;i<N;i++) {
			if(b[i]==1) {
				if(i+T[i]>N)
					return -1;
				for(int j=i+1;j<i+T[i];j++)
					if(b[j]==1)
						return -1;
			}
		}
		return 1;
	}
	
	public static void main(String[] args) {
		Scanner key=new Scanner(System.in);
		N=key.nextInt();
		T=new int[N];
		P=new int[N];
		a=new int[N];
		for(int i=0;i<N;i++) {
			int j=key.nextInt();
			int k=key.nextInt();
			T[i]= j;
			P[i]=k;
		}
		traverse(0);
		System.out.println(max);
		key.close();
	}
}
