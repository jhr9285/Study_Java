// 9-2 : 컨탠트팬의 배경색을 오렌지색으로 하고, 이곳에 OK, Cancel, Ignore 버튼들을 부착한 스윙 프로그램 작성
import java.awt.*;
import javax.swing.*;

public class ContentPaneEx extends JFrame { // JFrame 상속
	public ContentPaneEx() {
		setTitle("ContentPane과 JFrame");				 // 아래 코드 반드시 입력해야 함! 없으면 프레임만 닫힘
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // x 눌렀을 때 프레임 닫고 프로그램 종료되게 하는 코드.
		
		Container contentPane = getContentPane(); // Container 생성
		contentPane.setBackground(Color.ORANGE); // 배경색 지정 (색깔은 상수라서 대문자)
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40)); // 물이 흐르듯이 순서대로 배치되게 레이아웃 설정
											// FlowLayout(FlowLayout.정렬방향, 가로여백px, 세로여백px)
		contentPane.add(new JButton("OK")); // <- 원래는 레퍼런스변수 붙여서 버튼 누르면 이벤트 되게 해야 함
		contentPane.add(new JButton("Cancel"));
		contentPane.add(new JButton("Ignore"));
		
		setSize(300, 150); // 300 x 150 사이즈
		setVisible(true); // 보이게 하기
	}
	public static void main(String[] args) {
		new ContentPaneEx(); // 생성자함수 호출
	}

}
