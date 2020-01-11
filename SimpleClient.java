import java.net.*;
import java.util.*;
import java.io.*;

public class SimpleClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in=null;
		BufferedWriter out=null;
		Socket c=null;
		Scanner key=new Scanner(System.in);
		try {
			c=new Socket("localhost",9999);
			in=new BufferedReader(new InputStreamReader(c.getInputStream()));
			out=new BufferedWriter(new OutputStreamWriter(c.getOutputStream()));
			while(true) {
				System.out.print("������>>");
				String output=key.nextLine();
				if(output.equalsIgnoreCase("bye")) {
					out.write(output+"\n");
					out.flush();
					break;
				}
				out.write(output+"\n");
				out.flush();
				String input=in.readLine();
				System.out.println("����:"+input);
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				if(c!=null)
					c.close();
				key.close();
			}
			catch(IOException e) {
				System.out.println("������ ä�� �� ������ �߻��߽��ϴ�.");
			}
			
		}
	}

}
