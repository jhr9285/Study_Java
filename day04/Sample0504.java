import java.util.Scanner;

// 예제 3-6 : "exit"가 입력되면 while문을 벗어나도록 break문을 활용하는 프로그램을 작성하시오.
public class Sample0504 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("exit를 입력하면 종료합니다.");
		while(true) {
			System.out.print(">>");
			String text = scanner.nextLine(); // .nextLine() : 빈칸을 포함한 문자열 한 줄 전체를 입력받는다.
			System.out.println(text);
			if(text.equals("exit")) {   // 문자열을 비교할 때는 .equals() 메소드를 사용한다.
				break; 			      	// == 연산자 사용 X. .equals()는 String 클래스에 소속된 메소드다.
			}
		}
		System.out.println("종료합니다...");
		
		scanner.close();
		
		
		// do-while문
		
		/*
		 
		String text;
		do {
			System.out.println("exit를 입력하면 종료합니다.");
			System.out.print(">>");
			text = scanner.nextLine();
		} while(!text.equals("exit")); // text 입력값이 exit가 아니면 do 를 반복한다
		if(text.equals("exit")) {
			System.out.println("종료합니다...");
		}
		scanner.close();
		
		*/
	}

}

