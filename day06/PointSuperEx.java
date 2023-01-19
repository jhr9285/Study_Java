// 5-3. super()를 이용하여 ColorPoint 클래스의 생성자에서 슈퍼클래스 Point의 생성자를 호출하시오.

public class PointSuperEx {
	public static void main(String[] args) {
		ColorPoint cp = new ColorPoint(5, 6, "blue");
		cp.showColorPoint();
	}
}
