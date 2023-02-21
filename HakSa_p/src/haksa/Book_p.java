// 도서 대출
package haksa;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class Book_p extends JPanel {
	DefaultTableModel model;
	Connection conn = null;
	PreparedStatement psmt;
	String query, addQuery, bookCountQuery, majorCountQuery, rentMajorCountQuery, rentCountQuery;
	String inputId, inputBook, rentTime;
	Date now;
	SimpleDateFormat dateFormat;
	
	public Book_p() {
		
		JTable table;
		
		query = "SELECT student.id, student.name, books.title, bookRent.rDate "
				+ "FROM student, books, bookRent "
				+ "WHERE student.id = bookRent.id AND books.no = bookRent.bookNo";
		
		this.setLayout(null);
		
		Font ng = new Font("NanumGothic", Font.BOLD, 14);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root", "1234");
			psmt = conn.prepareStatement(query);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		int start = 20;
		
		JLabel l_id = new JLabel("학 번");
		l_id.setFont(ng);
		l_id.setBounds(start, start, 50, 20);
		add(l_id);
		JTextField tf_id = new JTextField(20);
		tf_id.setBounds(start*4, start, 220, 20);
		add(tf_id);
		JButton rentBtn = new JButton("대출기록 추가");
		rentBtn.setBounds(start*6+200, start, 130, 37);
		rentBtn.setFont(ng);
		add(rentBtn);
		JLabel l_book = new JLabel("책번호");
		l_book.setBounds(start, start*2, 50, 20);
		l_book.setFont(ng);
		add(l_book);
		JTextField tf_book = new JTextField(20);
		tf_book.setBounds(start*4, start*2, 220, 20);
		add(tf_book);
		
		rentBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				ResultSet rs = null; 
				PreparedStatement psmt = null; 
				inputId = tf_id.getText().trim();
				inputBook = tf_book.getText().trim();
				now = new Date();
				dateFormat = new SimpleDateFormat("yyyyMMdd");
				rentTime = dateFormat.format(now).toString();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root", "1234");
					psmt = conn.prepareStatement(query);
					
					addQuery = "SELECT * FROM student"
							 + " WHERE student.id = '" + inputId + "'";
					
					rs = psmt.executeQuery(addQuery);
				
					if(inputId.length() == 0 || inputBook.length() == 0) {
						JOptionPane.showMessageDialog(null, "정보가 모두 입력되지 않았습니다. 다시 입력하세요.");
						return;
					} else {
						if(rs.next()) {
							psmt.executeUpdate("INSERT INTO bookRent VALUES('" 
											 + (rentTime + "11")  
											 + "', '" + inputId
											 + "', '" + inputBook 
											 + "', '" + rentTime 
											 + "')");
							list();
							JOptionPane.showMessageDialog(null, "대출기록이 추가되었습니다.");
						} else {
							JOptionPane.showMessageDialog(null, "rs.next() 값이 존재하지 않습니다.");
						}
					}
						
					} catch (ClassNotFoundException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (SQLException e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					} finally { 
						try {
							rs.close(); 
							psmt.close();
							conn.close();
						} catch (SQLException e3) {
							JOptionPane.showMessageDialog(null, e3.getMessage());
						}
					}
				}
			});
		
		String[] colName = {"학번", "이름", "도서명", "대출일"};
		model = new DefaultTableModel(colName, 0);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(440, 320));
		add(table);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(20, 80, 440, 320);
		add(sp);

		
		list();
		
		this.setSize(490, 440);
		this.setVisible(true);
	}
	
	public void list() {
		try {
			ResultSet rs = psmt.executeQuery(query);
			
			model.setNumRows(0);
			
			while(rs.next()){
				String[] row = new String[4];
				row[0] = rs.getString("id");
				row[1] = rs.getString("name");
				row[2] = rs.getString("title");
				row[3] = rs.getString("rDate");
				model.addRow(row);
			}
			rs.close();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
