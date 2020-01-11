package recursion;

import java.util.Scanner;
public class Test {

	public static void main(String[] args) {

		int B,C;
		long cnt=0;
		Scanner key=new Scanner(System.in);
		int n=key.nextInt();
		int[] examinee=new int[n];
		for(int i=0;i<examinee.length;i++)
			examinee[i]=key.nextInt();
		B=key.nextInt();
		C=key.nextInt();
		for(int i=0;i<examinee.length;i++) {
			cnt++;
			int t = examinee[i] -B;
			if (t<=0) continue;

			if (t % C == 0)
				cnt += t/C;
			else
				cnt += t/C+1;

		}
		System.out.println(cnt);

		
	}

}
