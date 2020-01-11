package recursion;
import java.util.Scanner;

public class Operator {
	public static int N;
	public static int[] numbers;
	public static int[] operators;
	public static int[] inputOp= {0,0,0,0};
	public static int max=-1000000001;
	public static int min=1000000001;
	public static void change() {
		int loc=0;
		for(int i=0;i<4;i++)
			for(int j=0;j<inputOp[i];j++) {
				operators[loc]=i;
				loc++;
			}
	}
	public static int calculate() {	
		int val=numbers[0];
		for(int i=0;i<operators.length;i++) {
			if(operators[i]==0)
				val+=numbers[i+1];
			else if(operators[i]==1)
				val-=numbers[i+1];
			else if(operators[i]==2)
				val*=numbers[i+1];
			else
				val/=numbers[i+1];
		}
		return val;
	}
	public static void Dump() {
		/*
		for(int i=0;i<operators.length;i++)
			System.out.print(operators[i]+" ");
		System.out.println(calculate());
		*/
		if(max<calculate())
			max=calculate();
		if(min>calculate())
			min=calculate();
	}
	public static void perm(int loc){
		
		if(loc==N-1) {
			Dump();
			return;
		}
		else {
			for(int i=loc;i<operators.length;i++) {
				int tmp=operators[i];
				operators[i]=operators[loc];
				operators[loc]=tmp;
				perm(loc+1);
				
				tmp=operators[i];
				operators[i]=operators[loc];
				operators[loc]=tmp;
				
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		N=key.nextInt();
		operators=new int[N-1];
		numbers=new int[N];
		for(int i=0;i<numbers.length;i++)
			numbers[i]=key.nextInt();
		for(int i=0;i<inputOp.length;i++)
			inputOp[i]=key.nextInt();
		change();
		//System.out.println(calculate());
		perm(0);
		System.out.println(max);
		System.out.println(min);
	}

}
