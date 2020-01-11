import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;


public class Happy {
	public static int Square(int n) {
		int sum,r;
		sum=0;
		while(n!=0) {
			r=n%10;
			sum+=r*r;
			n=n/10;
		}
		return sum;
	}
	public static boolean isHappy(int n) {
		HashSet<Integer> hset=new HashSet<Integer>();
		int k;
		k=n;
		while(true) {
			//System.out.println(k);
			if(k==1)
				return true;
			else {
				if(hset.contains(k)==true)
					return false;
				else
					hset.add(k);
			}
			k=Square(k);
		}
	}
	public static void main(String[] args) {
		int n;
		boolean a;
		Scanner key=new Scanner(System.in);
		n=key.nextInt();
		a=isHappy(n);
		if(a==true)
			System.out.print("HAPPY");
		else
			System.out.print("UNHAPPY");
	}

}
