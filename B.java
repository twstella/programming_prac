import java.util.Scanner;

public class B {
	public static int[] prefer;
	public static int N,K;
	public static double function(int s,int k) {
		double avg=0.0,v=0.0;
		//System.out.println(s+ " "+ k);
			for(int j=s;j<s+k;j++) {
				avg+=(prefer[j]);
			}
			
			avg/=k;
			//System.out.println("avg:"+avg);
			for(int j=s;j<s+k;j++) {
				v+=((prefer[j]-avg)*(prefer[j]-avg));
			}
			v/=k;
			//System.out.println("v:"+v);
		return Math.sqrt(v);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		N=key.nextInt();
		K=key.nextInt();
		prefer=new int[N];
		for(int i=0;i<N;i++)
			prefer[i]=key.nextInt();
		double min=999999999.0;
		for(int j=K;j<=N;j++){
			 for(int i=0;i<=N-j;i++){
				double tmp=function(i,j);
				if(min>tmp)
					min=tmp;
			}
		}
		System.out.println(min);
	}

}
