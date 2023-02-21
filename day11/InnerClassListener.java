// 10-2 : 내부클래스로 Action 이벤트의 리스너 작성 
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class InnerClassListener extends JFrame {
	public InnerClassListener() {
		this.setTitle("Action 이벤트 리스너 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout()); 
		
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener()); // addActionListener 로 두 클래스 연결
		
		c.add(btn);
		
		this.setSize(350, 150);
		this.setVisible(true);
	}
	
	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource(); 
			if(b.getText().equals("Action")) {
				b.setText("액션");
			} else {
				b.setText("Action");
			}
			InnerClassListener.this.setTitle(b.getText());
			// 바깥 클래스를 먼저 생성하고, 내부 클래스에서 바깥클래스명.this.메소드() 로 입력 
		}
	}
	
	public static void main(String[] args) {
		new IndepClassListener();
	}
}
