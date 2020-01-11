import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Hotel {
	static int T,H,W,N;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				StringTokenizer st = new StringTokenizer( br.readLine() );	
				T= Integer.parseInt(st.nextToken());	
			}
		    catch (IOException e) {
		         //System.err.println("Error: " + e);
		    }
		for(int i=0;i<T;i++) {
			try {
				StringTokenizer st= new StringTokenizer(br.readLine());
				H=Integer.parseInt(st.nextToken());
				W=Integer.parseInt(st.nextToken());
				N=Integer.parseInt(st.nextToken());
			}
			catch (IOException e) {
		         //System.err.println("Error: " + e);
		    }
			int f=(N-1)%H+1;
			int l=(N-1)/H+1;
			//System.out.println(getDigit(W)+" "+getDigit(l));
			System.out.println(f*100+l);
			//System.out.printf("%d%02d\n",f,l);
		}

	}

}
