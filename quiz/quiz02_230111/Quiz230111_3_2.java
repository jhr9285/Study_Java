package quiz02_230111;

import java.util.Scanner;

//  Q3. 학생 이름, 국어, 영어, 수학 점수를 입력하여 enter키를 치면
//		평균을 출력하는 프로그램을 작성하시오. 계속 반복하다가 -1을 입력하면 종료.
// 		(try, catch 이용)
public class Quiz230111_3_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("**************************************");
		System.out.println("           학생 성적 구하기          ");
		System.out.println("**************************************");
		System.out.println("     종료하려면 -1 을 입력하세요.    ");
		System.out.println("======================================");
		
		// try, catch...
		
		scanner.close();
		System.out.println("======================================");
		System.out.println("       프로그램이 종료되었습니다.    ");
		System.out.println("======================================");

	}

}
