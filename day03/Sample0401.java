import java.util.Scanner;

public class Sample0401 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		char grade;  // 2바이트(1글자)
		System.out.print("점수를 입력하세요(0 ~ 100): ");
		int score = scanner.nextInt();
		switch(score / 10) {  // 범위 비교가 어려운 문제점을 보완한 코딩 방법 (나눠서 얻은 몫의 십의 자리 수를 지표로 비교)
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8: 
			grade = 'B';
			break; 
		case 7: 
			grade = 'C';
			break; 
		case 6: 
			grade = 'D';
			break; 
		default: 
			grade = 'F'; 
		}
		System.out.println("학점은 "+ grade + " 입니다.");
		scanner.close();
	}

}
