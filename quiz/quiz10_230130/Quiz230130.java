package quiz10_230130;
import java.awt.*;
import javax.swing.*;

public class Quiz230130 extends JFrame {
	public Quiz230130() {
		this.setTitle("java 문제 10번: 꺾은선그래프와 파이차트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new MyPanel());
		this.setSize(700,  900);
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			// 1. 꺾은선 그래프에서 x축,y축 표시하기
			g.setColor(Color.BLACK);
			g.drawLine(50, 400, 400, 400); // x축
			g.drawLine(50, 100, 50, 400); // y축
			g.drawString("(0,0)", 38, 415); // 원점
			g.drawString("50──", 30, 350); // y축 majorTick
			g.drawString("100──", 25, 300); // y축 majorTick
			g.drawString("150──", 25, 250); // y축 majorTick
			g.drawString("200──", 25, 200); // y축 majorTick
			g.drawString("250──", 25, 150); // y축 majorTick
			g.drawString("300──", 25, 102); // y축 majorTick
			g.drawString("1분기", 100, 420); //x축 tick
			g.drawString("2분기", 180, 420); //x축 tick
			g.drawString("3분기", 260, 420); //x축 tick
			g.drawString("4분기", 340, 420); //x축 tick
			
			int hGap = 100; // 수직 갭
			g.drawLine(50, 400, hGap*1, 400-150); // 그래프 원점에서 1분기 점으로 이어지는 선
			g.drawLine(hGap*1, 400-150, hGap*2, 400-180); // 1분기 점에서 2분기 점으로 이어지는 선
			g.drawLine(hGap*2, 400-180, hGap*3, 400-90); // 2분기 점에서 3분기 점으로 이어지는 선
			g.drawLine(hGap*3, 400-90, hGap*4, 400-250); // 3분기 점에서 4분기 점으로 이어지는 선
			g.setColor(Color.RED);
			g.fillOval(hGap*1-3, 400-150-8+3, 8, 8); // 1분기 : 150
			g.fillOval(hGap*2-3, 400-180-8+3, 8, 8); // 2분기 : 180
			g.fillOval(hGap*3-3-1, 400-90-8+1, 8, 8);  // 3분기 : 90
			g.fillOval(hGap*4-3, 400-250-8+2, 8, 8); // 4분기 : 250
			
			// 2. 분기별 매출액으로 파이차트 그리기
			g.setColor(Color.RED);
			g.fillArc(50, 450, 200, 200, 0, 80); // 670:150=360:x => x=80 // 1분기 매출 비중을 360도 기준으로 환산했을 때의 각도
			g.setColor(Color.GREEN);
			g.fillArc(50, 450, 200, 200, 0+80, 96); // 670:180=360:x => x=96
			g.setColor(Color.BLUE);
			g.fillArc(50, 450, 200, 200, 0+80+96, 49); // 670:90=360:x => x=49
			g.setColor(Color.YELLOW);
			g.fillArc(50, 450, 200, 200, 0+80+96+49, 135); // 670:250=360:x => x=135
			g.setColor(Color.WHITE);
			g.drawString("1분기", 185, 508);
			g.drawString("(22.38%)", 177, 523); // 670:150=100:x ==> 22.38
			g.setColor(Color.BLACK);
			g.drawString("2분기", 100, 510);
			g.drawString("(26.86%)", 92, 525); // 670:180=100:x ==> 26.86
			g.setColor(Color.WHITE);
			g.drawString("3분기", 72, 571);
			g.drawString("(13.43%)", 64, 586); // 670:90=100:x ==> 13.43
			g.setColor(Color.BLACK);
			g.drawString("4분기", 150, 600);
			g.drawString("(37.33%)", 142, 615); // 670:250=100:x ==> 37.33
		}
	}
	
	public static void main(String[] args) {
		new Quiz230130();
	}
}