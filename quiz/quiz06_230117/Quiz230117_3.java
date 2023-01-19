// 3. java연습문제05번의 Mouse2클래스를 추상클래스로 바꾸어서 코딩해보세요
package quiz06_230117;

abstract class Mouse2 {  
	String input2;
	String sensor2 = "sensor works";
	abstract void mouseMove2();
}

class WheelMouse2 extends Mouse2 {
	String input2 = "button";
	
	@Override
	void mouseMove2() {
		System.out.println("wheelMouseMove & " + sensor2);
	}

	String leftButton2 = "leftClick2";
	void leftButtonClick2() {
		System.out.println(leftButton2 + " for " + input2);
	}
	void leftButtondoubleClick2() {
		System.out.println(leftButton2 + " and " + leftButton2 + " for " + input2);
	}
	
	String rightButton2 = "rightClick2";
	void rightButtonClick2() {
		System.out.println(rightButton2 + " for " + input2);
	}
	
	String wheel2;
	void wheelScroll2() {
		System.out.println("wheel2 Scroll");
	}
	void wheelClick2() {
		System.out.println("wheel2 Click");
	}
	void wheelClickMove2() {
		System.out.println("wheel2 Click Move");
	}
}

class MagicMouse2 extends Mouse2 {
	String input2 = "touch2";
	
	@Override
	void mouseMove2() {
		System.out.println("magicMouseMove & " + sensor2);	
	}

	String leftTouch2 = "leftClick2";
	void touchLeft2() {
		System.out.println(leftTouch2 + " for " + input2);
	}
	
	String rightTouch2 = "rightClick2";
	void touchRight2() {
		System.out.println(rightTouch2 + " for " + input2);
	}
	
	String doubleTouch2 = "doubleClick2";
	void touchDouble2() {
		System.out.println(doubleTouch2 + " for " + input2);
	}
	
	void topToBottomSlide2() {
		System.out.println("top To Bottom Slide 2");
	}
	void bottomToTopSlide2() {
		System.out.println("bottom To Top Slide 2");
	}
	void leftToRightSlide2() {
		System.out.println("left To Right Slide 2");
	}
	void rightToLeftSlide2() {
		System.out.println("right To Left Slide 2");
	}
}

public class Quiz230117_3 {
	public static void main(String[] args) {
		WheelMouse2 wheelMouse2 = new WheelMouse2();
		MagicMouse2 magicMouse2 = new MagicMouse2();
	}
}