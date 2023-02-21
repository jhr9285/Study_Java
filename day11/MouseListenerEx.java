// 10-4 : 컨탠트팬의 아무 위치에 마우스 버튼을 누르면 마우스 포인트가 있는 위치로 "hello" 문자열을 옮기는
// 		  스윙 응용프로그램을 작성하시오.
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseListenerEx extends JFrame {
	private JLabel la = new JLabel("Hello");
	
	public MouseListenerEx() {
		setTitle("Mouse 이벤트 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.addMouseListener(new MyMouseListener());
		
		c.setLayout(null);
		la.setSize(50, 20);
		la.setLocation(30, 30);
		c.add(la);
		
		setSize(250, 250);
		setVisible(true);
	}
	
	class MyMouseListener implements MouseListener { // MouseListener의 모든 메소드를 오버라이딩 해놔야 함

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {  // e = 이벤트가 발생한 녀석(?) (클릭한 컴포넌트)
			int x = e.getX(); // 좌표 구하는 메소드
			int y = e.getY(); // 좌표 구하는 메소드
			la.setLocation(x, y); // 위에 지정한 좌표로 이동시키는 메소드
		}
		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
	}
	
	public static void main(String[] args) {
		new MouseListenerEx();
	}

}
