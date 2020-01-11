package recursion;

public class Fibo {
	public static int cnt=0;
	public static int fibo(int n) {
		cnt++;
		if(n==0)
			return 1;
		else if(n==1)
			return 1;
		else
			return fibo(n-1)+fibo(n-2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int a=fibo(10);
		System.out.println(a);
		System.out.println(cnt);
	}

}
