package codeGround;

import java.util.Arrays;
import java.util.Scanner;
public class Exam {
	static int Answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int test_case=0;test_case<T;test_case++) {
			int N=sc.nextInt();
			int K=sc.nextInt();
			Answer=0;
			int[] arr=new int[N];
			for(int i=0;i<N;i++)
				arr[i]=sc.nextInt();
			Arrays.sort(arr);
			for(int j=N-1;j>=N-K;j--)
				Answer+=arr[j];
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

}
