// 13-3 : 깜박이는 문자열을 가진 레이블 만들기
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

class FlickeringLabel extends JLabel implements Runnable {
	private long delay;

	public FlickeringLabel(String text, long delay) {
		super(text);
		this.delay = delay;
		this.setOpaque(true);
		
		Thread th = new Thread(this);
		th.start();
	}
	@Override
	public void run() {
		int n = 0;
		while(true) {
			if(n == 0) {
				setBackground(Color.YELLOW);
			} else {
				setBackground(Color.GREEN);
			}
			if(n == 0) {
				n = 1;
			} else {
				n = 0;
			}
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class FlickeringLabelEx extends JFrame {
	public FlickeringLabelEx() {
		this.setTitle("FlickeringLabelEx 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// 깜박이는 레이블 생성  ==> 스레드 1개 (start() 메소드 작동이 기준)
		FlickeringLabel fLabel = new FlickeringLabel("0.5초마다 깜박", 500);
		
		// 깜박이지 않는 레이블 생성
		JLabel label = new JLabel("안깜박");
		
		// 깜박이는 레이블 생성  ==> 스레드 1개
		FlickeringLabel fLabel2 = new FlickeringLabel("0.3초마다 깜박", 300);
		
		c.add(fLabel);
		c.add(label);
		c.add(fLabel2);
		
		this.setSize(300, 150);
		this.setVisible(true);
	}

	public static void main(String[] args) {  // 메인 스레드 ==> 스레드 1개 ==> 총 스레드 3개 
		new FlickeringLabelEx();
	}

}
