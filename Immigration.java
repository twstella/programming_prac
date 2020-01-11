package progrmmers;
import java.util.Arrays;

public class Immigration {
	static boolean check(int[] t,int n,long m) {
		long sum=0;
		for(int i=0;i<t.length;i++)
			sum+=(m/t[i]);
		return (sum>=n)?true:false;
	}
	static int solution(int n,int[] times) {
		Arrays.sort(times);
		long l=1L,r=(long)times[times.length-1]*n;
		long min=r;
		int ans=0;
		while(l<=r) {
			long m=(l+r)/2;
			if(check(times,n,m)) {
				if(min>m)
					min=m;
				r=m-1;
			}
			else
				l=m+1;
		}
		ans=(int)min;
	return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=6;
		int[] times= {7,10};
		System.out.print(solution(n,times));
	}

}
