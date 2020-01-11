package recursion;

public class Combination {
	public static int[] A= {0,0,0,0,0,0,0};
	public static int N=5;
	public static int cnt=0;
	public static void Dump() {
		cnt++;
		for(int i=0;i<N;i++)
			System.out.print(A[i]);
		System.out.println();
	}
	public static void combi(int n,int m,int loc){	
		if(m==0) {
			for(int i=loc;i<N;i++)
				A[i]=0;
			Dump();
			return;
		}
		else if(m==n) {
			for(int i=loc;i<N;i++)
				A[i]=1;
			Dump();
			return;
		}
		else {
			A[loc]=0;
			combi(n-1,m,loc+1);
			A[loc]=1;
			combi(n-1,m-1,loc+1);
		}
	}
	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		combi(N,2,0);
		System.out.println(cnt);
	}

}
