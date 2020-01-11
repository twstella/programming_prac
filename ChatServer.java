import java.net.*;
import java.util.*;

public class ChatServer {
	Vector handlers;
	ChatServer(int port){
		try {
			ServerSocket server=new ServerSocket(port);
			handlers=new Vector();
			System.out.println("ChatServer is ready");
			while(true) {
				Socket client=server.accept();
				ChatHandler c=new ChatHandler(this,client);
				c.start();
			}
		}
		catch(Exception e) {
			return;
		}
	}
	public Object getHandler(int index) {
		return handlers.elementAt(index);
	}
	public void register(ChatHandler c) {
		handlers.addElement(c);
	}
	public void unregister(Object o) {
		handlers.removeElement(o);
	}
	public void broadcast(String msg) {
		synchronized(handlers) {
			int n=handlers.size();
			for(int i=0;i<n;i++) {
				ChatHandler c=(ChatHandler)handlers.elementAt(i);
				try {
					c.println(msg);
				}
				catch(Exception ex) {return;}
			}
		}
	}
	public static void main(String[] args) {
		ChatServer server=new ChatServer(9830);
	}
}
