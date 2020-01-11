import java.util.Scanner;
public class Taxiprob {

	public static void main(String[] args) {
		int r;
		double U,T,x;
		Scanner key=new Scanner(System.in);
		r=key.nextInt();
		U=r*r*3.14159265358979323;
		x=Math.sqrt(r*r+r*r);
		T=x*x;
		System.out.printf("%.6f", U);
		System.out.println();
		System.out.printf("%.6f", T);
		key.close();

	}

}
