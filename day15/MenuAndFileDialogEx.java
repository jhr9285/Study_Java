// 14-9 : 파일 열기 다이얼로그 생성
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuAndFileDialogEx extends JFrame {
	private JLabel imageLabel = new JLabel();
	public MenuAndFileDialogEx() {
		this.setTitle("Menu와 JFileChooser 활용 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.add(imageLabel);
		createMenu();
		this.setSize(350, 200);
		this.setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		
		openItem.addActionListener(new OpenActionListener());
		fileMenu.add(openItem);
		mb.add(fileMenu);
		setJMenuBar(mb);
	}
	
	class OpenActionListener implements ActionListener {
		private JFileChooser chooser;
		
		public OpenActionListener() {
			chooser = new JFileChooser();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images",
																		 "jpg", "gif", "png");
			chooser.setFileFilter(filter);
			
			int ret = chooser.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) { // 파일탐색기에서 열기 버튼을 누르지 않았을 때 (=취소 버튼)
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고!",  // 메세지 다이얼로그
											  JOptionPane.WARNING_MESSAGE);
				return;
			}
			String filePath = chooser.getSelectedFile().getPath();
			imageLabel.setIcon(new ImageIcon(filePath));
			pack(); // 이미지의 크기에 맞추어 프레임 크기를 조절하는 메소드
		}
	}
	
	public static void main(String[] args) {
		new MenuAndFileDialogEx();
	}

}
