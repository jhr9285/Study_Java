// 11-5 : ItemEvent 활용하여 체크박스로 가격 합산하기
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxItemEventEx extends JFrame {
	private JCheckBox[] fruits = new JCheckBox[3];
	private String[] names = {"사과", "배", "체리"};
	private JLabel sumLabel;
	
	public CheckBoxItemEventEx() {
		setTitle("체크박스와 ItemEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("사과 100원, 배 500원, 체리 20000원"));
		
		MyItemListener listener = new MyItemListener();
		for(int i = 0; i < fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true); // setBorderPainted() : 버튼 테두리 만드는 메소드
			c.add(fruits[i]);
			fruits[i].addItemListener(listener);
		}
		sumLabel = new JLabel("현재 0 원입니다.");
		c.add(sumLabel);
		
		setSize(250, 200);
		setVisible(true);
	}
	
	class MyItemListener implements ItemListener {
		private int sum = 0;

		@Override
		public void itemStateChanged(ItemEvent e) { // ItemListener의 추상메소드 itemStateChanged 오버라이딩
			if(e.getStateChange() == ItemEvent.SELECTED) {//SELECTED:"상수"  └→ 상태가 바뀌었는지 확인하는 메소드 
				if(e.getItem() == fruits[0]) {//ItemEvent의 메소드 getItem(): 이벤트를 발생시킨 아이템 객체 리턴
					sum += 100;				  // └→ 체크박스의 경우 JCheckBox 컴포넌트의 레퍼런스 리턴
				} else if(e.getItem() == fruits[1]) {
					sum += 500;
				} else {
					sum += 20000;
				}
			} else {
				if(e.getItem() == fruits[0]) {
					sum -= 100;
				} else if(e.getItem() == fruits[1]) {
					sum -= 500;
				} else {
					sum -= 20000;
				}
			}
			sumLabel.setText("현재 " + sum + " 원입니다.");
		}
	}
	
	public static void main(String[] args) {
		new CheckBoxItemEventEx();
	}
}
