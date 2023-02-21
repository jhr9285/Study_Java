// 13-6 : flag를 이용한 스레드 강제 종료 (왜 java가 여러개 안 뜨지?)
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

class RandomThread extends Thread {
	private Container contentPane;
	private boolean flag = false; // flag : 스레드의 종료 명령을 표시하는 변수
	
	public RandomThread(Container contentPane) {
		this.contentPane = contentPane;
	}
	void finish() { // 스레드를 강제종료 시키는 메소드
		flag = true;  
	}
	@Override
	public void run() {
		while(true) {
			int x = ((int)Math.random() * contentPane.getWidth());  
			int y = ((int)Math.random() * contentPane.getHeight()); 
			
			JLabel label = new JLabel("Java");
			label.setSize(80, 30);
			label.setLocation(x, y);
			
			contentPane.add(label);
			contentPane.repaint();
			
			try {
				sleep(300);
				if(flag == true) {
					contentPane.removeAll(); // 전부 지움
					label = new JLabel("finish");
					label.setSize(80, 30);
					label.setLocation(100, 100);
					label.setForeground(Color.RED);
					
					contentPane.add(label);
					contentPane.repaint();//메인메소드 있는 클래스 생성자 블럭에서 add 한 게 아니어서 repaint 필요 
					return; // 스레드 종료 (메인메소드 있는 클래스 생성자 블럭에서 add하면
				} 						  									  // └→ 객체 생성 시 paint 자동 호출됨)
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class ThreadFinishFlagEx extends JFrame {
	private RandomThread th;
	
	public ThreadFinishFlagEx() {
		this.setTitle("Thread Finish Flag Ex");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				th.finish();
			}
		});
		this.setSize(300, 200);
		this.setVisible(true);
		
		th = new RandomThread(c); // ThreadFinishFlagEx의 c가 RandomThread 생성자함수의 매개변수로 적용되어
		th.start();				  // └→ RandomThread의 run()이 실행되면 그 내용이 c에 반영됨
	}
	
	public static void main(String[] args) {
		new ThreadFinishFlagEx();
	}
}
