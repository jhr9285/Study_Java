// 1.예제11-13에서 콤보박스대신 prev,next버튼으로 갤러리 프로그램 만들기
//
//	1) 처음, 마지막으로 까지 가면 더이상 넘어가지 않게 하기
//	2) 처음에서 prev누르면 맨뒤로, 마지막에서 next누르면 맨앞으로 가게 하기

//	1)먼저 구현후 2)구현 해보세요.
//	---------------------------------------------
//	번외.
//	1) c:\\myphoto 폴더를 만든다.
//	2) 사진이미지를 1)에 복사한다.
//	3) 1)안의 이미지파일 목록을 구한다. (isDirectory(), isFile() 로 체크 후 디렉토리 빼고 listFiles()로 목록 뽑기) 
//	4) 3)을 이용해서 갤러리 프로그램을 구현한다.
package quiz09_230126;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Quiz230126_ing_2 extends JFrame {
//	public static void listFile(File dir) {
//		System.out.println("-----" + dir + "의 서브리스트입니다.-----");
//		file = new File("C:\\myphoto");
//		subFiles = file.listFiles();
//		for(File f3 : subFiles) {
//			System.out.print(f3.getName() + "\t");
//			System.out.print(f3.length() + "\t");
//			SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss"); 
//			System.out.println(sf.format(f3.lastModified()));
//			
//			for(int i = 0; i < subFiles.length; i++) {
//				images[i] = new ImageIcon(subFiles[i].getPath());  
//			}
//		}
//	}
	int cnt = 0;
	
	public JPanel panelBtn = new JPanel();
	public JPanel panelImg = new JPanel();
	private JLabel imgLabel = null;
	private ImageIcon [] images;
	private JButton btnPrev = new JButton("prev");	
	private JButton btnNext = new JButton("next");
	
	public Quiz230126_ing_2() {
		File file = new File("C:\\myphoto");
		File [] subFiles =  file.listFiles();;
		
		for(File f3 : subFiles) {
			System.out.print(f3.getName() + "\t");
			System.out.print(f3.length() + "\t");
			SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss"); 
			System.out.println(sf.format(f3.lastModified()));
		}
		
		images = new ImageIcon[subFiles.length];
		for(int i = 0; i < subFiles.length; i++) {
			images[i] = new ImageIcon(subFiles[i].getPath());  
		}
		imgLabel = new JLabel(images[cnt]);
		
		this.setTitle("사진 갤러리");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel btnP = new JPanel();
		btnP.add(btnPrev);
		btnP.add(btnNext);
		
		c.add(imgLabel, BorderLayout.CENTER);
		c.add(btnP, BorderLayout.SOUTH);
//		panelBtn.setLocation(30, 10);
//		panelBtn.setSize(200, 40);
//		panelImg.setLocation(1, 42);
//		panelImg.setSize(300, 300);
//		imgLabel.setLocation(30, 30);
//		imgLabel.setSize(300, 300);
//		c.add(panelBtn);
//		c.add(panelImg);
//		panelBtn.add(btnPrev);
//		panelBtn.add(btnNext);
//		panelImg.add(imgLabel);
		
		btnPrev.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
//				JButton btn1 = (JButton)e.getSource(); 
				if(cnt > 0) {
					cnt--;					
				}else if(cnt == 0) {
					cnt = images.length - 1;
				}
				if(cnt != 0) {
					imgLabel.setIcon(images[cnt]);					
				}else if(cnt == 0) {
					imgLabel.setIcon(images[0]);					
				}
			}
		});
		
		btnNext.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
//				JButton btn2 = (JButton)e.getSource(); 
				if(cnt < images.length-1) {
					cnt++;					
				}else if(cnt == images.length - 1) {
					cnt = 0;
				}
				if(cnt != images.length-1) {
					imgLabel.setIcon(images[cnt]);						
				}else if(cnt == images.length-1) {
					imgLabel.setIcon(images[images.length-1]);							
				}
			}
		});
		
		
//		this.add(panelBtn);
//		this.add(panelImg);
		
		this.setSize(300, 250);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
//		File f1 = new File("C:\\myphoto\\cherry.jpg");
//		System.out.println(f1.getPath() + ", " + f1.getParent() + ", " + f1.getName());
//		String res = "";
//		if(f1.isFile()) {
//			res = "파일";
//		} else if(f1.isDirectory()) {
//			res = "디렉터리";
//		}
//		System.out.println(f1.getPath() + "은 " + res + "입니다.");
		
//		listFile(file);
		
		new Quiz230126_ing_2();
		
	}
}
