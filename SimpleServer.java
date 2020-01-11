import java.net.*;
import java.io.*;
import java.util.*;
public class SimpleServer{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in=null;
		BufferedWriter out=null;
		ServerSocket server=null;
		Socket client=null;
		Scanner key=new Scanner(System.in);
		try {
			server=new ServerSocket(9999);
			System.out.println("������ ��ٸ��� �ֽ��ϴ�......");
			client=server.accept();
			System.out.println("����Ǿ����ϴ�.");
			in=new BufferedReader(new InputStreamReader(client.getInputStream()));
			out=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			while(true) {
				String inputMsg=in.readLine();
				if(inputMsg.equalsIgnoreCase("bye")) {
					System.out.println("Ŭ���̾�Ʈ���� ������ �����Ͽ���.");
					break;
				}
				System.out.println("Ŭ���̾�Ʈ:"+inputMsg);
				System.out.print("������>>");
				String outputMsg=key.nextLine();
				out.write(outputMsg+"\n");
				out.flush();
			}
		}
		catch(IOException e) {return;}
		finally {
			try {
				key.close();
				server.close();
				client.close();
			}
			catch(IOException e) {
				System.out.println("Ŭ���̾�Ʈ�� ä�� �� ������ �߻��Ͽ����ϴ�.");
			}
		}
		
	}

}
