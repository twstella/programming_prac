import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Arrays;
public class SortArrays1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer s=new StringTokenizer(br.readLine());
			int T=Integer.parseInt(s.nextToken());
			int[] arr=new int[T];
			for(int i=0;i<T;i++) {
				s=new StringTokenizer(br.readLine());
				arr[i]=Integer.parseInt(s.nextToken());
			}
			Arrays.sort(arr);
			for(int i=0;i<T;i++)
				bw.append(arr[i]+"\n");
			bw.flush();
		}
		catch(IOException e) {
			e.printStackTrace(System.err);
		}
	}

}
