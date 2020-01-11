import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Snail {
	static int A,B,V;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(br.readLine());
			A=Integer.parseInt(s.nextToken());
			B=Integer.parseInt(s.nextToken());
			V=Integer.parseInt(s.nextToken());
			System.out.print((V-B-1)/(A-B)+1);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
