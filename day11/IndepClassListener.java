// 10-1 : 독립클래스로 Action 이벤트의 리스너 작성 (리스너 작성은 코드 작성 순서가 중요하다)
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class IndepClassListener extends JFrame {
	public IndepClassListener() {
		this.setTitle("Action 이벤트 리스너 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane(); //getContentPane(): Container 타입의 참조변수 contentPane을 반환하는 메소드
									    //(=Container 클래스로 만들어진 객체의 참조값 반환) =JFrame의 컨탠트팬 리턴
		c.setLayout(new FlowLayout()); // FlowLayout도 객체화해서 사용
		
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener()); // addActionListener 로 두 클래스 연결
		
		c.add(btn);
		
		this.setSize(350, 150);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new IndepClassListener();
	}
}

class MyActionListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource(); // .getSource() : 어느 버튼을 클릭했는지 소스를 알려준다
		if(b.getText().equals("Action")) {
			b.setText("액션");
		} else {
			b.setText("Action");
		}
	}
}