// 9-4 : BorderLayout 배치관리자를 사용하여 컨탠트팬에 다음과 같이 5개의 버튼 컴포넌트를 삽입하시오.
//       (c.add 코드를 주석처리해두고 하나씩 주석 해제하면서 실행해서 비교해보면 알 수 있음)
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

public class BorderLayoutEx extends JFrame {
	public BorderLayoutEx() {
		setTitle("BorderLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout(30, 20)); // 컨테이너 c의 컴포넌트의 레이아웃을 가로여백 30 세로여백 20으로
		c.add(new JButton("Calculate"), BorderLayout.CENTER); // 중간에 하나 생기고, 다른 컴포넌트 없어서 여백X
		c.add(new JButton("add"), BorderLayout.NORTH); // 세로여백 발생
		c.add(new JButton("sub"), BorderLayout.SOUTH); 
		c.add(new JButton("mul"), BorderLayout.EAST); // 가로여백 발생
		c.add(new JButton("div"), BorderLayout.WEST);
		
		setSize(300, 200); // 프레임 크기 300 x 200
		setVisible(true); // 프레임 화면에 보이게 설정
	}
	
	public static void main(String[] args) {
		new BorderLayoutEx();
	}
}
