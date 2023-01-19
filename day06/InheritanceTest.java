// 자바의 상속 선언 예시
// (+) 5-2. 클래스 Person을 아래와 같은 멤버 필드를 갖도록 선언하고 클래스 Student는 클래스 Person을 상속받아
// 			각 멤버 필드에 값을 저장하시오. 이 예제에서 Person 클래스의 private 필드인 weight는 Student 클래스
// 			에서는 접근이 불가능하여 슈퍼클래스인 Person의 getXXX, setXXX 메소드를 통해서만 조작이 가능합니다.
//  		(멤버 필드 - private int weight; / int age; / protected int height; / public String name;)
class Person {
	void speak() {
		System.out.println("speak");
	}
	void eat() {
		System.out.println("eat");
	}
	void walk() {
		System.out.println("walk");
	}
	void sleep() {
		System.out.println("sleep");
	}
	
	private int weight; 	// 같은 클래스 내에서만 접근 가능
	int age; 				// 같은 패키지 내에서는 접근 가능
	protected int height;   // 같은 패키지 내에서 + 다른 패키지 서브클래스는 접근 가능
	public String name;		// 다른 클래스 모두 접근 가능
	
	public void setWeight(int weight) {  // setter : 변수에 값을 저장하는 함수
		this.weight = weight;
	}
	public int getWeight() { // getter : 변수의 값을 읽어오는 함수
		return weight;
	}
	public void weightPrint() {
		System.out.println(weight);
	}
}

class Student extends Person {// Student 클래스가 Person 클래스를 상속받음, 필드 및 메소드 총 6개
	void study() {
		System.out.println("study");
	}
	public void set() {
		age = 30; 			// 슈퍼클래스의 디폴트 멤버 age ==> 서브클래스에서 접근 가능
		name = "김철수"; 	// 슈퍼크래스의 public 멤버 ==> 서브클래스에서 접근 가능
		height = 175;		// 슈퍼클래스의 protected 멤버 ==> 서브클래스에서 접근 가능
//		weight = 80; 		// 슈퍼클래스의 private 멤버 ==> 서브클래스 접근 불가!! 오류 발생!!
		setWeight(99);		// 슈퍼클래스의 private 멤버 weight 는
		weightPrint();		// public 멤버인 setWeight(), weightPrint() 으로 서브클래스에서 간접 접근 가능
	}
} 

class StudentWorker extends Student {// StudentWorker 클래스가 Student 클래스를 상속받음, 필드 및 메소드 총 7개
	void work() {
		System.out.println("work");
	}
}

public class InheritanceTest{
	public static void main(String[] args) {
		Student hkd = new Student();
		hkd.name = "홍길동";
		System.out.print(hkd.name + " ");
		hkd.speak();
		
		StudentWorker lss = new StudentWorker();
		lss.name = "이순신";
		System.out.print(lss.name + " ");
		lss.work();
		
		System.out.println();
		
		Student s = new Student();
		s.set();
		System.out.println(s.name);
		System.out.println(s.age);
		System.out.println(s.height);
		s.weightPrint();  // 출력되는지 확인하려고 임의로 추가한 메소드
	}
}
