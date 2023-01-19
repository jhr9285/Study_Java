// 7-7 : id와 전화번호로 구성되는 Student 클래스를 만들고,
// 		 이름을 키로 하고 Student 객체를 값으로 하는 해시맵을 작성하시오.
import java.util.*;

class Student {
	private int id;
	private String tel;
	
	public Student() {
		
	}
	public Student(int id, String tel) {
		this.id = id;
		this.tel = tel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}

public class Day0903 {

	public static void main(String[] args) {
		HashMap<String, Student> map = new HashMap<String, Student>();
		
		map.put("황기태", new Student(1, "010-111-1111"));
		map.put("이재문", new Student(2, "010-222-2222"));
		map.put("김남윤", new Student(3, "010-333-3333"));
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("이름 검색 : ");
			String name = scanner.nextLine();
			if(name.equals("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			Student student = map.get(name);
			if(student == null) {
				System.out.println(name + " 은/는 없는 사람입니다.");
			} else {
				System.out.println("id" + student.getId() + ", 전화번호 : " + student.getTel());
			}
		}
		scanner.close();
	}

}
