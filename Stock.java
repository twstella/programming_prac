import java.util.Arrays;
import java.util.Scanner;

public class Stock {
	static int[] stock=new int[1000001];
	static int[] index=new int[1000001];
	static int s;
	public static void main(String[] args) {
		int k=0,i,j,maxi,S,l,max;
		long sum;
		Scanner key=new Scanner(System.in);
		S=key.nextInt();
		for(l=0;l<S;l++) {
			s=key.nextInt();

			for(i=0;i<s;i++) {
				stock[i]=key.nextInt();
			}
			max=stock[s-1];
			maxi=s-1; index[s-1] = s-1;
			for(i=s-2;i>=0;i--) {
				if(max<stock[i]) {
					max=stock[i];
					maxi=i;
					index[i]=i;
				}
				else
					index[i]=maxi;
			}
/*
			for (i=0; i<s; i++)
				System.out.print(index[i]+" ");
			System.out.println();
*/		
			sum=0;
			for (i=0; i<s; i++)
				sum+=stock[index[i]]-stock[i];
			System.out.println(sum);
		}
		
		key.close();
	}

}
