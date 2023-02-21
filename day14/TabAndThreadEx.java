// 13-6 : wait(), notify()를 이용한 바 채우기
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

class MyLabel extends JLabel {
	int barSize = 0; // 바의 크기
	int maxBarSize; // 최대 바 사이즈 변수
	
	MyLabel(int maxBarSize) {
		this.maxBarSize = maxBarSize;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		int width = (int)(((double)(this.getWidth()))/maxBarSize*barSize);
		if(width == 0) {
			return;
		}
		g.fillRect(0, 0, width, this.getHeight());
	}
	
	synchronized void fill() { // synchronized : "순서대로" 실행
		if(barSize == maxBarSize) {
			try {
				wait(); // barSize가 최댓값이면 대기
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize++; // barSize가 최댓값이 아니면 증가
		repaint(); // 바 다시 그리기
		notify();
	}
		
	synchronized void consume() { // synchronized : "순서대로" 실행
		if(barSize == 0) {
			try {
				wait(); // barSize가 0(최솟값)이면 대기
			} catch (InterruptedException e) {
				return;
			}
		}
		barSize--; // barSize가 0(최솟값)이 아니면 감소
		repaint(); // 바 다시 그리기
		notify();
	}
}

class ConsumerThread extends Thread {
	MyLabel bar;

	ConsumerThread(MyLabel bar) {
		this.bar = bar;
	}
	@Override
	public void run() {
		while(true) {
			try {
				sleep(1000);
				bar.consume();
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class TabAndThreadEx extends JFrame {
	MyLabel bar = new MyLabel(500);
	
	TabAndThreadEx(String title){
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		bar.setBackground(Color.ORANGE);
		bar.setOpaque(true);
		bar.setLocation(20, 50);
		bar.setSize(300, 20);
		c.add(bar);
		
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				bar.fill();
			}
		});
		this.setSize(350, 200);
		this.setVisible(true);
		
		c.requestFocus();
		ConsumerThread th = new ConsumerThread(bar);
		th.start();
	}
	
	public static void main(String[] args) {
		new TabAndThreadEx("아무 키나 빨리 눌러 바 채우기");
	}
}
