import java.util.Scanner;
import java.util.ArrayList;
public class Enumeration {
	static ArrayList<String> sen=new ArrayList<String>();
	static String[] arr;
	public static void combi(String t,int[] v,int s,int n,int r) {
		if(r==0) {
			String k="";
			for(int i=0;i<n;i++) {
				if(v[i]==1) {
					k+=t.charAt(i);
				}
			}
			sen.add(k);
			
			return;
		}
		else {
			for(int i=s;i<n;i++) {
				v[i]=1;
				combi(t,v,i+1,n,r-1);
				v[i]=0;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int k=s.nextInt();
		String t=s.next();
		String S=s.next();
		String T=s.next();
		int[] v=new int[t.length()];
		combi(t,v,0,n,k);
		for(String a:sen)
			System.out.print(a+" ");
	}

}
