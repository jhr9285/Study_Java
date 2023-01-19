// 5-3. super()를 이용하여 ColorPoint 클래스의 생성자에서 슈퍼클래스 Point의 생성자를 호출하시오.
class Point {
	private int x, y; // private 변수 2개 선언
	public Point() {
		this.x = this.y = 0;  // 선택한 인스턴스의 레퍼런스를 0으로 초기화 (변수 2개 동시 초기화)
	}
	public Point(int x, int y) { // 선택한 인스턴스의 레퍼런스에 변수 x, y 값 대입하는 생성자함수 생성
		this.x = x;
		this.y = y;
	}
	public void showPoint() { // x, y 값 출력하는 메소드 생성
		System.out.println("(" + x + ", " + y + ")");
	}
}

class ColorPoint extends Point { // 상속
	private String color; // private 변수 1개 선언
	public ColorPoint(int x, int y, String color) { // 부모클래스 생성자함수 호출하는 생성자함수 생성
		super(x, y);  
		this.color = color; // 선택한 인스턴스의 레퍼런스에 매개변수 color 대입하는 메소드 생성
	}
	public void showColorPoint() { // color 값 출력하고 부모클래스 메소드 호출하는 메소드 생성
		System.out.print(color);
		showPoint();
	}
}
