import java.util.Arrays;
import java.util.Scanner;
public class Publication {
	public static int qIndex(int n,int[] a) {
		int count,ind,i;
		Arrays.sort(a);
		count=0;
		ind=n-1;
		for(i=n;i>=0;i--) {
			while(a[ind]>=i) {
				count++;
				ind--;
				if(ind<0)
					break;
			}
			if(count>=i)
				break;
		}
		return i;
	}

	public static void main(String[] args) {
		int n,i,k;
		Scanner key=new Scanner(System.in);

		n=key.nextInt();
		int[] a=new int[n];
		for(i=0;i<n;i++)
			a[i]=key.nextInt();
		k=qIndex(n,a);
		System.out.println(k);
		key.close();
	}

}
