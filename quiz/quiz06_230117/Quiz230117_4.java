// 4. java연습문제05번의 Mouse3클래스를 인터페이스로 바꾸어서 코딩해보세요
package quiz06_230117;

interface Mouse3 {  
	String SENSOR3 = "SENSOR3 works";
	abstract void mouseMove3();
}

class wheelMouse3 implements Mouse3 {
	String input3 = "button";
	
	@Override
	public void mouseMove3() {
		System.out.println("wheelMouseMove & " + SENSOR3);
	}

	String leftButton3 = "leftClick3";
	void leftButtonClick3() {
		System.out.println(leftButton3 + " for " + input3);
	}
	void leftButtondoubleClick3() {
		System.out.println(leftButton3 + " and " + leftButton3 + " for " + input3);
	}
	
	String rightButton3 = "rightClick3";
	void rightButtonClick3() {
		System.out.println(rightButton3 + " for " + input3);
	}
	
	String wheel3;
	void wheelScroll3() {
		System.out.println("wheel3 Scroll");
	}
	void wheelClick3() {
		System.out.println("wheel3 Click");
	}
	void wheelClickMove3() {
		System.out.println("wheel3 Click Move");
	}
}

class MagicMouse3 implements Mouse3 {
	String input3 = "touch";

	@Override
	public void mouseMove3() {
		System.out.println("magicMouseMove & " + SENSOR3);
	}

	String leftTouch3 = "leftClick3";
	void touchLeft3() {
		System.out.println(leftTouch3 + " for " + input3);
	}
	
	String rightTouch3 = "rightClick";
	void touchRight3() {
		System.out.println(rightTouch3 + " for " + input3);
	}
	
	String doubleTouch3 = "doubleClick3";
	void touchDouble3() {
		System.out.println(doubleTouch3 + " for " + input3);
	}
	
	void topToBottomSlide3() {
		System.out.println("top To Bottom Slide 3");
	}
	void bottomToTopSlide3() {
		System.out.println("bottom To Top Slide 3");
	}
	void leftToRightSlide3() {
		System.out.println("left To Right Slide 3");
	}
	void rightToLeftSlide3() {
		System.out.println("right To Left Slide 3");
	}
}
public class Quiz230117_4 {
	public static void main(String[] args) {
		wheelMouse3 wheelMouse3 = new wheelMouse3();
		MagicMouse3 magicMouse3 = new MagicMouse3();
	}
}