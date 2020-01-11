package codeGround;

import java.util.Scanner;
public class QuickSort {
	static int Answer;
	static int[] max;
	static int[] min;
	static void srhRight(int[] arr) {
		min[arr.length-1]=arr[arr.length-1];
		for(int i=arr.length-2;i>=0;i--) {
			if(min[i+1]<arr[i])
				min[i]=min[i+1];
			else
				min[i]=arr[i];
		}
	}
	static void srhLeft(int[] arr) {
		max[0]=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(max[i-1]>arr[i])
				max[i]=max[i-1];
			else
				max[i]=arr[i];
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int test_case=0;test_case<T;test_case++) {
			Answer=0;
			int N=sc.nextInt();
			int[] arr=new int[N];
			max=new int[N];
			min=new int[N];
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextInt();
			}
			srhLeft(arr);
			srhRight(arr);
			for(int j=0;j<N;j++)
				if(max[j]<=arr[j]&&min[j]>=arr[j])
					Answer++;
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

}
