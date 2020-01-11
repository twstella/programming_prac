import java.util.Scanner;

import java.util.Arrays;
public class Wood {
	static int[] arr;
	static int[] tmp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		int t=key.nextInt();
		for(int i=0;i<t;i++) {
			int m=key.nextInt();
			arr=new int[m];
			tmp=new int[m];
			for(int j=0;j<m;j++)
				arr[j]=key.nextInt();
			Arrays.sort(arr);
			for(int k=0;k<m;k++) {
				if(k%2==0)
					tmp[k/2]=arr[k];
				else if(k%2!=0)
					tmp[m-(k+1)/2]=arr[k];
			}
			int max=0;
			for(int l=0;l<m;l++) {
				if(max<Math.abs(tmp[l%m]-tmp[(l+1)%m]))
					max=Math.abs(tmp[l%m]-tmp[(l+1)%m]);
			}
			System.out.println(max);
		}
	}

}
