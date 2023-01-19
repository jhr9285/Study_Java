// 5-5. 업캐스팅 + 메소드 오버라이딩
class Shape {
	public Shape next;  // Shape 클래스의 변수 ==> 부모클래스 변수, 자식클래스는 상속받아서 보유하게 
	public Shape() {
		next = null;
	}
	public void draw() {
		System.out.println("Shape");
	}
}

class Line extends Shape {
	public void draw() {
		System.out.println("Line");
	}
}

class Rect extends Shape {
	public void draw() {
		System.out.println("Rect");
	}
}

class Circle extends Shape {
	public void draw() {
		System.out.println("Circle");
	}
}

public class Sample0801 {
	public static void main(String[] args) {
		Shape start, last, obj; // 링크드 리스트로 도형 생성하여 연결
		start = new Line();		// 업캐스팅으로 Shape 레퍼런스변수 start에 Line 객체 연결
		last = start;			// last에 start 레퍼런스 대입
		obj = new Rect();		// 업캐스팅으로 Shaple 레퍼런스변수 obj에 Rect 객체 연결
		last.next = obj;		// last 레퍼런스변수 내 next 변수에 obj 대입
		last = obj;				// last에 obj 레퍼런스 대입
		obj = new Line();		
		last.next = obj;
		last = obj;
		obj = new Circle();
		last.next = obj;
		
		Shape p = start;		// 새로운 레퍼런스변수 p 생성, start 레퍼런스 대입
		while(p != null) {		// p가 null이 될 때까지 반복
			p.draw();
			p = p.next;
		}
	}

}
