import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
public class MakeQ {
	static ArrayList<Integer> q=new ArrayList<Integer>();
	static int n;
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static void push(int n) {
		q.add(n);
	}
	static void pop() {
		try {
			if(!q.isEmpty()) {
				bw.append(q.get(0).toString()+"\n");
				q.remove(0);
			}
			else
				bw.append("-1\n");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	static void size() {
		try {
			bw.append(""+q.size()+"\n");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	static void empty() {
		try {
			if(q.isEmpty())
				bw.append("1\n");
			else
				bw.append("0\n");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	static void front() {
		try {
			if(q.isEmpty())
				bw.append("-1\n");
			else
				bw.append(q.get(0).toString()+"\n");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	static void back() {
		try {
			if(q.isEmpty())
				bw.append("-1\n");
			else
				bw.append(q.get(q.size()-1).toString()+"\n");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(br.readLine());
			n=Integer.parseInt(s.nextToken());
			for(int i=0;i<n;i++) {
				s=new StringTokenizer(br.readLine());
				String str=s.nextToken();
				switch(str){
				case "push":
					int t=Integer.parseInt(s.nextToken());
					push(t);
					break;
				case "pop":
					pop();
					break;
				case "size":
					size();
					break;
				case "empty":
					empty();
					break;
				case "front":
					front();
					break;
				case "back":
					back();
					break;
				}
			}
			bw.flush();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
