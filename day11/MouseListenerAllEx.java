// 10-9 : 마우스와 마우스모션 이벤트 활용
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseListenerAllEx extends JFrame {
	private JLabel la = new JLabel("No Mouse Event"); // 클래스의 멤버변수는 메소드 입장에서는 전역변수임
													  // └→ 이너클래스도 같은 클래스 내부이므로 접근 가능
	public MouseListenerAllEx() {					  // └→ 즉, 클래스 내의 모든 메소드에서 접근가능하게 하려면 
		this.setTitle("MouseListener와 MouseMotionListener 예제");    			      // 멤버변수에 선언하면 됨 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane(); // 컨테이너 객체 만드는 코드 (getContentPane() 무조건 사용)
		c.setLayout(new FlowLayout());
		
		MyMouseListener listener = new MyMouseListener();
		c.addMouseListener(listener);  		// listener를 두 군데에 모두 입력한 이유
		c.addMouseMotionListener(listener); // └→ 하나의 객체에 두 개의 기능을 모두 넣기 위해서
		// c.addMouseMotionListener(listener) : 컨테이너 c에 listener 객체를 연결하여 MouseListener 기능을 사용한다
		// <-> c.removeMouseListener(listener) : 컨테이너 c에서 MouseListener를 없앤다
		
		c.add(la);
		
		setSize(300, 200);
		setVisible(true);
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener{
		@Override
		public void mouseDragged(MouseEvent e) {
			la.setText("MouseDragged(" + e.getX() + ", " + e.getY() + ")");
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			la.setText("MouseMoved(" + e.getX() + ", " + e.getY() + ")");
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 2) {
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				Component c = (Component)e.getSource();
				c.setBackground(new Color(r, g, b));
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			la.setText("MousePressed(" + e.getX() + ", " + e.getY() + ")");
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			la.setText("MouseReleased(" + e.getX() + ", " + e.getY() + ")");
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			Component c = (Component)e.getSource();
			c.setBackground(Color.CYAN);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			Component c = (Component)e.getSource();
			c.setBackground(Color.YELLOW);
		}
	}

	public static void main(String[] args) {
		new MouseListenerAllEx();
	}
}
