package progrmmers;
import java.util.ArrayList;
public class FindPrime {
	static ArrayList<Integer> list=new ArrayList<Integer>();
	static int[] l;
	static boolean isPrime(int n) {
		if(n==0||n==1) return false;
		for(int j=2;j*j<=n;j++)
			if(n%j==0) return false;
		return true;
	}
	static void addList(int loc) {
		int n=0;
		for(int i=0;i<loc;i++) {
			n=10*n+l[i];
		}
		if(!list.contains(n))
			list.add(n);
	}
	static void swap(int i,int j) {
		int t=l[i];
		l[i]=l[j];
		l[j]=t;
	}
	static void perm(int n,int r,int loc) {
		if(r==loc) {
			addList(loc);
			return ;
		}
		for(int i=loc;i<n;i++) {
			swap(i,loc);
			perm(n,r,loc+1);
			swap(i,loc);
		}
	}
	
	static int solution(String numbers) {
		int ans=0;
		l=new int[numbers.length()];
		Character t;
		for(int k=0;k<numbers.length();k++) {
			t=numbers.charAt(k);
			l[k]=Integer.parseInt(t.toString());
		}
		for(int j=1;j<=numbers.length();j++)
			perm(numbers.length(),j,0);
		for(int i=0;i<list.size();i++) {
			if(isPrime(list.get(i))) {
				//System.out.println(list.get(i));
				ans++;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s="17";
		//String s="011";
		String s="013";
		System.out.print(solution(s));
	}

}
