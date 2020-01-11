import java.util.*;
import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ChatClient extends JFrame implements Runnable,ActionListener {
	BufferedReader in;
	PrintWriter out;
	JTextArea output;
	JTextField input;
	JLabel label;
	Thread listener;
	String host;
	ChatClient(String server){
		super("채팅프로그램");
		host=server;
		listener=new Thread(this);
		listener.start();
		output=new JTextArea();
		getContentPane().add(new JScrollPane(output),BorderLayout.CENTER);
		output.setEditable(false);
		JPanel bottom=new JPanel(new BorderLayout());
		label=new JLabel(" 사용자 이름");
		bottom.add(label,BorderLayout.WEST);
		input=new JTextField();
		input.addActionListener(this);
		bottom.add(input,BorderLayout.CENTER);
		getContentPane().add(bottom,BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,300);
		setVisible(true);
	}
	public void run() {
		try {
			Socket s=new Socket(host,9830);
			in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			out=new PrintWriter(new OutputStreamWriter(s.getOutputStream()),true);
			while(true) {
				String line=in.readLine();
				output.append(line+"\n");
			}
		}
		catch(IOException e) {return;}
	}
	public void actionPerformed(ActionEvent e) {
		Object c=e.getSource();
		if(c==input) {
			label.setText("메시지");
			out.println(input.getText());
			input.setText("");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length>0) {new ChatClient(args[0]);}
		else {new ChatClient("localhost");}
	}

}
