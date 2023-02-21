import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookRent extends JPanel {
	DefaultTableModel model = null;
	JTable table = null;
	Connection conn = null;
	
	Statement stmt;
	String query;
	
	public BookRent() {
		query = "SELECT student.id, student.name, books.title, bookRent.rDate "
				+ "FROM student, books, bookRent"
				+ "WHERE student.id = bookRent.id AND books.no = bookRent.bookNo";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root", "1234");
			stmt = conn.createStatement();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
//		this.setTitle("학생관리");
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(null);
		
		JLabel l_dept = new JLabel("학과");
		l_dept.setBounds(10, 10, 30, 20);
		add(l_dept);
		
		String[] dept = {"전체", "컴퓨터시스템", "멀티미디어", "컴퓨터공학", "국어국문학과", "철학과", "전기공학과"};
		JComboBox cb_dept = new JComboBox(dept);
		cb_dept.setBounds(45, 10, 100, 20);
		add(cb_dept);
		cb_dept.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				query = "SELECT student.id, student.name, books.title, bookRent.rDate "
						+ "FROM student, books, bookRent "
						+ "WHERE student.id = bookRent.id AND books.no = bookRent.bookNo";
				
				JComboBox cb = (JComboBox)e.getSource(); // 이벤트가 발생한 콤보박스 구하기
				// 동적쿼리
				if(cb.getSelectedIndex() == 0) { 	// 전체 선택했을 때
					query += " ORDER BY student.id";
				} else if(cb.getSelectedIndex() == 1) { // 컴퓨터시스템 선택했을 때
					query += " AND student.dept ='컴퓨터시스템' ORDER BY bookRent.no" ;
				} else if(cb.getSelectedIndex() == 2) { // 멀티미디어 선택했을 때
					query += " AND student.dept ='멀티미디어' ORDER BY bookRent.no" ;
				} else if(cb.getSelectedIndex() == 3) { // 컴퓨터공학 선택했을 때
					query += " AND student.dept ='컴퓨터공학' ORDER BY bookRent.no" ;
				} else if(cb.getSelectedIndex() == 4) { // 국어국문학과 선택했을 때
					query += " AND student.dept ='국어국문학과' ORDER BY bookRent.no" ;
				} else if(cb.getSelectedIndex() == 5) { // 철학과 선택했을 때
					query += " AND student.dept ='철학과' ORDER BY bookRent.no" ;
				} else if(cb.getSelectedIndex() == 6) { // 전기공학과 선택했을 때
					query += " AND student.dept ='전기공학과' ORDER BY bookRent.no" ;
				} 
				
				list(); // 목록 출력
			}
		});
		
		String[] colName = {"학번", "이름", "도서명", "대출일"};
		model = new DefaultTableModel(colName, 0);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(470, 200));
		add(table);
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(10, 40, 460, 250);
		add(sp);
		
		this.setSize(490, 400);
		this.setVisible(true);
	}
	
	public void list() {
		try {
			ResultSet rs = stmt.executeQuery(query);
			
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
