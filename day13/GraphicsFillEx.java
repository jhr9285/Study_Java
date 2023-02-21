// 12-5 : 색칠한 도형 만들기
import java.awt.*;
import javax.swing.*;

public class GraphicsFillEx extends JFrame {
	private MyPanel panel = new MyPanel();
	public GraphicsFillEx() {
		this.setTitle("fillXXXX 사용 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panel);
		this.setSize(100, 500);
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillRect(10, 10, 50, 50);  // (10, 10)에서 시작하고 가로길이 50, 세로길이 50인 사각형
			
			g.setColor(Color.BLUE);
			g.fillOval(10, 70, 50, 50);	 // (10, 70)에서 시작하고 가로길이 50, 세로길이 50인 사각형에 내접하는 원
			
			g.setColor(Color.GREEN);
			g.fillRoundRect(10, 130, 50, 50, 20, 20); // (10, 130)에서 시작하고 가로길이 50, 세로길이 50이며, 
													  // 곡선구간 가로 20, 세로 20 인 둥근사각형
			g.setColor(Color.MAGENTA);
			g.fillArc(10, 190, 50, 50, 0, 270); // (10, 190)에서 시작하고 가로 50, 세로 50인 사각형에 내접하는 원호
												// 0도에서 시작하여 270도에서 끝나는, 일부가 잘려나간 원
			g.setColor(Color.ORANGE);
			int [] x = {30, 10, 30, 60}; 
			int [] y = {250, 275, 300, 275};
			g.fillPolygon(x, y, 4); // (30, 250), (10, 275), (30, 300), (60, 275) 네 개의 꼭짓점을 갖는 사각형
			
			g.setColor(Color.PINK);
			int [] a = {40, 20, 20, 40, 60, 60};
			int [] b = {300, 325, 350, 375, 350, 325};
//			g.fillPolygon(a, b, 6);  // 분홍색으로 채워진 육각형
			g.drawPolygon(a, b, 6);  // 분홍색 선으로 그려진 육각형
		}			
	}
	
	public static void main(String[] args) {
		new GraphicsFillEx();
	}

}
