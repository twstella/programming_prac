import java.util.Scanner;
import java.util.Arrays;
public class Multmax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		int n=key.nextInt();
		int[] array=new int[n];
		for(int i=0;i<n;i++)
			array[i]=key.nextInt();
		Arrays.sort(array);
		int[] mult=new int[4];
		mult[0]=array[n-1]*array[n-2];
		mult[1]=array[n-1]*array[n-2]*array[n-3];
		mult[2]=array[0]*array[1];
		mult[3]=array[0]*array[1]*array[n-1];
		int max=-1000000001;
		for(int i=0;i<4;i++)
			if(max<mult[i])
				max=mult[i];
		System.out.println(max);

	}

}
