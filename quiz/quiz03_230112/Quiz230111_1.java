/*
	1. 객관식 문제 출제 프로그램을 작성하시오.   [ 1, 2, 3, 4, 5 ]
	
	1) 자바의 기본 타입 8개에 속하지 않는 것은?
	1. int  2. long  3. float  4. String  5. double
	
	정답 : 4  (4는 입력하는 부분. 4를 입력하고 엔터를 치면 2번 문제가 나와야 한다.)
	
	2) 다음 중 자바에서 실수 타입인 것은?
	1. int  2. long  3. float  4. String  5.char
	
	정답: 1   (정답은 배열에 넣어놓고, 입력값과 비교해서 정답수 오답수를 변수에 누적시켜서 총점을 만들어야 한다.)
	
	-----------------------------------------------
	점수: 50  (한 문제당 50점 식으로 할당해서 총점이 나와야 한다.)
 */

package quiz03_230112;

import java.util.Scanner;

public class Quiz230111_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] question;
		question = new String[2];
		question[0] = "1) 자바의 기본 타입 8개에 속하지 않는 것은? (50점) \n 1. int  2. long  3. float  4. String  5.double";
		question[1] = "2) 다음 중 자바에서 실수 타입인 것은? (50점) \n 1. int  2. long  3. float  4. String  5.char";
		
		int[] answer = {4, 3};
		
		int t = 0;
		int f = 0;
		
		System.out.println("=============================================");
		System.out.println("        Java 문제 풀이를 시작합니다.    ");
		System.out.println("=============================================");
		System.out.println("  입력칸에 선택지 번호를 입력하세요.(ex: 1)");
		System.out.println("=============================================");
		
		int input;
		
		for(int i = 0; i < question.length; i++) {
			System.out.println(question[i]);
			System.out.print("정답 번호 입력 >> ");
			input = scanner.nextInt();
			if(input == answer[i]) {
				t += 1;
			} else if(input > 0 && input < 6 && input != answer[i]){
				f += 1;
			} else {
				System.out.println("=============================================");
				System.out.println(" 입력할 수 없는 번호입니다. 다시 입력하세요.");
				System.out.println("=============================================");
				scanner.next();
				continue;
			}
		}
		
/*		
		System.out.println(question[0]);
		System.out.print("정답 번호 입력 >> ");
		int input = scanner.nextInt();
		if(input == answer[0]) {
			t += 1;
		} else if(input > 0 && input < 6 && input != answer[0]){
			f += 1;
		} else {
			System.out.println("입력할 수 없는 번호입니다. 다시 입력하세요.");
			scanner.next();
			input = scanner.nextInt();
		}
		
		System.out.println(question[1]);		
		System.out.print("정답 번호 입력 >> ");
		input = scanner.nextInt();
		if(input == answer[1]) {
			t += 1;
		} else if(input > 0 && input < 6 && input != answer[0]){
			f += 1;
		} else {
			System.out.println("입력할 수 없는 번호입니다. 다시 입력하세요.");
			scanner.next();
			input = scanner.nextInt();
		}
*/		
		System.out.println("=============================================");
		System.out.println("        Java 문제 풀이를 종료합니다.    ");
		System.out.println("=============================================");
		System.out.println("           총 점수는 " + (t * 50) + "점입니다.   ");
		System.out.println("=============================================");		
	}

}
