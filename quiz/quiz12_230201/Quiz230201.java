// 1. 쓰레드를 사용해서 디지털시계를 작성하시오. => JLabel에 시간 출력
package quiz12_230201;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Quiz230201 extends JFrame {

	int n, m, j = 0;
	
	class SecondThread extends Thread {
		public JLabel secondLabel;
	
		public SecondThread(JLabel secondLabel) {
			this.secondLabel = secondLabel;
		}
		@Override
		public void run() {
			while(true) {
				if(n > 60) {
					n = 0;
					secondLabel.setText(Integer.toString(n));
					n++;
				} else {
					secondLabel.setText(Integer.toString(n));
					n++;
				}
				try {
					sleep(50);
				} catch (InterruptedException e) {
					return;
				}
			}
		}
	}
	
	class MinuteThread extends Thread {
		public JLabel minuteLabel;
	
		public MinuteThread(JLabel minuteLabel) {
			this.minuteLabel = minuteLabel;
		}
		@Override
		public void run() {
			if(n == 60) {
				while(true) {
					if(m == 60) {
						m = 0;
						minuteLabel.setText(Integer.toString(m));
						m++;
					}
					minuteLabel.setText(Integer.toString(m));
					m++;
				}
			} 
		}
	}
	
	class HourThread extends Thread {
		public JLabel hourLabel;
		
		public HourThread(JLabel hourLabel) {
			this.hourLabel = hourLabel;
		}
		@Override
		public void run() {
			if(m == 60) {
				while(true) {
					if(j == 24) {
						j = 0;
						hourLabel.setText(Integer.toString(j));
						j++;
					}
					hourLabel.setText(Integer.toString(j));
					j++;
				}
			}
		}
	}

	public Quiz230201() {
		HourThread ht;
		MinuteThread mt;
		SecondThread st;
		
		this.setTitle("Digital Clock");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel hourLabel = new JLabel();
		hourLabel.setFont(new Font("Gothic", Font.ITALIC, 60));
		JLabel minuteLabel = new JLabel();
		minuteLabel.setFont(new Font("Gothic", Font.ITALIC, 60));
		JLabel secondLabel = new JLabel();
		secondLabel.setFont(new Font("Gothic", Font.ITALIC, 60));
		JLabel sp1 = new JLabel(" : ");
		sp1.setFont(new Font("Gothic", Font.ITALIC, 60));
		JLabel sp2 = new JLabel(" : ");
		sp2.setFont(new Font("Gothic", Font.ITALIC, 60));
		
		ht = new HourThread(hourLabel);
		mt = new MinuteThread(minuteLabel);
		st = new SecondThread(secondLabel);
		
		c.add(hourLabel);
		c.add(sp1);
		c.add(minuteLabel);
		c.add(sp2);
		c.add(secondLabel);
		
		this.setSize(300, 170);
		this.setVisible(true);
		
		st.start();
		mt.start();
		ht.start();
	}

	public static void main(String[] args) {
		new Quiz230201();
	}
}
