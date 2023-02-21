// 11-3 : JButton을 이용한 버튼 만들기
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonEx extends JFrame {
	public ButtonEx() {
		this.setTitle("이미지 버튼 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container ct = getContentPane();
		ct.setLayout(null);
		
		
		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
		ImageIcon rolloverIcon = new ImageIcon("images/rolloverIcon.gif");
		ImageIcon pressedIcon = new ImageIcon("images/pressedIcon.gif");
		
		                            		// 이미지를 더 쓸 일이 없다면 레퍼런스 설정하지 않는 편이 좋음
		JButton btn = new JButton("CALL!!", new ImageIcon("images/normalIcon.gif")); 
		btn.setPressedIcon(pressedIcon);
		btn.setRolloverIcon(rolloverIcon);
		
		btn.setLocation(1, 1);
		btn.setSize(200, 100);
		
		ct.add(btn);
		
		setSize(250, 150);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ButtonEx();
	}

}
