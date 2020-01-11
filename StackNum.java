import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class StackNum{
	static int n,ind=0,k,m=0;
	static int[] stack;
	static void print() {
		for(int i=0;i<n;i++) {
			System.out.print(stack[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(br.readLine());
			StringBuilder build=new StringBuilder();
			n=Integer.parseInt(s.nextToken());
			stack=new int[n];
			for(int i=0;i<n;i++) {
				s=new StringTokenizer(br.readLine());
				k=Integer.parseInt(s.nextToken());
				if(k>m) {
					for(int j=m;j<k;j++) {
						stack[ind++]=j+1;
						build.append("+\n");
					}
				}
				else {
					if(stack[ind-1]!=k) {
						System.out.println("NO");
						return;
					}
				}
				ind--;
				build.append("-\n");
				if(k>m) m=k;
				//print();
			}
			System.out.print(build.toString());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}