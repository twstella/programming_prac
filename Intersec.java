import java.util.Scanner;

public class Intersec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		int n=key.nextInt();
		int d=n*(n-3)/2;
		int i;
		if(d==0)
			i=0;
		else
			i=d*(d-2)/2;
		System.out.println(i);
	}

}
