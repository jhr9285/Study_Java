// 12장 마지막 예제 : JButton을 상속받아 새로운 버튼을 생성
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

public class paintComponentEx extends JFrame {
	public paintComponentEx() {
		this.setTitle("새로운 버튼 만들기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		MyButton b = new MyButton("New Button");
		b.setOpaque(true);
		b.setBackground(Color.CYAN);
		c.add(b);
		
		BasicButton bb = new BasicButton("Basic Button");
		bb.setOpaque(true);
		c.add(bb);
		
		RectButton rb = new RectButton("Rect Button");
		rb.setOpaque(true);
		c.add(rb);
		
		this.setSize(250, 200);
		this.setVisible(true);
	}
	
	class MyButton extends JButton {
		public MyButton(String text) {
			super(text);
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.red);
			g.drawOval(2, 2, this.getWidth()-5, this.getHeight()-5);
		}
	}
	
	class BasicButton extends JButton {
		public BasicButton(String text) {
			super(text);
		}
	}
	
	class RectButton extends JButton {
		public RectButton(String text) {
			super(text);
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLACK);
			g.drawRect(2, 2, this.getWidth()-5, this.getHeight()-5);
		}
	}
	
	public static void main(String[] args) {
		new paintComponentEx();
	}

}
