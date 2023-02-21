// 11-7 : JRadioButton과 Item 이벤트를 이용하여 과일 사진 보여주기
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonItemEventEx extends JFrame {
	private JRadioButton[] radio = new JRadioButton[3]; // 라디오 버튼 배열 생성, 크기 3
	private String[] text = {"사과", "배", "체리"};
	private ImageIcon[] image = {new ImageIcon("images/apple.jpg"),   // ★이 코드 중요!!
								 new ImageIcon("images/pear.jpg"),    // 생성자로 객체 만들자마자 배열에 넣어서
								 new ImageIcon("images/cherry.jpg")}; // 레퍼런스를 배열 원소로 넣음
	
	private JLabel imageLabel = new JLabel();
	
	public RadioButtonItemEventEx() {
		this.setTitle("라디오버튼 Item Event 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout()); 		// 보더레이아웃 설정  (패널 레이아웃 기본값 : 플로우레이아웃)
												//					  (프레임 레이아웃 기본값 : 보더레이아웃)
		JPanel radioPanel = new JPanel();		// 패널 생성
		radioPanel.setBackground(Color.GRAY); 	// 패널 배경색 회색으로 설정
		
		ButtonGroup g = new ButtonGroup(); 		// 라디오버튼 그룹 생성
		
		for(int i = 0; i < radio.length; i++) {	 
			radio[i] = new JRadioButton(text[i]); // 라디오버튼 배열에 text 배열 원소를 갖는 라디오버튼 객체 넣음 
			g.add(radio[i]);					  // 라디오버튼 그룹에 라디오버튼 배열 원소 넣음
			radioPanel.add(radio[i]);			  // 패널에 라디오버튼 배열 넣음
			radio[i].addItemListener(new MyItemListener()); // 라디오버튼 배열에 아이템리스너 적용
		}
		
		radio[2].setSelected(true); // 라디오버튼 배열 3번째 원소를 선택해둔 상태로 초기화
		c.add(radioPanel, BorderLayout.NORTH); // 컨테이너에 패널을 북쪽에 배치
		c.add(imageLabel, BorderLayout.CENTER); // 컨테이너에 imageLabel을 가운데에 배치
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER); // imageLabel을 수평정렬에서 가운데에 배치
		
		setSize(250, 200);
		setVisible(true);
	}
	
	class MyItemListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.DESELECTED) { // 상태 바뀌었을 때 해제 상태면
				return;										 // 즉시종료
			}
			if(radio[0].isSelected()) { 		// isSelected() : 선택되었으면 true, 해제되었으면 false 반환
				imageLabel.setIcon(image[0]);
			} else if(radio[1].isSelected()) {
				imageLabel.setIcon(image[1]);
			} else {
				imageLabel.setIcon(image[2]);
			}
		}
	}
	
	public static void main(String[] args) {
		new RadioButtonItemEventEx();
	}

}
