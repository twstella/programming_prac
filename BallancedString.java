import java.util.ArrayList;
import java.util.Scanner;
public class BallancedString {
	static ArrayList<String> sen=new ArrayList<String>();
	static ArrayList<String> tmp=new ArrayList<String>();
	public static void combi(int[] v,int s,int n,int r) {
		if(r==0) {
			String k="";
			for(int i=0;i<v.length;i++)
				k+=v[i];
			sen.add(k);
			return;
		}
		else {
			for(int i=s;i<n;i++) {
				v[i]=1;
				combi(v,i+1,n,r-1);
				v[i]=0;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		int[] v=new int[t];
		if(t%2==0) {
			combi(v,0,t,t/2);
		}
		else {
			combi(v,0,t,t/2);
			combi(v,0,t,t/2+1);
		}
		System.out.println(sen.size());
	}

}
