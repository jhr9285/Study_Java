// 14-11 : 탭팬 만들기
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class TabbedPaneEx extends JFrame {
	public TabbedPaneEx() {
		this.setTitle("탭팬 만들기 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		JTabbedPane pane = createTabbedPane();
		c.add(pane, BorderLayout.CENTER);
		this.setSize(250, 250);
		this.setVisible(true);
	}
	private JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane(JTabbedPane.LEFT);
		pane.addTab("tab1", new JLabel(new ImageIcon("C:/myphoto/apple.jpg")));
		pane.addTab("tab2", new JLabel(new ImageIcon("C:/myphoto/pear.jpg")));
		pane.addTab("tab3", new MyPanel()); // 탭을 눌렀을 때 '패널'을 띄운다! ==> 화면 전환
		return pane;
	}
	
	class MyPanel extends JPanel {
		public MyPanel() {
			this.setBackground(Color.YELLOW);
			this.add(new JTextField(9));
			this.add(new JButton("검색"));
		}
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.red);
			g.fillRect(20, 40, 70, 70);
			g.setColor(Color.BLUE);
			g.fillOval(100, 40, 70, 70);
			g.setColor(Color.BLACK);
			g.drawString("tab 3에 들어가는 JPanel 입니다.", 5, 170);
		}
	}
	
	public static void main(String[] args) {
		new TabbedPaneEx();
	}
}
