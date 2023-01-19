import java.util.Scanner; // java.util : 자바의 패키지 , 이렇게 불러들여야 Scanner 클래스를 사용할 수 있다.
                          // 자동 import 단축키 : ctrl + shift + O (영어)
public class Sample02 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); // Scanner 클래스는 자바에 이미 만들어져 있는 클래스임. / System.in : 사용자가 직접 입력할 수 있게 함
		System.out.print("이름을 입력하세요 : ");  // 콘솔창에 사용자가 데이터 입력 가능! (콘솔 = cmd)
		String name = s.next();  // next 메소드가 입력한 데이터를 읽어서 name 에 넣음
		System.out.println(name);  // name 변수에 입력된 데이터 출력
		
		s.close();
	}
	

}
