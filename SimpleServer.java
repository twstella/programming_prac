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
			System.out.println("연결을 기다리고 있습니다......");
			client=server.accept();
			System.out.println("연결되었습니다.");
			in=new BufferedReader(new InputStreamReader(client.getInputStream()));
			out=new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			while(true) {
				String inputMsg=in.readLine();
				if(inputMsg.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트에서 연결을 종료하였음.");
					break;
				}
				System.out.println("클라이언트:"+inputMsg);
				System.out.print("보내기>>");
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
				System.out.println("클라이언트와 채팅 중 오류가 발생하였습니다.");
			}
		}
		
	}

}
