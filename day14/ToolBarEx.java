// 14-3 : 툴바 만들기
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class ToolBarEx extends JFrame {
	private Container contentPane;
	
	public ToolBarEx() {
		this.setTitle("툴바 만들기");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		createToolBar();
		this.setSize(400, 200);
		this.setVisible(true);
	}
	
	private void createToolBar() {
		JToolBar toolBar = new JToolBar("ToolBar Menu");
		toolBar.setBackground(Color.LIGHT_GRAY);
		
		toolBar.add(new JButton("New"));
		toolBar.add(new JButton(new ImageIcon("C:/myphoto/open.jpg")));
		
		toolBar.addSeparator();
		
		toolBar.add(new JButton(new ImageIcon("C:/myphoto/save.jpg")));
		
		toolBar.add(new JLabel("search"));
		toolBar.add(new JTextField("text field"));
		
		JComboBox combo = new JComboBox();
		combo.addItem("Java");
		combo.addItem("C#");
		combo.addItem("C");
		combo.addItem("C++");
		
		toolBar.add(combo);
		contentPane.add(toolBar, BorderLayout.NORTH);
	}
	
	public static void main(String[] args) {
		new ToolBarEx();
	}
}
