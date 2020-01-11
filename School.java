package codeGround;
import java.util.Scanner;
public class School {
	static int Answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int test_case=0;test_case<T;test_case++) {
			int A=sc.nextInt();
			int B=sc.nextInt();
			int D=sc.nextInt();
			Answer=(D-B-1)/(A-B)+1;
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

}
