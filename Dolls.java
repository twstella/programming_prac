/*
 5 3
 1 2 3 4 5
 10 3
 1 4 1 5 9 2 6 5 3 5
 5 4
 1 4 1 1 6
 */
import java.util.Scanner;

public class Dolls {
	static int N, M;
	static int[]  dolls;
	
	public static double StdDev(int f, int le) {
		double sum =0.0, avg;
		System.out.println(f+ " "+ le);
		for (int i=f; i< f+le; i++)
			sum += dolls[i];
		avg = sum / le;
		//System.out.println("avg:"+avg);
		sum = 0;
		for (int i=f; i< f+le; i++)
			sum += (avg-dolls[i])*(avg-dolls[i]);
		sum /= le;
		System.out.println("v:"+sum);
		return (Math.sqrt(sum));
	}
	
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		N = key.nextInt();
		M = key.nextInt();
		dolls = new int[N];
		for(int i=0; i<N; i++)
			dolls[i] = key.nextInt();
		key.close();
		double min = 999999999.0;
		for (int j=M; j<=N; j++) {
			for (int i=0; i<= N-j; i++) {
				double sd = StdDev(i, j);
				if (sd < min)
					min = sd;
			}
		}
		System.out.println(min);
	}
}

