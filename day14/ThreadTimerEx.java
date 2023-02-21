// 13-1 : Thread를 상속받아 1초 단위의 타이머 만들기
// 13-5 : 타이머 스레드 강제 종료
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TimerThread extends Thread { // Thread 클래스를 상속받아서 스레드 만드는 방식
	private JLabel timerLabel2; // JLabel 객체는 JFrame 상속받은 클래스에서만 만들 수 있다. 변수 선언만 한 것.

	public TimerThread(JLabel timerLabel1) {
		this.timerLabel2 = timerLabel1;
	}
	@Override
	public void run() {
		int n = 0;
		while(true) {
			timerLabel2.setText(Integer.toString(n));
			n++;
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class ThreadTimerEx extends JFrame {
	public ThreadTimerEx() {
		TimerThread th;
		this.setTitle("Thread를 상속받은 타이머 스레드 작성 예제 + 타이머 스레드 강제 종료 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel1 = new JLabel(); // 여기서 만든 timerLabel1을 timerLabel2와 연결...
		timerLabel1.setFont(new Font("Gothic", Font.ITALIC, 80));
		th = new TimerThread(timerLabel1);
		// ThreadTimerEx 클래스에서 만든 timerLabel1을 TimerThread 클래스의 생성자함수의 매개변수로 사용
		// ==> timerLabel1과 timerLabel2가 같은 객체를 가리킨다.
		c.add(timerLabel1);
		
		// 버튼 생성하고 액션리스너 등록
		JButton btn = new JButton("Kill Timer");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				th.interrupt(); // 타이머 스레드 강제 종료
				JButton btn = (JButton)e.getSource();
				btn.setEnabled(false);
			}
		});
		c.add(btn);
		
		this.setSize(300, 170);
		this.setVisible(true);
		
		th.start();
	}
	
	public static void main(String[] args) {
		new ThreadTimerEx();
	}
}
