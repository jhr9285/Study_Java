// 11-15 : JSlider와 Change 이벤트를 활용한 색깔 다루기
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderChangeEx extends JFrame {
	private JLabel colorLabel;
	private JLabel hexaColor;
	private JSlider [] sl = new JSlider[3];
	public SliderChangeEx() {
		this.setTitle("슬라이더와 Change Event 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		colorLabel = new JLabel(" SLIDER EXAMPLE ");
		for(int i = 0; i < sl.length; i++) {
			sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
			sl[i].setPaintLabels(true);
			sl[i].setPaintTicks(true);
			sl[i].setPaintTrack(true);
			sl[i].setMajorTickSpacing(50);
			sl[i].setMinorTickSpacing(10);
			sl[i].addChangeListener(new MyChangeListener());
			c.add(sl[i]);
		}
		sl[0].setForeground(Color.RED);
		sl[1].setForeground(Color.GREEN);
		sl[2].setForeground(Color.BLUE);
		
		int r = sl[0].getValue();
		int g = sl[1].getValue();
		int b = sl[2].getValue();
		
		colorLabel.setOpaque(true);
		colorLabel.setBackground(new Color(r, g, b));
		c.add(colorLabel);
		
		hexaColor = new JLabel("#hexaColor");
		hexaColor.setOpaque(true);
		hexaColor.setForeground(Color.BLACK);
		c.add(hexaColor);
		
		this.setSize(300, 230);
		this.setVisible(true);
	}
	
	class MyChangeListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			int r = sl[0].getValue();
			int g = sl[1].getValue();
			int b = sl[2].getValue();
			colorLabel.setBackground(new Color(r, g, b));
			String hex = String.format("#%02x%02x%02x", r, g, b); // rgb를 hexa로 만드는 코드 (stackoverflow 참고)
			hexaColor.setText(hex);
		}
	}
	
	public static void main(String[] args) {
		new SliderChangeEx();
	}

}
