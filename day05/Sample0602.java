// 4-3. 다음 코드는 2개의 생성자를 가진 Circle 클래스다. 실행 결과는 무엇인가?
public class Sample0602 {
	int radius;
	String name;
	
	public Sample0602() {  // 매개변수 없는 생성자 생성
		radius = 1;
		name = "";
	}
	
	public Sample0602(int r, String n) {  // 매개변수 있는 생성자 생성
		this.radius = r; // this : Sample0602 클래스로 만들어진 인스턴스의 레퍼런스값 (=3,4행의 변수)
		this.name = n;   // r, n = 메소드의 매개변수
	}
	
	public double getArea() {  // 메소드 생성
		return 3.14 * radius * radius;
	}
	
	public static void main(String[] args) {
		Sample0602 pizza = new Sample0602(10, "자바피자"); // 매개변수 있는 생성자로 인스턴스 생성 및 초기화
		double area = pizza.getArea();
		System.out.println(pizza.name + "의 면적은 " + area);
		
		Sample0602 donut = new Sample0602(); // 매개변수 없는 생성자로 인스턴스 생성
		donut.name = "도넛피자"; // name 필드 값 대입
		area = donut.getArea();
		System.out.println(donut.name + "의 면적은 " + area);

	}

}
