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
			broadcast(name+"님이 입장하셨습니다.");
			while(true) {
				String msg=in.readLine();
				broadcast(name+"-"+msg);
			}
		}
		catch(IOException e) {System.out.println("클라이언트가 대화창을 닫았습니다");}
		server.unregister(this);
		broadcast(name+"님이 나가셨습니다.");
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
