import java.util.InputMismatchException;
import java.util.Scanner;

// 3-17. 3개의 정수를 입력받아 합을 구하는 프로그램을 작성하시오.
// 	 	 사용자가 정수가 아닌 문자를 입력할 때 발생하는 InputMismatchException
//		 예외를 처리하여 다시 입력받도록 하시오.
public class Sample0601 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("정수 3개를 입력하세요");
		
		int sum = 0, n = 0;
		for(int i = 0; i < 3; i++) {
			System.out.print(i + ">>");
			try {
				n = scanner.nextInt();  // nextInt, next : 버퍼에 있는 데이터를 '읽는' 함수
			} catch(InputMismatchException e) {
				// 예외를 구체적으로 입력하는 경우 : 각 예외별로 다른 처리를 할 때 사용
				System.out.println("정수가 아닙니다. 다시 입력하세요.");
				scanner.next();  // scanner.next(); 를 입력하지 않으면 버퍼에 정수가 아닌 데이터가 남아있어서 
				i--; 			 // 계속 에러가 발생하기 때문에 위의 메시지가 끊임없이 출력된다.
				continue; 		 // .next() : 버퍼에 있는 '정수가 아닌 데이터'를 '읽어서' 처리하는 함수
			}                    // scanner.next(); 는 변수 같은 게 없기 때문에 '읽기만' 하고 다른 처리가 없다.
			sum += n; 			 // 대신 '읽었기' 때문에 버퍼에 있던 '정수가 아닌 데이터'는 사라진다.
		}
		System.out.println("정수 3개의 합은 " + sum);
		scanner.close();
	}

}
