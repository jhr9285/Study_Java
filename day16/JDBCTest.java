// java 응용프로그램과 SQL 연결 - JDBC
// mysql-connector-java-5.1.49.jar : sql 드라이버 ==> 프로젝트 폴더에 복사붙여넣기
// 프로젝트명 우클릭 - properties - java build path - Libraries - ModulePath 클릭
// - ADD JARs - 복사해놓은 드라이버 클릭 - apply - apply and close
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs = null; // SQL문 실행 결과를 얻어오기 위한 인터페이스, 클라이언트 측 커서(cursor) 역할
		Statement st = null; // SQL문을 실행하기 위한 클래스, select문 - executeQuery(), i,u,d - executeUpdate()
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root", "1234");
			System.out.println("DB 연결 완료");
			System.out.println("===========================");
			System.out.println(" 학번 \t 이름 \t 학과");
			System.out.println("===========================");
		
			st = conn.createStatement(); // ctrl + shift + o ==> java.sql.~ 삽입
			
			// !CRUD 처리!
			// executeUpdate는 하나의 코드만 실행 가능한 듯... 두 개 이상 동시 실행 오류...
			// insert문
			st.executeUpdate("INSERT INTO student VALUES('4583145', '홍길동', '철학과');");
			// delete문
			st.executeUpdate("DELETE FROM student WHERE id = '2456785';");
			// update문
			st.executeUpdate("UPDATE student SET dept = '전기공학과' WHERE id = '1091011';");
			
			// select문
			rs = st.executeQuery("SELECT * FROM student");
			
			while(rs.next()) { // rs.next() 데이터가 있으면 true
				System.out.print(rs.getString("id") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getString("dept") + "\n");
			}
			
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		} catch (SQLException e) {
				e.printStackTrace();
		} finally { // finally 블럭에 rs 입력하려면 rs 변수를 전역변수로 선언해야 함
			try {
				// 연 순서 : conn -> st -> rs ==> 닫는 순서 : rs -> st -> conn 
				rs.close(); // close()는 try,catch 필요한 메소드로, 항상 꼭 해야 한다.
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
