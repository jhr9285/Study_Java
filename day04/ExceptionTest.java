import java.util.Scanner;

// 3-14 : 두 정수를 입력 받아 나눗셈을 하고 몫을 구하는 프로그램 코드다.
// 		  사용자가 나누는 수에 0을 입력하면 ArithmeticException 예외가 발생하여 프로그램이 강제 종료된다.	
public class ExceptionTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("분자 : ");
		int a = s.nextInt();
		System.out.print("분모 : ");
		int b = s.nextInt();
/*
		System.out.println(a / b);
		System.out.println("출력되었다면 프로그램 정상 작동! 전원 ON!"); 
		// >> 에러 없을 때는 정상적으로 출력되는데 에러 발생하면 프로그램이 죽어서 a / b 다음 코드도 출력 안 됨
		
*/
		try {
			System.out.println(a / b);			
		} catch(Exception e) { 
			// catch() 안에 파라미터로 원래 에러코드를 입력해야 되지만,
			// 다 외워서 칠 수 없으므로 Exception e만 입력하면 다 처리된다.
			// e 가 파라미터변수임. 아무 문자나 써도 됨.
			System.out.println("예상치 못한 에러가 발생했습니다. 예외에 대한 추가 처리를 여기에 입력합니다.");
			e.printStackTrace(); // 에러 이름 알려주는 Exception (클래스?) 소속 메소드
		}
		System.out.println("출력되었다면 프로그램 정상 작동! 전원 ON!"); 
	}   // 예외처리를 하면 예외가 발생해도 println 코드가 출력이 된다. 프로그램이 죽지 않았다!

}
