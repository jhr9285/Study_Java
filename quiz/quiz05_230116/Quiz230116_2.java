/*  2.휠마우스, 매직마우스를 상속을 통해서 만든다고 가정합니다.

	1) 마우스 클래스를 생성하시오.
	버튼, mouseMove()
	
	2) 휠마우스 클래스를 마우스클래스를 상속받아서 생성하시오.
	버튼2, 스크롤휠 추가
	
	3) 매직마우스 클래스를 마우스 클래스를 상속받아서 생성하시오.
	터치기능 추가
	
	4) 1~3번의 인스턴스를 생성하시오.
*/
package quiz05_230116;

class Mouse {  
	String input;
	String sensor = "sensor works";
	void mouseMove() {
		System.out.println("mouseMove & " + sensor);
	}
}

class WheelMouse extends Mouse {
	String input = "button";
	void mouseMove() {
		System.out.println("mouseMove & " + sensor);
	}
	
	String leftButton = "leftClick";
	void leftButtonClick() {
		System.out.println(leftButton + " for " + input);
	}
	void leftButtondoubleClick() {
		System.out.println(leftButton + " and " + leftButton + " for " + input);
	}
	
	String rightButton = "rightClick";
	void rightButtonClick() {
		System.out.println(rightButton + " for " + input);
	}
	
	String wheel;
	void wheelScroll() {
		System.out.println("wheel Scroll");
	}
	void wheelClick() {
		System.out.println("wheel Click");
	}
	void wheelClickMove() {
		System.out.println("wheel Click Move");
	}
}

class MagicMouse extends Mouse {
	String input = "touch";
	void mouseMove() {
		System.out.println("mouseMove & " + sensor);
	}
	
	String leftTouch = "leftClick";
	void touchLeft() {
		System.out.println(leftTouch + " for " + input);
	}
	
	String rightTouch = "rightClick";
	void touchRight() {
		System.out.println(rightTouch + " for " + input);
	}
	
	String doubleTouch = "doubleClick";
	void touchDouble() {
		System.out.println(doubleTouch + " for " + input);
	}
	
	void topToBottomSlide() {
		System.out.println("top To Bottom Slide");
	}
	void bottomToTopSlide() {
		System.out.println("bottom To Top Slide");
	}
	void leftToRightSlide() {
		System.out.println("left To Right Slide");
	}
	void rightToLeftSlide() {
		System.out.println("right To Left Slide");
	}
}

public class Quiz230116_2 {
	public static void main(String[] args) {
		Mouse mouse = new Mouse();
		WheelMouse wheelMouse = new WheelMouse();
		MagicMouse magicMouse = new MagicMouse();
		
		System.out.println("======== Mouse ========");
		mouse.mouseMove();
		System.out.println("====== WheelMouse ======");
		wheelMouse.mouseMove();
		wheelMouse.leftButtonClick();
		wheelMouse.leftButtondoubleClick();
		wheelMouse.rightButtonClick();
		wheelMouse.wheelScroll();
		wheelMouse.wheelClick();
		wheelMouse.wheelClickMove();
		System.out.println("====== magicMouse ======");
		magicMouse.mouseMove();
		magicMouse.touchLeft();
		magicMouse.touchRight();
		magicMouse.touchDouble();
		magicMouse.topToBottomSlide();
		magicMouse.bottomToTopSlide();
		magicMouse.leftToRightSlide();
		magicMouse.rightToLeftSlide();
	}
}
