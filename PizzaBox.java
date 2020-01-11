import java.util.Scanner;
import java.util.HashSet;
public class PizzaBox {
	static int M,N;
	static int[][] box;
	static HashSet<Integer>set=new HashSet();
	static void inputMax() {
		for(int i=0;i<M;i++) {
			int max=-1;
			for(int j=0;j<N;j++) {
				//System.out.print("["+box[i][j]+"] ");
				if(max<box[i][j])
					max=box[i][j];
			}
			//System.out.println();
			//System.out.println(max);
			set.add(max);
		}
		for(int k=0;k<N;k++) {
			int max=-1;
			for(int l=0;l<M;l++) {
				//System.out.print("["+box[l][k]+"] ");
				if(max<box[l][k])
					max=box[l][k];
			}
			//System.out.println();
			//System.out.println(max);
			set.add(max);
		}
	}
	static long getSum() {
		long sum=0;
		for(int i:set) {
			sum+=i;
			//System.out.println(i);
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		M=key.nextInt();
		N=key.nextInt();
		box=new int[M][N];
		long sum=0;
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				box[i][j]=key.nextInt();
				sum+=box[i][j];
			}
		}
		inputMax();
		System.out.println(sum-getSum());
		
	}

}
