import java.util.Scanner;
import java.util.Vector;

public class Reverse {
	static Vector<Integer> unit=new Vector(6);
	static int n,sum,cnt;
	static int addRev() {
		int n=0;
		for(int i=0;i<unit.size();i++)
			n=n*10+unit.get(i);
		return n;
	}
	static boolean isPali(Integer n) {
		String str=n.toString();
		for(int i=0,j=str.length()-1;i<str.length();i++,j--)
			if(str.charAt(i)!=str.charAt(j))
				return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		int t=key.nextInt();
		for(int i=0;i<t;i++) {
			n=key.nextInt();
			int k=n;
			cnt=0;
			while(k!=0) {
				unit.add(k%10);
				k/=10;
				cnt++;
			}
			sum=n+addRev();
			if(isPali(sum))
				System.out.println("YES");
			else
				System.out.println("NO");
			unit.clear();
		}
	}

}
