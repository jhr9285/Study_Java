// 10-8 : 상하좌우 키를 이용하여 "HELLO" 문자열을 움직이는 응용프로그램을 작성하시오.
// 		  "HELLO" 문자열은 JLabel 컴포넌트로 만들어 컨텐트팬에 부착하고 상하좌우키를 움직이면 키 방향으로
//		  한번에 10픽셀씩 움직인다. 이를 위해 컨텐트팬의 배치관리자를 삭제하여야 한다.
//		  "HELLO" 문자열을 초기에 (50, 50) 위치에 출력하시오.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FlyingTextEx extends JFrame {
	private final int FLYING_UNIT = 10; // 한번 움직일 때 10픽셀씩 움직이도록 설정
	private JLabel la = new JLabel("HELLO");
	public FlyingTextEx() {
		this.setTitle("상하좌우 키를 이용하여 텍스트 움직이기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null); // null이면 개발자가 직접 setLocation(), setSize() 메소드로 위치와 크기 설정해야 함
		c.addKeyListener(new MyKeyListener());
		
		la.setLocation(50, 50);  // 좌표는 왼쪽 위가 (0,0) 임
		la.setSize(100, 20);
		
		c.add(la);
		
		setSize(300, 300);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
	}
	
	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			switch(keyCode) {
			case KeyEvent.VK_UP:
				la.setLocation(la.getX(), la.getY()-FLYING_UNIT);  // Y값을 줄이면(0에 가까워지면) 위로 올라감
				break;
			case KeyEvent.VK_DOWN:
				la.setLocation(la.getX(), la.getY()+FLYING_UNIT);
				break;
			case KeyEvent.VK_LEFT:
				la.setLocation(la.getX()-FLYING_UNIT, la.getY());  // X값을 줄이면(0에 가까워지면) 왼쪽으로 감
				break;
			case KeyEvent.VK_RIGHT:
				la.setLocation(la.getX()+FLYING_UNIT, la.getY());
				break;
			}
		}
	}

	public static void main(String[] args) {
		new FlyingTextEx();
	}

}
