import java.util.Scanner;
public class ReverseWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner key=new Scanner(System.in);
		int T=key.nextInt();
		String str=key.nextLine();
			while(key.hasNext()) {
				str=key.nextLine();
				String[] word=str.split(" ");
				for(int i=0;i<word.length;i++) {
					for(int j=word[i].length()-1;j>=0;j--)
						System.out.print(word[i].charAt(j));
					System.out.print(" ");
				}
				System.out.println();
				//System.out.print(str+"/");
			}
		
	}

}
