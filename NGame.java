import java.util.Scanner;
public class NGame {
	static String H="0123456789ABCDEF";
	static String convert(int n,int num) {
		int d=num/n;
		int r=num%n;
		if(d==0) {
			if(r>=10&&r<=15) return ""+H.charAt(r);
			else return ""+r;
		}
		else {
			if(r>=10&&r<=15) return convert(n,d)+H.charAt(r);
			else return convert(n,d)+r;
		}
	}
	 public static String solution(int n, int t, int m, int p) {
	      String answer = "";
	      String tmp="";
	      for(int i=0;i<t*m;i++) {
	    	  tmp+=convert(n,i);
	    	 // System.out.println(tmp);
	      }
	      for(int i=0;i<t;i++) {
	    	  answer+=tmp.charAt(i*m+p-1);
	      }
	      return answer;
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		
		int n=s.nextInt();
		int t=s.nextInt();
		int m=s.nextInt();
		int p=s.nextInt();
		
		System.out.println(solution(n,t,m,p));
		s.close();
	}

}
