package quiz02_230111;

/* Q3. 학생 이름, 국어, 영어, 수학 점수를 입력하여 enter키를 치면
   평균을 출력하는 프로그램을 작성하시오. 계속 반복하다가 -1을 입력하면 종료. */
// hint : 모두 문자열로 입력 받고 점수들을 숫자로 형변환
import java.util.Scanner;

public class Quiz230111_3_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("학생 이름, 국어 점수, 영어 점수, 수학 점수를 입력하세요. -1을 입력하면 종료됩니다.");
		
		int sum = 0;
		int count = 0;
		String name = scanner.next();
		int score = scanner.nextInt();
		
			while(score != -1) {
				sum += score;
				count++;
				
				if(count == 3) {
					System.out.println(name + " 학생의 평균점수는 " + (double)sum/count + "입니다.");
					name = scanner.next();
					if(name.equals("-1") || score == -1) {
						break;
					}
					sum = 0;
					count = 0;
				} 
				score = scanner.nextInt();
			}
		System.out.println("프로그램이 종료되었습니다.");
		scanner.close();
	}
}
