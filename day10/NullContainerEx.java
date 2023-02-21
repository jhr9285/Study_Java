// 9-6 : 배치관리자 없는 컨테이너에 컴포넌트를 절대 위치와 크기로 지정
import java.awt.*;
import javax.swing.*;

public class NullContainerEx extends JFrame {
	public NullContainerEx() {
		setTitle("Null Container Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null); // 컨테이너의 배치관리자를 제거한다.
		
		JLabel la = new JLabel("Hello, Press Buttons!");
		la.setLocation(300, 50); // 컴포넌트의 위치를 지정한다.
		la.setSize(200, 20); // 컴포넌트의 크기를 설정한다.
		c.add(la);
		
		for(int i = 1; i <= 9; i++) {
			JButton b = new JButton(Integer.toString(i));
			b.setLocation(i*30, i*30);
			b.setSize(200, 20);
			c.add(b);
		}
		setSize(300, 200);
		setVisible(true);
	}
		
	public static void main(String[] args) {
		new NullContainerEx();
	}
}
