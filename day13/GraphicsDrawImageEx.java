// 12-6, 12-7, 12-8, 12-9 : 이미지 그리기
import java.awt.*;
import javax.swing.*;

public class GraphicsDrawImageEx extends JFrame {
	private MyPanel panel = new MyPanel();
	public GraphicsDrawImageEx() {
		this.setTitle("이미지 그리기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(panel);
		this.setSize(300, 420);
		this.setVisible(true);
	}
	
	class MyPanel extends JPanel {
		private ImageIcon icon = new ImageIcon("C:/myphoto/pexels-stayhereforu-13413547.jpg");
		private Image img = icon.getImage(); // 이미지를 객체로 만드는 코드! new Image() (X), .getImage() (O)
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);								 // *this: 옵저버라고 하는데 거의 this만 입력함
//			g.drawImage(img, 20, 20, this); 						 // 원본 크기로 그리기  
//			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);   // 패널에 꽉 차도록 그리기
//			g.drawImage(img, 20, 20, 250, 100, 100, 50, 200, 200, this); // 이미지 일부분을 크기조절하여 그리기
			g.setClip(10, 20, 150, 150); 							 // 클리핑하기  
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);   // └→(10,20): 원점 좌표, (150,150): 사이즈
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.ITALIC, 40));
			g.drawString("Cafe", 10, 150);  // 이미지가 아니라 클리핑 영역에 고정되어 있음
		}
	}
	
	public static void main(String[] args) {
		new GraphicsDrawImageEx();
	}
}
