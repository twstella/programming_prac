import java.util.Scanner;
public class Bar {
	static int[] bars;
	static int N,L,R;
	static long cnt;
	static void func(int[] a) {
		int cntL=0,cntR=0;
		int maxl=0,maxr=0;
		for(int i=0;i<N;i++) {
			if(maxl<a[i]) {
				maxl=a[i];
				cntL++;
			}	
		}
		for(int j=N-1;j>=0;j--) {
			if(maxr<a[j]) {
				maxr=a[j];
				cntR++;
			}	
		}
		if(cntL==L&&cntR==R)
			cnt++;
		//System.out.println("cntL-"+cntL+" cntR-"+cntR+" cnt:"+cnt);
	}
	static void perm(int[] a,int loc) {
		if(loc==N)
			func(a);
		else {
			for(int i=loc;i<N;i++) {
				int tmp=a[loc];a[loc]=a[i];a[i]=tmp;
				perm(a,loc+1);
				tmp=a[loc];a[loc]=a[i];a[i]=tmp;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		int T=key.nextInt();
		for(int j=0;j<T;j++) {
			N=key.nextInt();
			bars=new int[N];
			for(int i=0;i<N;i++)
				bars[i]=i+1;
			L=key.nextInt();
			R=key.nextInt();
			cnt=0;
			perm(bars,0);
			System.out.println(cnt);
		}

	}

}
