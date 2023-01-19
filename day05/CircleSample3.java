class Circle1 {  // 하나의 java 파일에 클래스를 두 개 이상 만들고 싶으면 다른 클래스는 접근지정자를 지우면 된다.
	int radius;  // 접근지정자 지운 상태를 디폴트 클래스? 라고 한다.
	String name; 
	
	public Circle1() {  
	}
	
	public double getArea() {
		return 3.14 * radius * radius;
	}
}

public class CircleSample3 {  // 파일명과 클래스명이 동일하기 때문에 이 클래스를 기준으로
							  //  접근지정자가 붙은 다른 클래스가 있으면 에러가 발생한다.
	public static void main(String[] args) {
		Circle1 pizza;  
		pizza = new Circle1(); 
		pizza.radius = 10; 
		pizza.name = "자바피자";  
		double area = pizza.getArea(); 
									   
		System.out.println(pizza.name + "의 면적은 " + area + " 이다.");
		
		Circle1 donut = new Circle1(); 
		donut.radius = 2; 
		donut.name = "자바도넛"; 
		area = donut.getArea(); 
		System.out.println(donut.name + "의 면적은 " + area + " 이다.");


	}

}
