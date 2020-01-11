import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;
public class Fast_add {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer s=new StringTokenizer(br.readLine());
			int T=Integer.parseInt(s.nextToken());
			for(int i=0;i<T;i++) {
				s=new StringTokenizer(br.readLine());
				int A=Integer.parseInt(s.nextToken());
				int B=Integer.parseInt(s.nextToken());
				Integer C=A+B;
				bw.append(C.toString()+"\n");
			}
			bw.flush();
		}
		catch(IOException e) {
			e.printStackTrace(System.err);
		}
	}

}
