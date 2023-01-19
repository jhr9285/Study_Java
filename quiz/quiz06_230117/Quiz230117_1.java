// 1. P253의 예제5-1에서 Point클래스의 showPoint()를 추상메서드로 변경해서
// 	  Point클래스를 추상클래스로 바꾸어서 코딩해보기
package quiz06_230117;

abstract class Point { // 추상클래스로 변경
	public int x, y;   // 서브클래스에서 사용하기 위해 private -> public 으로 변경

	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public abstract void showPoint(); // 추상메소드로 변경
}

class ColorPoint extends Point { 
	private String color;
	public void setColor(String color) {
		this.color = color;
	}
	public void showColorPoint() {
		System.out.print(color);
	}
	@Override
	public void showPoint() {
		System.out.println("(" + x + "," + y + ")");
	}
}
	
public class Quiz230117_1 {
	public static void main(String[] args) {
		Point p = new ColorPoint();
		ColorPoint cp = new ColorPoint();
		
		cp.setColor("blue");
		cp.showColorPoint();
		p.set(30, 40);
		p.showPoint();
	}	
}