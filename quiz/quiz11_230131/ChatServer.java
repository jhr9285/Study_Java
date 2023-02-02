package quiz11_230131;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ChatServer extends JFrame implements ActionListener {
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private ServerSocket listener = null;
	private Socket socket = null;
	private Receiver receiver; // JTextArea를 상속받고 Runnable 인터페이스를 구현한 클래스로서 받은 정보를 담는 객체
	private JTextField sender; // JTextField 객체로서 보내는 정보를 담는 객체

	
	public ChatServer() {
		setTitle("서버 채팅 창"); // 프레임 타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료 버튼(X)을 클릭하면 프로그램 종료
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout()); //BorderLayout 배치관리자의 사용
		receiver = new Receiver(); // 클라이언트에서 받은 메시지를 출력할 컴퍼넌트 receiver 생성
		receiver.setEditable(false); // receiver 편집 불가 설정

		sender = new JTextField(); 
		sender.addActionListener(this); // 액션리스너 직접 상속해서 this 사용함 (이벤트 처리)

		add(new JScrollPane(receiver),BorderLayout.CENTER); // 스크롤바를 만들기 위해 ScrollPane 이용, 가운데 배치
		add(sender,BorderLayout.SOUTH); // 입력창은 남쪽에 배치
		
		setSize(400, 200); // 폭 400 픽셀, 높이 200 픽셀의 크기로 프레임 크기 설정
		setVisible(true); // 프레임이 화면에 나타나도록 설정
		
		try {
			setupConnection(); // 연결
		} catch (IOException e) {
			handleError(e.getMessage());
		}
		
		Thread th = new Thread(receiver); // 상대로부터 메시지 수신을 위한 receiver 스레드 생성
		th.start();
	}													// ▼ 프로그램이 죽지 않게만 해주는 약식 예외 처리
	private void setupConnection() throws IOException { // throws + 예외이름 : 예외처리 키워드 (try,catch와 유사)
		listener = new ServerSocket(9999); // 서버 소켓 생성 (서버 포트번호 9999=>클라이언트 포트번호 9999여야 함)
		socket = listener.accept(); // 클라이언트로부터 연결 요청 대기 (요청을 받는다) --> 클라이언트 하나만 연결
		System.out.println("연결됨"); // 소켓을 배열로 여러 개 만들면 멀티채팅 가능
		receiver.append("클라이언트로부터 연결 완료");
		int pos = receiver.getText().length();
		receiver.setCaretPosition(pos); // caret 포지션을 가장 마지막으로 이동
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 클라이언트로부터의 입력 스트림
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 클라이언트로의 출력 스트림
	}

	private static void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}
	// Receiver : 텍스트에어리어와 스레드 2개의 역할을 함
	private class Receiver extends JTextArea implements Runnable { // 러너블 인터페이스 상속받은 텍스트에어리어
		@Override // run() 메소드 직접 오버라이딩
		public void run() {
			String msg = null;
			while (true) {
				try {
					msg = in.readLine(); // 상대로부터 한 행의 문자열 받아서 msg에 넣고
				} catch (IOException e) {
					handleError(e.getMessage());
				} 
				this.append("\n  클라이언트 : " + msg); // 그 받은 문자열을 JTextArea에 출력
				int pos = this.getText().length();
				this.setCaretPosition(pos); // caret 포지션을 가장 마지막으로 이동
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) { // JTextField에 <Enter> 키 처리 //액션리스너 직접상속,오버라이딩
		if (e.getSource() == sender) {  // 이벤트가 발생한 컴포넌트를 읽었는데 sender이면
			String msg = sender.getText(); // 텍스트 필드에서 문자열 얻어옴
			try {
				out.write(msg+"\n"); // 그 sender의 문자열 전송
				out.flush(); // 버퍼 비움
				
				receiver.append("\n서버 : " + msg);// JTextArea receiver에 출력
				int pos = receiver.getText().length(); // 글자의 길이를 구함 ▶ 자동 스크롤 하기 위한 목적
				receiver.setCaretPosition(pos); // caret 포지션을 가장 마지막으로 이동 ▲
				sender.setText(null); // 입력창의 문자열 지움 (입력했던 문자열 전송 후 입력창 데이터 지우기)
			} catch (IOException e1) {
				handleError(e1.getMessage());
			} 
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}
// 보내는 건 main 스레드에서 하고, 받는 건 receiver 스레드에서 하고 있음. 총 2개의 스레드. 동시 작동.
}
