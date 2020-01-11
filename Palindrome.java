package codeGround;

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;
public class Palindrome {
	static int Answer;
	static boolean isPalin(Integer n) {
		String str=n.toString();
		for(int i=0,j=str.length()-1;i<str.length()-1;i++,j--) {
			if(str.charAt(i)!=str.charAt(j))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int test_case=0;test_case<T;test_case++) {
			Integer N=sc.nextInt();
			Answer=0;
			int min=4;
			ArrayList<Integer> list=new ArrayList<Integer>();
			PriorityQueue<Integer> ans=new PriorityQueue<Integer>();
			for(int i=N;i>=1;i--) {
				if(isPalin(i)) {
					if(i==N) {
						Answer=1;
						ans.add(-i);
						break;
					}
					list.add(i);
				}
			}
			for(int j=0;j<list.size();j++) {
				int t=list.get(j);
				for(int k=j;k<list.size();k++) {
					int m=list.get(k);
					if(m+t>N)
						continue;
					if(t+m==N&&min>2) {
						Answer=2;
						min=Answer;
						ans.clear();
						ans.add(-t);
						ans.add(-m);
						break ;
					}
					if(list.contains(N-t-m)&&min>3) {
						Answer=3;
						min=Answer;
						ans.clear();
						ans.add(-t);
						ans.add(-m);
						ans.add(t+m-N);
						break ;
					}
				}
			}
			System.out.println("Case #"+(test_case+1));
			System.out.print(Answer+" ");
			for(int a:ans) {
				System.out.print(-a+" ");
			}
			System.out.println();
		}
	}

}
