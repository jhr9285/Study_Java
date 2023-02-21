// 14-6 : JDialog를 상속받아 다이얼로그 만들기
// 		  텍스트필드 창과 Search 버튼을 가진 다이얼로그를 만들고, 사용자가 텍스트필드 창에 문자열을 입력하고
//		  Search 버튼을 클릭하면 다이얼로그 창이 사라지도록 프로그램을 작성하시오.
// 14-7 : Search 버튼을 클릭하면 입력한 문자열을 Show Modal Dialog 버튼의 문자열로 변경되도록 14-6을 수정하시오.
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

class MyDialog extends JDialog {
	private JTextField tf = new JTextField(10);
	private JButton searchButton = new JButton("Search");
	
	public MyDialog(JFrame frame, String title) {
//		super(frame, title);
		super(frame, title, true); // true : 모달 다이얼로그로 설정
		this.setLayout(new FlowLayout());
		this.add(tf);
		this.add(searchButton);
		this.setSize(200, 100);
		
		searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false); // search 버튼 누르면 다이얼로그 보이지 않게 하기
			}
		});
	}
	public String getInput() {
		if(tf.getText().length() == 0) {  // getText() : 텍스트를 읽는 메소드
			return null;
		} else {
			return tf.getText();
		}
	}
}
public class DialogEx extends JFrame {
	private MyDialog dialog;
	public DialogEx() {
		super("DialogEx 예제 프레임");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		JButton btn = new JButton("Show Dialog");
		JButton btn = new JButton("Show Modal Dialog");
		
//		dialog = new MyDialog(this, "Test Dialog"); // this : 현재 프레임 ==> MyDialog 생성자 매개변수의 frame
		dialog = new MyDialog(this, "Test Modal Dialog"); // this : 현재 프레임 ==> MyDialog 생성자 매개변수의 frame
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);  // 다이얼로그 보이게 하기
				
				String text = dialog.getInput();
				
				if(text == null) {
					return;
				}
				JButton btn = (JButton)e.getSource();
				btn.setText(text); // setText() : 텍스트를 수정하는 메소드
			}
		});
		getContentPane().add(btn);
		this.setSize(250, 200);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new DialogEx();
	}
}