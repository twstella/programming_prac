import java.util.Scanner;
public class Bracket {
	static String str;
	static boolean VDS() {
		int cnt=0;
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			//System.out.print(c+" ");
			if(c=='(')
				cnt++;
			else if(c==')') {
				cnt--;
				if(cnt<0)
					break;
			}
				
				
		}
		if(cnt==0)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		int n=key.nextInt();
		for(int i=0;i<n;i++) {
			str=key.next();
			boolean ans=VDS();
			if(ans==true)
				System.out.println("YES");
			else if(ans==false)
				System.out.println("NO");
		}
	}
}
