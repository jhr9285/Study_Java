
public class Circle2 {

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
// main 메소드는 프로젝트 당 하나만 존재해야 한다.
// 클래스를 별도의 java 파일로 작성하고 main 메소드가 있는 java 파일에서 호출해서 사용할 수 있다.
// main 메소드가 있는 파일과, 클래스 파일을 별도로 분리하여 작성하게 된다.
// main 메소드 있는 파일에서 클래스를 호출하려면 외부 접근이 가능해야 하므로 클래스는 public으로 만든다.