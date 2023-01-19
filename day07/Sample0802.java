// 오버라이딩과 super 키워드
class Shape1 {
	protected String name;
	public void paint() {
		draw();
	}
	public void draw() {
		System.out.println("Shape의 draw");
		System.out.println(name);
	}
}

class Circle1 extends Shape1 {
//	protected String name; (안 써도 됨. 상속했으니까.)
	@Override   // source - override 클릭해서 구현
	public void draw() {
		name = "Circle";
		super.name = "Shape";
		super.draw(); // 부모클래스의 draw()를 호출하는 코드가 기본값
		System.out.println("Circle의 draw");
		System.out.println(name);
	}
}

public class Sample0802 extends Circle1 {
	public static void main(String[] args) {
		Shape1 b = new Circle1();  // 업캐스팅, 부모클래스 레퍼런스변수 b가 자식클래스 객체를 참조함
		b.paint();  // 자식클래스 객체의 부모클래스 레퍼런스변수 b를 통해 paint() 메소드 호출
	}				// ==> 부모클래스 레퍼런스변수는 부모클래스 영역만 적용 가능
}					// 그런데 New Circle1() 이 실행되면 Circle1 클래스에 기본생성자가 생성되고(없기 때문)
					// 자식클래스 생성자가 호출되면 자동으로 부모클래스 생성자도 호출된다.
					// Shape1 도 기본생성자가 없기 때문에 자동으로 생성되고,
					// 호출된 이후에는 부모클래스 객체 -> 자식클래스 객체 순으로 객체가 생성된다.
	 				// 즉, 부모클래스 생성자 호출 -> 자식클래스 생성자 호출 순으로 코드가 적용되고
					// paint()는 draw()를 실행하게 되어있으므로 Shape1의 draw() -> Circle1의 draw()가 실행...
