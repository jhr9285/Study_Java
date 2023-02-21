// 12-3 : Color와 Font 클래스를 이용하여 문자열 그리기
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsColorFontEx extends JFrame {
	private MyPanel panel = new MyPanel();
	public GraphicsColorFontEx() {
		this.setTitle("Color, Font 클래스 사용 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panel);
		this.setSize(350, 470);
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.drawString("java studying...", 30, 30);
			g.setColor(new Color(255, 0, 0));  					// Color 클래스 사용
			g.setFont(new Font("Arial", Font.ITALIC, 30));		// Font 클래스 사용 : (폰트이름, 스타일, 크기)
			g.drawString("What time is it now?", 30, 60);
			g.setColor(new Color(0x00ff00ff)); 					// setColor(색깔이름) : 색깔 변경
			for(int i = 1; i <= 5; i++){						// Color(비트값) : 해당 비트의 rgb 색상으로 적용
				g.setFont(new Font("Jokerman", Font.ITALIC, i*10));  // setFont(폰트이름) : 폰트 변경
				g.drawString("6:20 pm", 30, 60 + i*60);
			}
		}
	}
	
	public static void main(String[] args) {
		new GraphicsColorFontEx();
	}

}
