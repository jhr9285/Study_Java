// 2. Point클래스를 인터페이스로 바꾸어서 코딩해보기
package quiz06_230117;

interface PointInterface { // 인터페이스로 변경
	abstract void showPoint2(); // 추상메소드 입력
}

class ColorPointImple implements PointInterface {
	public int x, y;
	public String color;
	
	public ColorPointImple() {}

	public ColorPointImple(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public ColorPointImple(String color) {
		this.color = color;
	}
	             
	@Override
	public void showPoint2() {
		System.out.println("(" + x + "," + y + ")");
	}
	
	public void showColorPoint2() {
		System.out.print(color);
	}
}

public class Quiz230117_2 {
	public static void main(String[] args) {
		ColorPointImple cpi = new ColorPointImple(90, 100);
		ColorPointImple cpic = new ColorPointImple("purple");
		
		cpic.showColorPoint2();
		cpi.showPoint2();
	}
}
