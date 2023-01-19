// 4-11. 전역 함수로 작성하고자 하는 abs, max, min 3개 함수를 static 메소드로 작성하고 호출하시오.
class Calc {
	public static int abs(int a) { // 절댓값 반환하는, Calc 클래스의 메소드
		return (a > 0) ? a : -a ;  // 3항 연산자로 조건식 작성 (이렇게 많이 쓰는 편)
	}
	public static int max(int a, int b) { // 최댓값 반환하는, Calc 클래스의 메소드
		return (a > b) ? a : b;  
	}
	public static int min(int a, int b) { // 최솟값 반환하는, Calc 클래스의 메소드
		return (a > b) ? b : a;  
	}
}

public class Sample0704 {
	public static void main(String[] args) {
		System.out.println(Calc.abs(-5));     // static 으로 이미 실행메모리에 올라가 있어서 
		System.out.println(Calc.max(10, 8));  // new로 인스턴스 생성하지 않고 바로 호출
		System.out.println(Calc.min(-3, -8));
	}
}
