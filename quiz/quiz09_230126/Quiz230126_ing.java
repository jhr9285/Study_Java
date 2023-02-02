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
import java.io.File;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quiz230126_ing extends JFrame {
	File file = new File("C:\\myphoto");
	File [] subFiles;
	ImageIcon [] images;
	int cnt;
	{
		subFiles = new File[10];
		subFiles = file.listFiles();
		images = new ImageIcon[subFiles.length];
		
		for(int i = 0; i < subFiles.length; i++) {
			images[i] = new ImageIcon(subFiles[i].getPath());  
		}
		cnt = 0;
	}
	public JPanel panelBtn = new JPanel();
	public JPanel panelImg = new JPanel();
	private JLabel imgLabel = new JLabel(images[cnt]); 
	private JButton btnPrev = new JButton("prev");	
	private JButton btnNext = new JButton("next");
	
	public Quiz230126_ing() {
		this.setTitle("사진 갤러리");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(null);
		panelBtn.setLocation(30, 10);
		panelBtn.setSize(200, 40);
		panelImg.setLocation(1, 42);
		panelImg.setSize(300, 300);
		imgLabel.setLocation(30, 30);
		c.add(panelBtn);
		c.add(panelImg);
		panelBtn.add(btnPrev);
		panelBtn.add(btnNext);
		panelImg.add(imgLabel);
		
		btnPrev.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if(cnt == 0) {
					cnt = subFiles.length - 1;
				} else {
					cnt -= 1;
				}
				imgLabel.setIcon(images[cnt]);
			}
		});
		
		btnNext.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				if(cnt == subFiles.length - 1) {
					cnt = 0;
				} else {
					cnt++;
				}
				imgLabel.setIcon(images[cnt]);
			}
		});
		
		this.add(panelBtn);
		this.add(panelImg);
		
		this.setSize(300, 250);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Quiz230126_ing();
	}
}