package basic;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Treasure {
	static int K;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(br.readLine());
			K=Integer.parseInt(s.nextToken());
			s=new StringTokenizer(br.readLine());
			int[] A=new int[K];
			int[] B=new int[K];
			for(int i=0;i<K;i++)
				A[i]=-Integer.parseInt(s.nextToken());
			s=new StringTokenizer(br.readLine());
			for(int j=0;j<K;j++)
				B[j]=Integer.parseInt(s.nextToken());
			Arrays.sort(A);
			Arrays.sort(B);
			int sum=0;
			for(int i=0;i<K;i++)
				sum+=(-A[i])*B[i];
			System.out.println(sum);
				
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
