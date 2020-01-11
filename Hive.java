import java.util.Scanner;
public class Hive {
	static int func(int n) {
		if(n==1)
			return 1;
		int t=1,cnt=0,i=1;
		while(true) {
			t+=i*6;
			if(t>=n)
				break;
			cnt++;
			i++;
		}
		return cnt+2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		int n=key.nextInt();
		System.out.println(func(n));
	}

}
