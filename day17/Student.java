// 1. HakSa 프로젝트에 '주소'를 추가해서 구현하기.
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Student extends JPanel { // JFrame -> JPanel 로 수정했음
	
//====== 1. 레이블과 입력창을 만든다.========================================================================
	JLabel lblID = null; // lbl : label, ID : 학번
	JLabel lblName = null; 
	JLabel lblDepartment = null;
	JLabel lblAddress = null;
	JTextField tfID = null; // tf: textfield, ID : 학번 입력할 곳  (textfield는 JS의 input과 유사한 기능)
	JTextField tfName = null;
	JTextField tfDepartment = null;
	JTextField tfAddress = null;
	JTextArea taList = null; // ta : textarea - 목록 만들기
	JButton btnInsert = null, btnList = null, btnUpdate = null, btnDelete = null; // btn : button - 버튼 만들기
	
	// 텍스트에어리어에 넣을 테이블 생성 (model : 데이터)
	DefaultTableModel model = null; 
	JTable table = null;
	
	// 학번 텍스트에어리어 옆에 배치할 검색 버튼 생성
	JButton btnSearch = null;
	
	public Student() {
//		this.setTitle("학사관리");  // 패널은 타이틀이 없다. 타이틀은 프레임에만 있다.
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 패널은 닫기 버튼도 없다. 닫기 버튼도 프레임에만 있다.
		this.setLayout(new FlowLayout()); // 설정 안하면 프레임 기본값 보더레이아웃으로 나타남
		
//====== 2. 레이블과 입력창 객체를 생성한다.=================================================================								
		this.lblID = new JLabel("학번"); // "학번" : 레이블 이름
		lblID.setFont(new Font("NanumGothic", Font.BOLD, 13));
		this.tfID = new JTextField(32); 		// 14 : 컬럼 사이즈 (글자수)
		this.btnSearch = new JButton("Search");	// 학번 검색할 버튼 생성
		btnSearch.setFont(new Font("NanumGothic", Font.BOLD, 13));
		
		this.lblName = new JLabel("이름");
		lblName.setFont(new Font("NanumGothic", Font.BOLD, 13));
		this.tfName = new JTextField(39);
		
		this.lblDepartment = new JLabel("학과");
		lblDepartment.setFont(new Font("NanumGothic", Font.BOLD, 13));
		this.tfDepartment = new JTextField(39);
		
		this.lblAddress = new JLabel("주소");
		lblAddress.setFont(new Font("NanumGothic", Font.BOLD, 13));
		this.tfAddress = new JTextField(39);
		
		this.taList = new JTextArea(19, 23); 	// 매개변수 : 행 갯수, 열 갯수
		
		this.btnInsert = new JButton("등록");	// Create - insert  (CRUD 외우기!)
		this.btnList = new JButton("목록"); 	// Read	  - select
		this.btnUpdate = new JButton("수정");	// Update - update
		this.btnDelete = new JButton("삭제"); 	// Delete - delete
		
		btnInsert.setFont(new Font("NanumGothic", Font.BOLD, 13));
		btnList.setFont(new Font("NanumGothic", Font.BOLD, 13));
		btnUpdate.setFont(new Font("NanumGothic", Font.BOLD, 13));
		btnDelete.setFont(new Font("NanumGothic", Font.BOLD, 13));
		
//====== 3. 레이블과 입력창 객체를 프레임에 연결한다. (혹은 패널, 혹은 컨테이너) ===========================
		this.add(lblID); 
		this.add(tfID);
		this.add(btnSearch);// 학번 옆에 배치해야 하므로 tfID 다음에 btnSearch 추가
		this.add(lblName);
		this.add(tfName);
		this.add(lblDepartment);
		this.add(tfDepartment);
		this.add(lblAddress);
		this.add(tfAddress);
//		this.add(new JScrollPane(this.taList)); // 텍스트에어리어에 스크롤을 적용
		
		// 테이블 내 컬럼명 생성하여 JTable 객체 생성하고 model과 연결, 스크롤 적용
		// FlowLayout은 순서대로 배치되기 때문에 버튼 앞에 테이블이 들어와야 함
		String colName[] = {"학번", "이름", "학과", "주소"};
		model = new DefaultTableModel(colName, 0);
		table = new JTable(model);
		table.setFont(new Font("NanumGothic", Font.PLAIN, 13));
		table.setPreferredScrollableViewportSize(new Dimension(450, 280));
		add(new JScrollPane(table));

		table.getColumnModel().getColumn(3).setPreferredWidth(200); // 주소만 컬럼 너비 늘리는 코드
		
		this.add(btnInsert);
		this.add(btnList);
		this.add(btnUpdate);
		this.add(btnDelete);
		
//====== 4. 이벤트 처리 코드를 입력한다. ====================================================================
		
		// 목록 버튼 이벤트 처리
		this.btnList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				ResultSet rs = null; // SQL문 실행 결과를 얻어오기 위한 인터페이스, 클라이언트 측 커서(cursor) 역할
				Statement st = null; // SQL문을 실행하기 위한 클래스, select문 - executeQuery(), i,u,d - executeUpdate()
				try {
					// Oracle과 연결
					// (같은 프로젝트 내에 ojbdc6.jar 필요, 프로젝트명 우클릭-properties에서 드라이버 추가)
//					Class.forName("oracle.jdbc.driver.OracleDriver"); // 소괄호 안에 드라이버 이름 입력
//					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ora_user","hong");
					// xe : 정품오라클인 경우 orcl이므로 orcl로 수정해야 함
					
					// MySQL과 연결
					// (같은 프로젝트 내에 mysql-connector-java-5.1.49.jar 필요, 프로젝트명 우클릭-properties에서 드라이버 추가)
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root", "1234");
					
//					System.out.println("DB 연결 완료");
//					System.out.println("===========================");
//					System.out.println(" 학번 \t 이름 \t 학과");
//					System.out.println("===========================");
				
					st = conn.createStatement(); // ctrl + shift + o ==> java.sql.~ 삽입
					// select문
					rs = st.executeQuery("SELECT * FROM student");
					
//					taList.setText(""); // 목록 버튼을 연속으로 누르는 경우 똑같은 내용이 덧붙여지는 상황 방지 (초기화)
				    model.setNumRows(0); //JTable 초기화 (위와 유사한 기능)
					
//					taList.append("학번\t이름\t학과\n");
//					taList.append("====================================\n");
//					
					while(rs.next()) { // rs.next() 데이터가 있으면 true
//						System.out.print(rs.getString("id") + "\t");    // 콘솔에 출력하는 코드
//						System.out.print(rs.getString("name") + "\t");	// 콘솔에 출력하는 코드
//						System.out.print(rs.getString("dept") + "\n");	// 콘솔에 출력하는 코드
//						
//						taList.append(rs.getString("id") + "\t"); 	// 텍스트에어리어에 출력하는 코드
//						taList.append(rs.getString("name") + "\t");  // 텍스트에어리어에 출력하는 코드
//						taList.append(rs.getString("dept") + "\n");  // 텍스트에어리어에 출력하는 코드
						
						// 컬럼명을 배열에 정리
						String[] row = new String[4];
						row[0] = rs.getString("id"); // rs.getString("id"): select문에서 컬럼이 id인 데이터들 불러옴
						row[1] = rs.getString("name");
						row[2] = rs.getString("dept");
						row[3] = rs.getString("address");
						model.addRow(row); // 모델에 addRow로 row 배열 추가하면 순서대로 출력됨
					}
					
				} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
				} catch (SQLException e2) {
						e2.printStackTrace();
				} finally { // finally 블럭에 rs 입력하려면 rs 변수를 전역변수로 선언해야 함
					try {
						// 연 순서 : conn -> st -> rs ==> 닫는 순서 : rs -> st -> conn 
						rs.close(); // close()는 try,catch 필요한 메소드로, 항상 꼭 해야 한다.
						st.close();
						conn.close();
					} catch (SQLException e3) {
						e3.printStackTrace();
					}
				}
			}
		});
		
		// 등록 버튼 이벤트 처리
		this.btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				ResultSet rs = null; 
				Statement st = null; 
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root", "1234");
					st = conn.createStatement();
					
					// insert문
					st.executeUpdate("INSERT INTO student VALUES('" + tfID.getText() + "', '"+ tfName.getText() +"', '"+ tfDepartment.getText() +"', '"+ tfAddress.getText() +"');");
					// 텍스트에어리어 초기화
					tfID.setText("");
					tfName.setText("");
					tfDepartment.setText("");
					tfAddress.setText("");
					// select문 - 등록 후 갱신된 목록 출력
					rs = st.executeQuery("SELECT * FROM student");
					
				    model.setNumRows(0); 

					while(rs.next()) { 
						String[] row = new String[4];
						row[0] = rs.getString("id"); 
						row[1] = rs.getString("name");
						row[2] = rs.getString("dept");
						row[3] = rs.getString("address");
						model.addRow(row); 
					}
					
				} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
				} catch (SQLException e2) {
						e2.printStackTrace();
				} finally { 
					try {
						rs.close(); 
						st.close();
						conn.close();
					} catch (SQLException e3) {
						e3.printStackTrace();
					}
				}
			} 
		});
		
		// 삭제 버튼 이벤트 처리
		this.btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // 팝업 다이얼로그 (모달 다이얼로그)
				int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
										     			// 부모 관련 부분 , 팝업창 질문, 팝업창 제목, 팝업창 버튼 옵션
				System.out.println(result);  // ==> 콘솔창 결과 : yes -> 0, no -> 1, close(닫기버튼) -> -1
				
				// yes 버튼을 누르면 result가 0이다.
				// if(result == 0)  ==> JOptionPane.YES_OPTION = 0! 상수!
				if(result == JOptionPane.YES_OPTION) { 
					Connection conn = null;
					ResultSet rs = null; 
					Statement st = null; 
					try {
						Class.forName("com.mysql.jdbc.Driver");
						conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root", "1234");
						st = conn.createStatement();
						
						// delete문
						st.executeUpdate("DELETE FROM student WHERE id = '" + tfID.getText() + "'");
						// 텍스트에어리어 초기화
						tfID.setText(""); // "" 부분을 null 로 해도 동일한 결과 나옴 
						tfName.setText("");
						tfDepartment.setText("");
						tfAddress.setText("");
						// select문 - 등록 후 갱신된 목록 출력
						rs = st.executeQuery("SELECT * FROM student");
						
					    model.setNumRows(0); 

						while(rs.next()) { 
							String[] row = new String[4];
							row[0] = rs.getString("id"); 
							row[1] = rs.getString("name");
							row[2] = rs.getString("dept");
							row[3] = rs.getString("address");
							model.addRow(row); 
						}
						
					} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
					} catch (SQLException e2) {
							e2.printStackTrace();
					} finally { 
						try {
							rs.close(); 
							st.close();
							conn.close();
						} catch (SQLException e3) {
							e3.printStackTrace();
						}
					}
					JOptionPane.showMessageDialog(null, "삭제되었습니다.");
				} else {
					// yes 버튼을 누르지 않은 경우, 아무것도 하지 않는다. else문은 쓸 필요 없다.
				}
			}
		});
		
		// 검색 버튼 이벤트 처리
		this.btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Connection conn = null;
				ResultSet rs = null; 
				Statement st = null; 
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root", "1234");
					st = conn.createStatement(); 

					// select문
					rs = st.executeQuery("SELECT * FROM student WHERE id = '" + tfID.getText() + "'");
					
				    model.setNumRows(0); 
					
					while(rs.next()) { 
						// 수정을 위해 텍스트에어리어에 검색한 사람의 정보 띄우기
						tfID.setText(rs.getString("id"));
						tfName.setText(rs.getString("name"));
						tfDepartment.setText(rs.getString("dept"));
						tfAddress.setText(rs.getString("address"));

						String[] row = new String[4];
						row[0] = rs.getString("id"); 
						row[1] = rs.getString("name");
						row[2] = rs.getString("dept");
						row[3] = rs.getString("address");
						model.addRow(row); 
					}
					
				} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
				} catch (SQLException e2) {
						e2.printStackTrace();
				} finally { 
					try {
						rs.close(); 
						st.close();
						conn.close();
					} catch (SQLException e3) {
						e3.printStackTrace();
					}
				}
			}
		});
		
		// 수정 버튼 이벤트 처리
		this.btnUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "수정하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
				System.out.println(result); 
				
				if(result == JOptionPane.YES_OPTION) { 
					Connection conn = null;
					ResultSet rs = null; 
					Statement st = null; 
					try {
						Class.forName("com.mysql.jdbc.Driver");
						conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root", "1234");
						st = conn.createStatement();
						
						// update문
						st.executeUpdate("UPDATE student SET name = '"+ tfName.getText() 
										+"', dept = '" + tfDepartment.getText() 
										+ "', address = '"+ tfAddress.getText()
										+ "' WHERE id = '" + tfID.getText() + "'");
						// select문 - 등록 후 갱신된 목록 출력
						rs = st.executeQuery("SELECT * FROM student");
						
					    model.setNumRows(0); 
	
						while(rs.next()) { 
							String[] row = new String[4];
							row[0] = rs.getString("id"); 
							row[1] = rs.getString("name");
							row[2] = rs.getString("dept");
							row[3] = rs.getString("address");
							model.addRow(row); 
						}
						
					} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
					} catch (SQLException e2) {
							e2.printStackTrace();
					} finally { 
						try {
							rs.close(); 
							st.close();
							conn.close();
						} catch (SQLException e3) {
							e3.printStackTrace();
						}
					}
				}
			}
		});
		
		// 마우스 클릭 이벤트 처리
		this.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table = (JTable)e.getComponent(); // 클릭한 테이블 구하기
				model = (DefaultTableModel)table.getModel(); // 클릭한 테이블의 모델(데이터) 구하기
				String id = (String)model.getValueAt(table.getSelectedRow(), 0); // getSelectedRow() : 현재 선택한 행의 인덱스 반환
					tfID.setText(id);
				String name = (String)model.getValueAt(table.getSelectedRow(), 1);
					tfName.setText(name);
				String dept = (String)model.getValueAt(table.getSelectedRow(), 2);
					tfDepartment.setText(dept);
				String address = (String)model.getValueAt(table.getSelectedRow(), 3);
					tfAddress.setText(address);
			}
		});
		
		// 프레임 사이즈, 보이기 여부 지정
		this.setSize(495, 450); // HakSa 사이즈에서 어그러지지 않게 출력되도록 사이즈 조정
		this.setVisible(true);
	}
}