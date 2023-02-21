// 1. 채팅창에 닉네임을 먼저 입력해서 '닉네임 : 메시지'형식으로 출력하기
// 1) 닉네임을 입력할 수 있는 다이얼로그를 띄운다.
// 2) 닉네임을 입력하면 채팅창에 접근.
// 3) '홍길동 : 안녕하세요?' 형식으로 출력
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

class MyDialog2 extends JDialog {
	private JLabel nickLabel = new JLabel("닉네임 : ");
	private JTextField tf = new JTextField(10);
	private JButton nickBtn = new JButton("확인");
	String sNick;
	
	public MyDialog2(JFrame frame, String title, boolean modal) {
		super(frame, title, true);
		this.setLayout(new FlowLayout());
		add(nickLabel);
		add(tf);
		add(nickBtn);
		this.setSize(200, 100);
		
		nickBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sNick = tf.getText();
				setVisible(false);
			}
		});
	}
}

public class Chatting_Server extends JFrame implements ActionListener {
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private ServerSocket listener = null;
	private Socket socket = null;
	private Receiver receiver;
	private JTextField sender;
	private MyDialog2 dialog;
		
	public Chatting_Server() {
		this.setTitle("서버 채팅창");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		dialog = new MyDialog2(this, "서버 닉네임 설정", true);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		receiver = new Receiver();
		receiver.setEditable(false);
		
		sender = new JTextField();
		sender.addActionListener(this);
		
		dialog.setVisible(true);
		c.add(new JScrollPane(receiver), BorderLayout.CENTER);
		c.add(sender, BorderLayout.SOUTH);
		
		this.setSize(400, 200);
		this.setVisible(true);
		
		try {
			setupConnection();
		} catch (IOException e) {
			handleError(e.getMessage());
		}
		
		Thread th = new Thread(receiver);
		th.start();
	}
	
	private void setupConnection() throws IOException {
		listener = new ServerSocket(9999);
		socket = listener.accept();
		System.out.println("연결되었습니다!");
		receiver.append("***클라이언트와 연결 완료!***\n");
		receiver.append("닉네임 \'" + dialog.sNick + "\'으로 입장하였습니다.");
		int pos = receiver.getText().length();
		receiver.setCaretPosition(pos);
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	}
	
	private static void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}
	
	private class Receiver extends JTextArea implements Runnable {
		@Override
		public void run() {
			String msg = null;
			while(true) {
				try {
					msg = in.readLine();
				} catch (IOException e) {
					handleError(e.getMessage());
				}
				this.append("\n" + msg);
				int pos = this.getText().length();
				this.setCaretPosition(pos);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == sender) {
			String msg = sender.getText();
				try {
					out.write("[" + dialog.sNick + "]" + " : " + msg + "\n");
					out.flush();
					
					receiver.append("\n[" + dialog.sNick + "] : " + msg);
					int pos = receiver.getText().length();
					receiver.setCaretPosition(pos);
					sender.setText(null);
				} catch (IOException e1) {
					handleError(e1.getMessage());
				}
		}
	}
	
	public static void main(String[] args) {
		new Chatting_Server();
	}
}