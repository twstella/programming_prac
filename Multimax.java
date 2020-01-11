import java.util.Arrays;
import java.util.Scanner;

public class Multimax {

	public static void main(String[] args) {
		int m,md,i,n;
		Scanner key=new Scanner(System.in);
		n=key.nextInt();
		int[] t=new int[n];
		for(i=0;i<n;i++)
			t[i]=key.nextInt();
		key.close();
		/*
		for(i=0;i<n;i++)
			System.out.printf("%d ",t[i]);
		System.out.println();
		*/
		Arrays.sort(t);
		/*
		for(i=0;i<n;i++)
			System.out.printf("%d ",t[i]);
		*/	
		m=t[0]*t[1];
		md=t[0]*t[1]*t[n-1];
		if(m<md)
			m=md;
		md=t[n-2]*t[n-1];
		if(m<md)
			m=md;
		md=t[n-3]*md;
		if(m<md)
			m=md;
		System.out.println(m);
	}

}
