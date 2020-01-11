import java.util.Scanner;

public class Virus2 {
	public static int M;
	public static int[] lc;
	public static int[] rc;
	public static int min=1000000000;

/*
	public static int getHeight(int n) {
		if(n==-1) {
			return 0;
		}
		int lh=getHeight(lc[n]);
		int rh=getHeight(rc[n]);
		return (lh>rh)?1+lh:1+rh;
	}

	public static void Dump() {
		int t=getHeight(0);
		if(t<min)
			min=t;
	}
	public static void test(int n) {
		if(n==-1) {
			Dump();
			return;
		}
//		int t=lc[n];
//		lc[n]=-1;
		//print();
		test(rc[n]);
//		lc[n]=t;
//		rc[n]=-1;
		//print();
		test(lc[n]);
	}
*/
	
	public static void DfsTree(int n, int d) {
		if (n==-1) return;
		
		//System.out.println(n);
		/*
		if (lc[n]== -1 && rc[n]==-1) {
			System.out.println("Leaf " + d);
		}
		
		else 
		*/
		if(lc[n]==-1||rc[n]==-1) {
			//System.out.println(d);
			if(min>d)
				min=d;
			return;
		}
		else {
			DfsTree(lc[n], d+1);
			DfsTree(rc[n], d+1);
		}
	}
	
	public static void ShowTree() {
		for(int i=0;i<M;i++) {
			System.out.println(lc[i]+" "+rc[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		M=key.nextInt();
		lc=new int[M];
		rc=new int[M];

		for(int i=0;i<M;i++) {
			lc[i]=key.nextInt()-1;
			rc[i]=key.nextInt()-1;
		}
		ShowTree();
		DfsTree(0, 1);
		System.out.println(min);
//		test(0);
//		//System.out.println(getHeight(0));
//		System.out.println(min);
	}

}
