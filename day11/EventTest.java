import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyActionListener implements ActionListener { // 7)이벤트 처리 위한 클래스 만들기
	@Override
	public void actionPerformed(ActionEvent e) { // 8)반드시 ActionListener의 추상메소드를 오버라이딩 해야 함
		System.out.println("버튼이 클릭됨.");
	}
}
								   // 세부 순서 : 1) ~ 9)
															// 큰 틀에서의 순서 : 1. ~ 3.
public class EventTest extends JFrame implements ActionListener {   // 1. JFrame 상속 (+ 액션리스너 직접상속)
	EventTest() {													// 2. 생성자 생성
		this.setTitle("학사관리"); // 1)제목 지정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 2)닫기 버튼 누르면 프로그램 종료되는 코드(필수)
		
		// 제목, 닫기-종료 코드 - 사이즈, 보이게 하기 코드 사이에 다른 코드를 써야 한다.
		
		setLayout(new FlowLayout()); // 6)레이아웃 지정 (안하면 프레임 전체가 버튼이 됨)
		
		JButton btn1 = new JButton("등록"); // 5)버튼만들기
		btn1.addActionListener(new MyActionListener()); // 9)액션리스너와 btn1 연결(소괄호 안에서 클래스 객체화)
														//   .addActionListener 사용!
		
		JButton btn2 = new JButton("목록"); // 익명클래스 사용하기 위한 두 번째 버튼 생성
		btn2.addActionListener(new ActionListener() { // 익명클래스 형식
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼2가 클릭됨.");
			}});
		
		JButton btn3 = new JButton("수정");
		btn3.addActionListener(this);  // 소괄호 안에 자기자신, 즉 this를 입력하면 네번째 방법이 실행된다.
		
		add(btn1);
		add(btn2);
		add(btn3);
		
		// 제목, 닫기-종료, 사이즈, 보이게 하기 코드 사이에 다른 코드를 써야 한다.
		
		setSize(500, 300); // 3)가로 세로 사이즈 지정
		setVisible(true); // 4)화면에 보이게 해주는 코드(필수)
	}
	
	public static void main(String[] args) {
		new EventTest();											// 3. 생성자 호출
		
	}
	
	// 네번째 방법인 액션리스너 직접 상속 -> actionPerformed() 오버라이딩이 main 메소드 안에서 이루어진다.
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼3이 클릭됨.");
	}

}
