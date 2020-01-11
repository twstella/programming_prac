import java.util.Arrays;
import java.util.Scanner;

public class primeNum {
	static int l;
	
	public static boolean isPrime(int n) {
		int i,s;
		s=(int)Math.sqrt(n);
		for(i=2;i<=s;i++) {
			if((n%i)==0) 
				return false;
		}
		return true;
	}
	
	public static int isSum(int[] n, int[] a, int s) {
		int i,j,k;

		for(i=0;i<l;i++) {
			for(j=0;j<l;j++) {
				for(k=0;k<l;k++) {
					if(a[i]+a[j]+a[k]==s) {
						n[0]=a[i];
						n[1]=a[j];
						n[2]=a[k];
						Arrays.sort(n);
						return 1;
					}
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int S,m,i,j,k,x,n,r;
		
		int[] a=new int[1000];
		int[] num=new int[3];
		
		l= 0;
		for(i=2;i<=1000;i++) {
			if(isPrime(i)==true) {
				a[l++]=i;
//				System.out.print(a[l-1] + " ");
			}
		}
		
		Scanner key=new Scanner(System.in);
		S=key.nextInt();
		for(m=0;m<S;m++) {
			n=key.nextInt();
			x=isSum(num,a,n);
			if(x==1) {
				for(i=0;i<3;i++)
					System.out.printf("%d ", num[i]);
			}
			else
				System.out.print(x);
			System.out.println();
		}
		key.close();
	}

}