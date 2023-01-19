// 4-6 : 반지름이 0~4인 Circle 객체 5개를 가지는 배열을 생성하고, 배열에 있는 모든 Circle 객체의 면적을 출력하라.
class Circle {
	int radius;
	
	public Circle(int radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return 3.14 * radius * radius;
	}
}

public class CircleArray {
	public static void main(String[] args) {
		
		Circle[] c; // Circle 타입 배열에 연결되는 레퍼런스 변수 선언
		c = new Circle[5]; // 5칸짜리 Circle 타입 배열 생성 (인스턴스 생성 아님)
		
		for(int i = 0; i < c.length; i++) {
			c[i] = new Circle(i); // Circle 생성자 호출하여 c[i]번째 자리에 Circle 타입 배열의 레퍼런스값 넣음
		}                         // 인스턴스 생성 맞음
		
		for(int i = 0; i < c.length; i++) {
			System.out.print((int)(c[i].getArea()) + " "); // c[i].getArea()의 값은 double인데 int로 강제형변환
		}
	}
}
