import java.net.*;
import java.io.*;
public class ChatHandler extends Thread{
	Socket s;
	BufferedReader in;
	PrintWriter out;
	ChatServer server;
	public ChatHandler(ChatServer server,Socket s) {
		this.server=server;
		this.s=s;
		try {
			in=new BufferedReader(new InputStreamReader(s.getInputStream()));
		out=new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
		}
		catch(IOException e) {return;}
	}
	public void run() {
		String name="";
		try {
			name=in.readLine();
			server.register(this);
			broadcast(name+"���� �����ϼ̽��ϴ�.");
			while(true) {
				String msg=in.readLine();
				broadcast(name+"-"+msg);
			}
		}
		catch(IOException e) {System.out.println("Ŭ���̾�Ʈ�� ��ȭâ�� �ݾҽ��ϴ�");}
		server.unregister(this);
		broadcast(name+"���� �����̽��ϴ�.");
		try {
			in.close();
			out.close();
			s.close();
		}
		catch(IOException e) {return;}
	}
	void println(String msg) {
		out.println(msg);
	}
	void broadcast(String msg) {
		server.broadcast(msg);
	}
}
