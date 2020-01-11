package basic;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class MakeStack {
	static int N;
	static ArrayList<Integer> stack=new ArrayList<Integer>();
	public static void push(Integer i) {
		stack.add(i);
	}
	public static void pop() {
		if(stack.size()==0)
			System.out.println("-1");
		else
			System.out.println(stack.remove(stack.size()-1));
	}
	public static void size() {
		System.out.println(stack.size());
	}
	public static void empty() {
		if(stack.isEmpty())
			System.out.println("1");
		else
			System.out.println("0");
	}
	public static void top() {
		if(stack.size()==0)
			System.out.println("-1");
		else {
			System.out.println(stack.get(stack.size()-1));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(br.readLine());
			N=Integer.parseInt(s.nextToken());
			for(int i=0;i<N;i++) {
				s=new StringTokenizer(br.readLine());
				String t=s.nextToken();
				switch(t) {
				case "push":
					int k=Integer.parseInt(s.nextToken());
					push(k);
					break;
				case "pop":
					pop();
					break;
				case "top":
					top();
					break;
				case "empty":
					empty();
					break;
				case "size":
					size();
					break;
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
