import java.util.Scanner;

public class BlackChain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		long n=key.nextLong();
		long tmp=0;
		long m=2;
		int i=0;
		for(i=1;i<100;i++) {
			m*=2;
			tmp=i+(i+1)*(m-1);
			if(tmp>=n) { 
				System.out.println(i);
				break;
			}
		}
		key.close();
	}

}
