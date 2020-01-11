import java.util.Scanner;
public class Dupli {
	static int n,s;
	static boolean eval() {
		while(n!=0) {
			if(n%10!=s%10) {
				return false;
			}
			n/=10;
			s/=10;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		int t=key.nextInt();
		for(int i=0;i<t;i++) {
			n=key.nextInt();
			//System.out.println(n);
			s=n*n;
			if(eval())
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
	}

}
