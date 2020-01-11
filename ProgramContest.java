package codeGround;

import java.util.Scanner;
import java.util.Arrays;
public class ProgramContest {
	static int Answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int[] arr;
		for(int test_case=0;test_case<T;test_case++) {
			Answer=0;
			int n=sc.nextInt();
			arr=new int[n];
			for(int j=0;j<n;j++) {
				arr[j]=sc.nextInt();
			}
			Arrays.sort(arr);
			int cnt=1;
			int max=arr[n-1]+1;
			int add=2;
			for(int j=n-2;j>=0;j--) {
				if(arr[j]+n>=max)
					cnt++;
				if(arr[j]+add>max)
					max=arr[j]+add;
				add++;
			}
			Answer=cnt;
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}
}
