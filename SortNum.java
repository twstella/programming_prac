package codeGround;

import java.util.Scanner;
import java.util.Arrays;
public class SortNum {
	static int Answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int test_case=0;test_case<T;test_case++) {
			Answer=0;
			int n=sc.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
			Arrays.sort(arr);
			for(int i=0;i<n;i++) {
				if(i%2!=0)
					Answer+=-arr[i];
				else 
					Answer+=arr[i];
			}
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

}
