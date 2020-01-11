import java.util.Scanner;
import java.util.HashMap;
public class Num2 {
	static double Answer;
	
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		double loc;
		int[][] arr;
		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			// Print the answer to standard output(screen).
			int r,s,e;
			r=sc.nextInt();
			s=sc.nextInt();
			e=sc.nextInt();
			
			int bar=sc.nextInt();
			arr=new int[bar][3];
			for(int i=0;i<bar;i++) {
				for(int j=0;j<3;j++)
					arr[i][j]=sc.nextInt();
			}
			Answer=0;
			loc=s;
			for(int i=0;i<bar;i++) {
				
				if(arr[i][2]>=r) {
					Answer+=(arr[i][0]-loc-r);
					Answer+=(arr[i][2]-r)*2;
					Answer+=2*Math.PI*r/2;
					Answer+=(arr[i][1]-arr[i][0]);
					loc=arr[i][1]+r;
				}
				else {
					double x=r*	Math.cos(Math.asin((r-arr[i][2])/r));
					Answer+=(arr[i][0]-loc-x);
					Answer+=2*r*Math.PI*Math.acos((r-arr[i][0])/r)/(2*Math.PI)*2;
					Answer+=(arr[i][1]-arr[i][0]);
					loc=arr[i][1]+x;
				}
			}
			if(loc<e)
				Answer+=e-loc;
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

}
