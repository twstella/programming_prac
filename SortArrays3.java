import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class SortArrays3 {
	static int N,K;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(br.readLine());
			N=Integer.parseInt(s.nextToken());
			K=Integer.parseInt(s.nextToken());
			int[] arr=new int[N];
			s=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
				arr[i]=Integer.parseInt(s.nextToken());
			Arrays.sort(arr);
			System.out.println(arr[K-1]);
		}
		catch(IOException e) {
			e.printStackTrace(System.err);
		}
	}

}
