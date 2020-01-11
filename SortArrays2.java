import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class SortArrays2 {

	public static void main(String[] args) {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(br.readLine());
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
			int n=Integer.parseInt(s.nextToken());
			int[] arr=new int[n];
			s=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(s.nextToken());
				
			}
			Arrays.sort(arr);
			Integer r=arr[arr.length-1]-arr[0];
			bw.append(r.toString());
			bw.flush();
		}
		catch(IOException e) {
			e.printStackTrace(System.err);
		}
	}

}
