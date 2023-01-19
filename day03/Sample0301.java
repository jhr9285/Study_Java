import java.util.Scanner;

public class Sample0301 {

	public static void main(String[] args) {
		// Scanner : 클래스, in : 인스턴스 이름
		Scanner in = new Scanner(System.in);   // scanner 만들면(=new Scanner(System.in) 부분이 입력되면) 자동으로 스캐너 오픈됨.
											   // 생성자 함수 Scanner 의 매개변수로 System.in(표준입력-키보드입력) 을 넣은 것임.
		System.out.print("정수를 입력하세요 : ");
		int number = in.nextInt(); // nextInt 메소드 : Scanner 클래스 안에 코딩 되어있는 메소드
		if(number % 3 == 0) {
			System.out.print("3의 배수입니다.");
		} else {
			System.out.print("3의 배수가 아닙니다.");
		}
		
		in.close();  // 오픈된 스캐너를 닫는다. close 메소드 : Scanner 클래스 안에 코딩 되어있는 메소드
	}
}
