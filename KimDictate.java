package codeGround;

import java.util.Scanner;
import java.util.ArrayList;
public class KimDictate {
	static int Answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
			int N=sc.nextInt();
			int M=sc.nextInt();
			Answer=1;
			int[] a=new int[M];
			int[] b=new int[M];
			boolean[] A=new boolean[N+1];
			for(int i=0;i<N+1;i++)
				A[i]=false;
			for(int i=0;i<M;i++) {
				a[i]=sc.nextInt();
				b[i]=sc.nextInt();
				A[b[i]]=!A[a[i]];
			}
			for(int i=0;i<M;i++) {
				if(A[a[i]]==A[b[i]]) {
					Answer=0;
					break;
				}
			}
			System.out.println(Answer);
	}

}
