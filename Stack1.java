import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
public class Stack1 {

	public static void main(String[] args) {
		String s;
		int i,a,b,sum=0;
		int c1=0,c2=0,c3=0,c4=0;
		Scanner key=new Scanner(System.in);
		Stack<Integer> st=new Stack();
		s=key.next();
		key.close();
		
		try {
			for(i=0;i<s.length();i++) {
			
				if(s.charAt(i)=='(') {
					st.push(-2);
					c1++;
				}
				else if(s.charAt(i)=='[') {
					st.push(-3);
					c2++;
				}
				else if(s.charAt(i)==')') {
					c3++;
					a=st.pop();
					if(a==-2) {
						st.push(2);
						
					}
					else {
						sum=a;
						if(st.empty()==true)
							break;
						b=st.pop();
						
						while(b!=-2) {
							
							sum+=b;
							if(st.empty()==true)
								break;
							b=st.pop();
											
						}
						sum=sum*2;
						st.push(sum);
					
					}
				}
				else{
					
					c4++;
					if(st.empty()==true)
						break;
					a=st.pop();
					if(a==-3) {
						st.push(3);
						
					}
					else {
						sum=a;
						if(st.empty()==true)
							break;
						b=st.pop();
						
						while(b!=-3) {
							
							sum+=b;
							if(st.empty()==true)
								break;
							b=st.pop();
							
						}
						sum=sum*3;
						st.push(sum);
						
					}
				}
				
			}
		}
		catch(EmptyStackException e) {
			sum=0;
		}
		a=0;
		if(st.empty()!=true)
			a=st.pop();
		while(!st.empty()) {
			b=st.pop();
			sum=a+b;
		}
		if((c1!=c3)||(c2!=c4))
			sum=0;
		System.out.print(sum);
		
	}

}
