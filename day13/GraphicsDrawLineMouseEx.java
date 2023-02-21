// 12-9 : 마우스를 이용한 선 그리기 (repaint() 사용)
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsDrawLineMouseEx extends JFrame {
	private MyPanel panel = new MyPanel();
	public GraphicsDrawLineMouseEx() {
		this.setTitle("drawing Line by Mouse 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panel);
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel {
		private Vector<Point> vStart = new Vector();  // vStart와 vEnd 두 벡터의 원소인 객체가
		private Vector<Point> vEnd = new Vector();    // 같은 인덱스마다 짝을 이루어 페어링됨
		public MyPanel() {
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) { // 시작점을 마우스 버튼 누른 곳으로 설정
					Point startP = e.getPoint(); // getPoint() : 포인트의 위치를 구함
					vStart.add(startP);
				}
				@Override
				public void mouseReleased(MouseEvent e) { // 끝점을 마우스 버튼 뗀 곳으로 설정
					Point endP = e.getPoint();
					vEnd.add(endP);
					repaint();
				}
			});
		}
		@Override
		public void paintComponent(Graphics g) { // ==> 이 메소드가 그리고 있는 컴포넌트는 패널!
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			for(int i = 0; i < vStart.size(); i++) {
				Point s = vStart.elementAt(i);  // elementAt() = getIndex()와 유사. 인덱스 반환.
				Point e = vEnd.elementAt(i);
				g.drawLine((int)s.getX(), (int)s.getY(), (int)e.getX(), (int)e.getY());
			}
		}
	}
	
	public static void main(String[] args) {
		new GraphicsDrawLineMouseEx();
	}

}
