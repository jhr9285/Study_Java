// 11-13 : Action 이벤트를 이용한 콤보박스 활용 예
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboActionEx extends JFrame {
	private String [] fruits = {"apple", "banana", "kiwi", "mango"};
	private ImageIcon [] images = {new ImageIcon("images/apple.jpg"), new ImageIcon("images/banana.jpg"),
								   new ImageIcon("images/kiwi.jpg"), new ImageIcon("images/mango.jpg")};
	private JLabel imgLabel = new JLabel(images[0]); // imgLabel : 이미지 출력하는 레이블
	private JComboBox<String> strCombo = new JComboBox<String>(fruits);
	
	public ComboActionEx() {
		this.setTitle("콤보박스 활용 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(strCombo);
		c.add(imgLabel);
		
		strCombo.addActionListener(new ActionListener() { // 익명 액션리스너 객체 생성
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				int index = cb.getSelectedIndex(); // getSelectedIndex() : 선택된 아이템의 인덱스 알려주는 메소드
				imgLabel.setIcon(images[index]); // setIcon() : 이미지 바꾸는 메소드
			}
		});
		this.setSize(300, 250);
		this.setVisible(true);
	}
	
 	public static void main(String[] args) {
		new ComboActionEx();
	}
}
