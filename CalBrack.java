import java.util.ArrayList;
import java.util.Scanner;
public class CalBrack {
	static ArrayList<String> stack=new ArrayList<String>();
	static void print() {
		for(String s:stack) {
			System.out.print(s+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		String str=key.next();
		for(int i=0;i<str.length();i++) {
			Character t=str.charAt(i);
			if(t=='('||t=='[')
				stack.add(t.toString());
			else if(t==')') {
				if(stack.isEmpty()) {
					System.out.println("0");
					return;
				}
				String m=stack.get(stack.size()-1);
				if(m.equals("(")) {
					stack.remove(stack.size()-1);
					stack.add("2");
				}
				else if(m.equals("[")||stack.isEmpty()) {
					System.out.println("0");
					return;
				}
				else {
					Integer sum=0;
					String p=" ";
					while(!stack.isEmpty()) {
						p=stack.get(stack.size()-1);
						stack.remove(stack.size()-1);
						if(p.equals("[")) {
							System.out.println("0");
							return;
						}
						else if(p.equals("(")) {
							sum*=2;
							stack.add(sum.toString());
							break;
						}
						sum+=Integer.parseInt(p);
					}
				}
			}
			else if(t==']'){
				if(stack.isEmpty()) {
					System.out.println("0");
					return;
				}
				String m=stack.get(stack.size()-1);
				if(m.equals("[")) {
					stack.remove(stack.size()-1);
					stack.add("3");
				}
				else if(m.equals("(")||stack.isEmpty()) {
					System.out.println("0");
					return;
				}
				else {
					Integer sum=0;
					String p=" ";
					while(!stack.isEmpty()) {
						p=stack.get(stack.size()-1);
						stack.remove(stack.size()-1);
						if(p.equals("(")) {
							System.out.println("0");
							return;
						}
						else if(p.equals("[")) {
							sum*=3;
							stack.add(sum.toString());
							break;
						}
						sum+=Integer.parseInt(p);
					}
				}
			}
			//print();
		}
		int sum=0;
		try {
			while(!stack.isEmpty()) {
				String t=stack.get(stack.size()-1);
				stack.remove(stack.size()-1);
				sum+=Integer.parseInt(t);
			}
		}
		catch(NumberFormatException e) {
			System.out.println("0");
			return;
		}
		System.out.println(sum);
	}

}
