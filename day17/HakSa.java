// Student와 BookRent 연결하는 HakSa (여기에는 드라이버 연결 코드 입력 X) ==> 미니 프로젝트 완료!
// 포트폴리오에 올릴 때 [ HakSa 구현 기술 : java, swing, jdbc, MySQL ] 이라고 적으면 됨
// 번외.
// 1) 로그인 기능 구현하기 (JDialog 이용) ==> DB에 저장된 아이디, 암호와 일치하는지 조사해서 일치하면 접속되도록 하기.
// 2) 학과별 도서대출 현황(%)을 파이차트로 그리기 (학과별 ==> GROUP BY 이용) ... (QUERY가 통계 내기가 어렵다.)
// 3) 도서 대출 기능 구현 (입력받아서 대출목록에 추가)
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HakSa extends JFrame {
	
	class LoginDialog extends JDialog {
		private JLabel lID = new JLabel("아 이 디 ");
		private JTextField tfID = new JTextField(10);
		private JLabel lPW = new JLabel("비밀번호 ");
		private JTextField tfPW = new JTextField(10);
		private JButton lBtn = new JButton("로그인");
		String id, pw;
		
		public LoginDialog(JFrame frame, String title, boolean modal) {
			super(frame, title, true);
			this.setLayout(new FlowLayout());
			this.add(lID);
			this.add(tfID);
			this.add(lPW);
			this.add(tfPW);
			this.add(lBtn);
			this.setSize(200, 200);
			
			lBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					id = tfID.getText();
					pw = tfID.getText();
					
					if(id == null || pw == null) {
						return;
					} else {
						setVisible(false);
					}
				}
			});
		}
	}

	private LoginDialog ld;
	
	// 4번 작업을 하기 위해서 패널 전역변수 선언
	JPanel panel; // 메뉴별 화면이 출력되는 패널
	
	public HakSa() {
		this.setTitle("학사관리 시스템");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ld = new LoginDialog(this, "LOGIN", true);
		
		ld.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// 메뉴 생성
		// 1. 메뉴바를 만든다.
		JMenuBar bar = new JMenuBar();
		
		// 2. 메뉴를 만들어서 메뉴바에 붙인다.
		JMenu m_student = new JMenu("학생관리");
		m_student.setFont(new Font("NanumGothic", Font.BOLD, 13));
		bar.add(m_student);
		JMenu m_book = new JMenu("도서관리");
		m_book.setFont(new Font("NanumGothic", Font.BOLD, 13));
		bar.add(m_book);
		
		// 3. 메뉴아이템을 만들어서 메뉴에 붙인다.
		JMenuItem mi_list = new JMenuItem("학생정보");
		mi_list.setFont(new Font("NanumGothic", Font.BOLD, 13));
		m_student.add(mi_list);
		JMenuItem mi_bookRent = new JMenuItem("도서정보");
		mi_bookRent.setFont(new Font("NanumGothic", Font.BOLD, 13));
		m_book.add(mi_bookRent);
		
		// 4. 학생정보, 도서정보를 누르면 패널이 나오게 한다. (이미 나온 패널이 있는 경우에는 지우고 올린다.)
		mi_list.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();			// 모든 자식 컴포넌트 삭제
				panel.revalidate();			// 자식 컴포넌트 위치 재조정
				panel.repaint();			// 다시 그리기
				panel.add(new Student());	// 학생 정보(Student 클래스) 패널 화면 생성
				panel.setLayout(null);		// 레이아웃 미적용
			}});
		
		mi_bookRent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();			// 모든 자식 컴포넌트 삭제
				panel.revalidate();			// 자식 컴포넌트 위치 재조정
				panel.repaint();			// 다시 그리기
				panel.add(new BookRent());	// 도서 정보(BookRent 클래스) 패널 화면 생성
				panel.setLayout(null);		// 레이아웃 미적용
			}});
		
		// 마지막. 메뉴바를 프레임에 붙이고, 패널을 프레임에 붙인다.
		setJMenuBar(bar);
		panel = new JPanel();
		add(panel);
		
		ld.setVisible(true);
		
		this.setSize(500, 520);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new HakSa();
	}
}
