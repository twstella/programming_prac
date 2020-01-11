import java.util.Scanner;

public class Prize {
	public static int firstPrize[]= {500,300,200,50,30,10};
	public static int secondPrize[]= {512,256,128,64,32};
	public static int levelA[]= {1,3,6,10,15,21};
	public static int levelB[]= {1,3,7,15,31};
		public static int first(int n) {
			if(n==0)
				return 0;
			for(int i=0;i<levelA.length;i++) {
				if(n<=levelA[i]) {
					return firstPrize[i];
				}
			}
			return 0;
		}
		public static int second(int n) {
			if(n==0)
				return 0;
			for(int i=0;i<levelB.length;i++) {
				if(n<=levelB[i]) {
					return secondPrize[i];
				}
			}
			return 0;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		int m=key.nextInt();
		for(int i=0;i<m;i++) {
			int f=key.nextInt();
			int s=key.nextInt();
			System.out.println((first(f)+second(s))*10000);
		}
		key.close();
	}

}
