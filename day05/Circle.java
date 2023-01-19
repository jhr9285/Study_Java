// 4-1. 반지름과 이름을 가진 Circle 클래스를 작성하고, Circle 클래스의 객체를 생성하시오.
public class Circle {
	int radius;  // Circle 클래스에 radius 필드 생성
	String name; // Circle 클래스에 name 필드 생성
	
	public Circle() {  // Circle 클래스에 Circle 생성자 생성 (블럭이 비어있으면 기본생성자라고 한다)
	}
	
	public double getArea() { // Circle 클래스에 getArea() 메소드 생성 (원의 면적 계산하는 메소드)
		return 3.14 * radius * radius;
	}
	
	public static void main(String[] args) {
		Circle pizza;  // pizza라는 레퍼런스 변수를 Circle 타입의 객체에 붙임
		pizza = new Circle(); // Circle 객체(인스턴스) pizza 생성
		pizza.radius = 10; // pizza의 radius 필드에 값 대입
		pizza.name = "자바피자";  // pizza의 name 필드에 값 대입
		double area = pizza.getArea(); // pizza의 getArea() 메소드를 호출하여 계산 실행하고
									   // area라는 main의 지역변수를 레퍼런스변수로 사용
		System.out.println(pizza.name + "의 면적은 " + area + " 이다.");
		
		Circle donut = new Circle(); // 또 다른 Circle 객체(인스턴스) 생성하고, (pizza와 donut은 메모리 위치 다름)
		 							 // donut이라는 레퍼런스 변수를 Circle 타입의 객체에 붙임
		donut.radius = 2; // donut의 radius 필드에 값 대입
		donut.name = "자바도넛"; // donut의 name 필드에 값 대입
		area = donut.getArea(); // donut의 getArea() 메소드를 호출하여 계산 실행하고
								// area라는 main의 지역변수를 레퍼런스변수로 사용
								// (pizza 에서 사용한 값 사라지고 새 값으로 바뀜)
		System.out.println(donut.name + "의 면적은 " + area + " 이다.");
	}

}
// 이 Circle 클래스는 main 메소드까지 블럭 안에 포함된 클래스다.
