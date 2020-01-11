package codeGround;
import java.util.Scanner;
import java.util.ArrayList;
public class FindPrime {
	static int Answer;
	static ArrayList<Integer> prime;
	static int[] dy;
	static boolean isPrime(int n) {
		if(n==1||n==0) return false;
		for(int j=2;j*j<=n;j++) {
			if(n%j==0)
				return false;
		}
		return true;
	}
	static int find(int n) {
		int ans=0;
		if(dy[n]!=-1) return dy[n];
		if(!prime.contains(n)) {
			dy[n]=0;
			return dy[n];
		}
		else {
			for(int t=1;t<n;t*=10) {
				int tmp=0;
				tmp+=find(n/(t*10)*t+n%t);
				if(ans<tmp) ans=tmp;	
			}
			dy[n]=1+ans;
		}
		return dy[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		prime=new ArrayList<Integer>();
		dy=new int[30001];
		for(int i=2;i<=30000;i++) {
			dy[i]=-1;
			if(isPrime(i))
				prime.add(i);
		}
		dy[30000]=-1;
		for(int test_case=0;test_case<T;test_case++) {
			int A=sc.nextInt();
			int B=sc.nextInt();
			int a,b;
			if(!prime.contains(A))
				a=0;
			else a=find(A);
			if(!prime.contains(B))
				b=0;
			else b=find(B);
			if(a==b) Answer=3;
			else if(a>b) Answer=1;
			else Answer=2;
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

}
