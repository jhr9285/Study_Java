// 10-3 : 익명클래스로 Action 이벤트의 리스너 작성 
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnonymousClassListener extends JFrame {
	public AnonymousClassListener() {
		this.setTitle("Action 이벤트 리스너 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout()); 
		
		JButton btn = new JButton("Action");
		
		btn.addActionListener(new ActionListener() {  // 익명 클래스 생성
			@Override								  // 이 블럭 안에서는 this 입력하면 안 됨!
			public void actionPerformed(ActionEvent e) {  
				JButton b = (JButton)e.getSource();
				if(b.getText().equals("Action")) {
					b.setText("액션");
				} else {
					b.setText("Action");
					setTitle(b.getText());
				}
			}
		});
		c.add(btn);
	
		this.setSize(350, 150);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new AnonymousClassListener();
	}
}
