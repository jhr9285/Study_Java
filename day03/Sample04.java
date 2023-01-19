import java.util.Scanner;

public class Sample04 {

	public static void main(String[] args) {
		char grade;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("점수를 입력하세요(0~100): ");
		int score = scanner.nextInt();  // 점수 읽기  (nextInt() : 키보드로 입력한 값을 정수화하는 메소드)
		if(score >= 90) {                           // next() : 키보드로 입력한 값을 문자화하는 메소드
			grade = 'A';
		} else if(score >= 80) {
			grade = 'B';
		} else if(score >= 70) {
			grade = 'C';
		} else if(score >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		System.out.println("학점은 " + grade + " 입니다.");
		
		scanner.close();
	}

}
