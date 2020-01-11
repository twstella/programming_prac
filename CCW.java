import java.util.Scanner;
public class CCW {
	static long[] x;
	static long[] y;
	static int area() {
		long sum=0;
		sum=x[0]*y[1]-x[1]*y[0];
		sum+=x[1]*y[2]-x[2]*y[1];
		sum+=x[2]*y[0]-x[0]*y[2];
		if(sum>0) return 1;
		else if(sum==0) return 0;
		else return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		x=new long[3];
		y=new long[3];
		for(int i=0;i<3;i++) {
			x[i]=key.nextLong();
			y[i]=key.nextLong();
		}
		System.out.println(area());
	}

}
