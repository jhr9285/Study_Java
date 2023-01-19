package quiz02_230111;

import java.util.Scanner;

public class Quiz230111_3_answer {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("**************************************");
		System.out.println("           학생 성적 구하기          ");
		System.out.println("**************************************");
		System.out.println("     종료하려면 -1 을 입력하세요.    ");
		System.out.println("======================================");
		
		while(true) {
			System.out.print("이름 : ");
			String name = scanner.next();
			if(name.equals("-1")) {
					break;
			}
			System.out.print("국어 점수 : ");
			String korean = scanner.next();
			if(korean.equals("-1")) {
				break;
			}
			System.out.print("영어 점수 : ");
			String english = scanner.next();
			if(english.equals("-1")) {
				break;
			}
			System.out.print("수학 점수 : ");
			String math = scanner.next();
			if(math.equals("-1")) {
				break;
			}
			System.out.println("--------------------------------------");	
			
			int a = Integer.parseInt(korean);
			int b = Integer.parseInt(english);
			int c = Integer.parseInt(math);
			
			System.out.println(" " + name + " 학생의 평균점수는 " + (( a + b + c ) / 3) + "점입니다.");
			System.out.println("--------------------------------------");
		}
		scanner.close();
		System.out.println("======================================");
		System.out.println("       프로그램이 종료되었습니다.    ");
		System.out.println("======================================");
	}
}
