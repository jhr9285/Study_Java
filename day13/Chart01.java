import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chart01 extends JFrame {
	public Chart01() {
		this.setTitle("차트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		this.setContentPane(new MyPanel());
		
		this.setSize(700, 900);
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel {
		@Override // Source - Override/Implement Methods... - paintComponent 검색, 적용
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			// 막대 그래프 그리기
			int height = 20; // 고정된 숫자를 반복적으로 사용할 때 변수를 이용하면 일괄적 변경 가능
			int vGap = 10;
			g.setColor(Color.BLUE);
			g.fillRect(50, (50 + (height + vGap) * 0), 150, height); // 1분기 ==> 1 - 1 = 0
			g.setColor(Color.RED);
			g.fillRect(50, (50 + (height + vGap) * 1), 180, height); // 2분기 ==> 2 - 1 = 1
			g.setColor(Color.GREEN);
			g.fillRect(50, (50 + (height + vGap) * 2), 90, height);  // 3분기 ==> 3 - 1 = 2
			g.setColor(Color.ORANGE);
			g.fillRect(50, (50 + (height + vGap) * 3), 250, height); // 4분기 ==> 4 - 1 = 3	 	
			
			// 막대 그래프 레이블 쓰기
			g.setColor(Color.BLACK);
//			g.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			g.drawString("1분기", 10, (50+( (height+vGap)*0)+(height-(vGap/2)) ) );
			g.drawString("2분기", 10, (50+( (height+vGap)*1)+(height-(vGap/2)) ) );
			g.drawString("3분기", 10, (50+( (height+vGap)*2)+(height-(vGap/2)) ) );
			g.drawString("4분기", 10, (50+( (height+vGap)*3)+(height-(vGap/2)) ) );
			
			
			// 꺾은선 그래프 그리기
			g.drawLine(50, 200, 50, 400); // y축
			g.drawLine(50, 400, 500, 400); // x축
			
			int hGap = 100;
			g.drawLine(50+hGap*0, 400, 50+hGap*1, 400-150); // 그래프 원점에서 1분기 점으로 이어지는 선
			g.drawLine(50+hGap*1, 400-150, 50+hGap*2, 350-180); // 1분기 점에서 2분기 점으로 이어지는 선
			g.drawLine(50+hGap*2, 350-180, 50+hGap*3, 350-90); // 2분기 점에서 3분기 점으로 이어지는 선
			g.drawLine(50+hGap*3, 350-90, 50+hGap*4, 350-250); // 3분기 점에서 4분기 점으로 이어지는 선
			g.setColor(Color.RED);
			g.fillOval(50+hGap*1, 400-150, 8, 8);
			g.fillOval(50+hGap*2, 350-180, 8, 8);
			g.fillOval(50+hGap*3, 350-90, 8, 8);
			g.fillOval(50+hGap*4, 350-250, 8, 8);
			
			// 파이 차트 그리기
			g.setColor(Color.RED);
			g.fillArc(50, 450, 200, 200, 0, 79); // (22.38) 79도. 1분기 매출 비중을 360도 기준으로 환산했을 때의 각도
			g.setColor(Color.GREEN);
			g.fillArc(50, 450, 200, 200, 30, 93); // (26.86)
			g.setColor(Color.BLUE);
			g.fillArc(50, 450, 200, 200, 30+100, 46); // (13.43)
			g.setColor(Color.YELLOW);
			g.fillArc(50, 450, 200, 200, 30+100+150, 133); // (37.31)
		}
	}
	
	public static void main(String[] args) {
		new Chart01();
	}
}
