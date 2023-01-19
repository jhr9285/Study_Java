// 6-2. Point 클래스에 Point 객체를 문자열로 리턴하는 toString() 메소드를 작성하시오.
// 6-3. Point 클래스에 두 점의 좌표가 같으면 true를 리턴하는 equals()를 작성하시오.

// private 필드를 사용하려면 getter setter가 있어야 한다.
class Point{
	private int x;
	private int y;
// source - generate constructor using fields... 클릭하면 생성자 자동생성
public Point(int x, int y) { 
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public boolean equals(Object obj) {  // 블럭 안의 내용은 개발자가 자유롭게 코딩한다.(오버라이딩)
		Point p = (Point)obj; // 다운캐스팅 (Object 타입을 Point 타입으로) 
		if(x == p.x && y == p.y) {
			return true;
		} else {
			return false;
		}
	}
	// source - generate getter and setter... 클릭하면 getter, setter 함수 자동생성 (private 멤버를 디폴트로 체크)
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
// source - generate toString()... 클릭하면 toString 함수 자동생성 (private 멤버를 디폴트로 체크해줌)
// 27행 ~ 30행 주석 처리 전후로 출력해보면 값이 다르게 나옴을 확인할 수 있다.
// (ctrl + / : 선택한 영역 모두 // 처리)
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
  }

public class GetterSetterToString {
	public static void main(String[] args) {
		Point p = new Point(2, 3);
		System.out.println(p); // 아래 코드와 동일함! 오버라이딩 해놓았기 때문에 toString() 입력하지 않아도 됨
//		System.out.println(p.toString());
		
		Point p2 = new Point(2, 3);
		System.out.println(p == p2);  // 레퍼런스 값은 달라서 결과 false (가리키는 객체의 메모리 위치 다름)
		System.out.println(p.equals(p2)); // 실제 값을 비교하면 동일해서 결과 true
	}
}
