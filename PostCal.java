import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.IOException;
public class PostCal {
	static int[] num;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			double ans;
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(s.nextToken());
			num=new int[n];
			s=new StringTokenizer(br.readLine());
			String str=s.nextToken();
			for(int i=0;i<n;i++) {
				s=new StringTokenizer(br.readLine());
				num[i]=Integer.parseInt(s.nextToken());
			}
			ArrayList<Double> stack=new ArrayList<Double>();
			for(int j=0;j<str.length();j++) {
				char c=str.charAt(j);
				if(c=='+') {
					double a=(double)stack.get(stack.size()-1);
					stack.remove(stack.size()-1);
					double b=(double)stack.get(stack.size()-1);
					stack.remove(stack.size()-1);
					stack.add(a+b);
				}
				else if(c=='-') {
					double a=(double)stack.get(stack.size()-1);
					stack.remove(stack.size()-1);
					double b=(double)stack.get(stack.size()-1);
					stack.remove(stack.size()-1);
					stack.add(b-a);
				}
				else if(c=='*') {
					double a=(double)stack.get(stack.size()-1);
					stack.remove(stack.size()-1);
					double b=(double)stack.get(stack.size()-1);
					stack.remove(stack.size()-1);
					stack.add(a*b);
				}
				else if(c=='/') {
					double a=(double)stack.get(stack.size()-1);
					stack.remove(stack.size()-1);
					double b=(double)stack.get(stack.size()-1);
					stack.remove(stack.size()-1);
					stack.add(b/a);
				}
				else
					stack.add((double)num[c-'A']);
			}
			System.out.println(String.format("%.2f", stack.get(0)));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
