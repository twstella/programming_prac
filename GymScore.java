import java.util.Arrays;
import java.util.Scanner;

public class GymScore {
	static int[] score=new int[5];
	static int sum,max,min;
	static boolean eval() {
		sum=0;
		min=11;
		max=-1;
		for(int k=1;k<4;k++) {
			sum+=score[k];
			if(min>score[k])
				min=score[k];
			if(max<score[k])
				max=score[k];
		}
		if(sum>30||(max-min>=4))
			return false;
		else
			return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		int t=key.nextInt();
		for(int i=0;i<t;i++) {
			for(int j=0;j<5;j++)
				score[j]=key.nextInt();
			Arrays.sort(score);
			if(eval())
				System.out.println(sum);
			else
				System.out.println("KIN");
			
		}
	}

}
