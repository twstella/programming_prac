package recursion;
import java.util.Scanner;
public class TreeDiagram {
	public static int[] bin;
	public static int N;
	public static void Dump() {
		for(int i=0;i<N;i++)
			System.out.print(bin[i]);
		System.out.println();
	}
	public static void perm(int loc){
		if(loc==N-1) {
			Dump();
			return;
		}
		else {
			for(int i=loc;i<N;i++) {
				int tmp=bin[i];
				bin[i]=bin[loc];
				bin[loc]=tmp;
				perm(loc+1);
				
				tmp=bin[i];
				bin[i]=bin[loc];
				bin[loc]=tmp;
				
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		N=key.nextInt();
		bin=new int[N];
		for(int i=0;i<N;i++)
			bin[i]=i;
		perm(0);
		key.close();
	}

}
