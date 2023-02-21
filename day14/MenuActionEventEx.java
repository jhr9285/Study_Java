// 14-2 : 메뉴아이템 선택 시 액션리스너 활용
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuActionEventEx extends JFrame {
	private JLabel imgLabel = new JLabel();
	
	public MenuActionEventEx() {
		this.setTitle("메뉴에 액션리스너 만들기 예제");
		createMenu();
		getContentPane().add(imgLabel, BorderLayout.CENTER);
		this.setSize(250, 220);
		this.setVisible(true);
	}
	private void createMenu() {
		JMenuBar mb = new JMenuBar();  // 메뉴바를 먼저 만들어야 함
		JMenuItem [] menuItem = new JMenuItem[4];
		String [] itemTitle = {"Load", "Hide", "ReShow", "Exit"};  // 메뉴아이템 이름 배열 생성
		JMenu screenMenu = new JMenu("Screen");  // 메뉴 이름 지정
		
		MenuActionListener listener = new MenuActionListener();  // 메뉴액션리스너
		for(int i = 0; i < menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]);
			menuItem[i].addActionListener(listener);
			screenMenu.add(menuItem[i]);
		}
		mb.add(screenMenu); // 메뉴를 메뉴바에 올림
		setJMenuBar(mb); // 메뉴바를 프레임에 올림
	}
	
	class MenuActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand(); // getActionCommand(): 이벤트가 발생한 메뉴아이템의 글자를 구함
			switch(cmd) {
			case "Load":
				if(imgLabel.getIcon() != null) {
					return; // 이미 이미지가 로딩되었으면 아래 코드 실행하지 않고 case "Load"문 즉시종료
				}
				imgLabel.setIcon(new ImageIcon("C:/myphoto/cherry.jpg"));
				break;
			case "Hide":
				imgLabel.setVisible(false);
				break;
			case "ReShow":
				imgLabel.setVisible(true);
				break;
			case "Exit":
				System.exit(0);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		new MenuActionEventEx();
	}
}
