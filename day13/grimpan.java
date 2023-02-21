// 그림판 만들기 (선생님 버전)
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class grimpan extends JFrame{

	private MyPanel panel=new MyPanel();
	
	public grimpan() {
		this.setTitle("Graphic");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(panel);
		
		this.setSize(500, 500);
		this.setVisible(true);
	}
		
	class MyPanel extends JPanel{

		private ArrayList<Point> aPoint=new ArrayList<Point>();		
		private ArrayList<Boolean> aPointFlag=new ArrayList<Boolean>(); 
		// 이 코드에서는 false(기본값)이면 선이 안 끊어지고 true면 끊어지는 걸로 해뒀는데
		// 바꿔서 해도 똑같은 결과가 나옴. false, true 지정에는 의미 없음. 원하는 대로 선택 가능.
		Point startP;
		Point endP;
		
		public MyPanel() {
			addMouseMotionListener(new MouseMotionListener() {

				@Override
				public void mouseDragged(MouseEvent e) {
					
					aPoint.add(e.getPoint()); // getPoint() : 포인트 객체 값
					aPointFlag.add(false);
					repaint();
				}

				@Override
				public void mouseMoved(MouseEvent e) {}
			});
			
			addMouseListener(new MouseListener() {
				@Override
				public void mousePressed(MouseEvent e) {
					aPoint.add(e.getPoint());
					aPointFlag.add(false);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					aPointFlag.remove(aPointFlag.size()-1);	 // 끊어진 점에 연결된 객체 값이 false라서
					aPointFlag.add(true); // true로 바꿈        true로 바꾸려고 그 객체를 remove함
					repaint();
					
				}
				@Override
				public void mouseClicked(MouseEvent e) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {}
				
				
				});
		}
		
		@Override
		protected void paintComponent(Graphics g) {			
			super.paintComponent(g);
			
			for(int i=0;i<aPoint.size();i++) {
				// 첫 번째 점이거나 이전 점이 '끊어진' 점인 경우
				if(i==0 || aPointFlag.get(i-1)==true) {  // 여기서 쓰려고 aPointFlag를 만든 것!
					startP=aPoint.get(i);	
				}
				// 첫 번째 점일 때 : startP = aPoint.get(0); = 첫 번째 점 위치를 시작점 변수에 넣음
				// 끊어진 점일 때 : aPointflag.get(3-1) == true = 마지막 점의 이전 점 값이 끊어진 점인지 체크
				// 	    			true면 끊어진 점임 ==> 이전 점이 끊어진 점이면 현재 위치를 시작점 변수에 넣음
				// 									   ==> startP = aPoint.get(3);
								
				// 첫 번째 점일 때 : endP = aPoint.get(0); = 첫 번째 점 위치를 끝점 변수에 넣음
				// 끊어진 점이 아닐 때 : endP = aPoint.get(3); = 현재 점 위치를 끝점 변수에 넣음 
				endP=aPoint.get(i);
				g.drawLine((int)startP.getX(), (int)startP.getY(), (int)endP.getX(), (int)endP.getY());
				startP=endP; // 끝점 값을 시작점 변수에 넣음 (루프와 비슷한 듯)
			}			
		}		
	}
	public static void main(String[] args) {
		new grimpan();
	}
}
