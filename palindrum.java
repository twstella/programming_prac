import java.util.Arrays;
import java.util.Scanner;
public class palindrum {
	static int[] Num=new int[100];
	public static int check(int k,int b) {
		int q=k/b,r=k%b,i=0,j,l,m;
		Num[i++]=r;
		while(q!=0) {
			m=q;
			q=m/b;
			r=m%b;
			Num[i++]=r;
		}
		for(j=0,l=i-1;j<i;j++,l--) {
			if(Num[j]!=Num[l]) {
				return 0;
			}
		}
		return 1;
	}
	public static void main(String[] args) {
		int i,n,r,S,s;
		Scanner key=new Scanner(System.in);
		S=key.nextInt();
		for(s=0;s<S;s++) {
			n=key.nextInt();
			r=0;
			for(i=2;i<=64;i++) {
				if(check(n,i)==1) {
					r=1;
					break;
				}
			}
			System.out.print(r);
			System.out.println();
		}
		key.close();
	}

}
