package codeGround;

import java.util.Scanner;
public class FrogJump {
	static int Answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int test_case=0;test_case<T;test_case++) {
			Answer=0;
			int N=sc.nextInt();
			int[] arr=new int[N];
			for(int i=0;i<N;i++)
				arr[i]=sc.nextInt();
			int K=sc.nextInt();
			int idx=0,loc=0,obj=arr[N-1];
			while(idx<N) {
				//System.out.println("loc: "+loc+" idx:"+idx);
				int j;
				for(j=idx;j<N&&arr[j]-loc<=K;j++) {
				}
				idx=j;
				if(loc==arr[idx-1]) {
					Answer=-1;
					break;
				}
				else {
					loc=arr[idx-1];
					Answer++;
				}
			}
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

}
