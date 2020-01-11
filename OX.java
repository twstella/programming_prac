import java.util.Scanner;
public class OX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		int k=key.nextInt();
		for(int i=0;i<k;i++) {
			int sum=0;
			int add=0;
			String str=key.next();
			for(int j=0;j<str.length();j++) {
				
				char c=str.charAt(j);
				if(c=='X')
					add=0;
				else if(c=='O') {
					add++;
					//System.out.print(" add:"+add+" ");
					sum+=add;
				}
				//System.out.print(sum+" ");
			}
			System.out.println(sum);
		}
	}

}
