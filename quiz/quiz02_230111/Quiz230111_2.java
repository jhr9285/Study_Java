package quiz02_230111;

// Q2. 입력한 값이 홀수인지 짝수인지 판별하는 프로그램 작성하기. switch문 사용. scanner사용

import java.util.Scanner;

public class Quiz230111_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		
		int num = scanner.nextInt();
		
		switch(num % 2) {
		case 0:
			System.out.println(">> 입력한 값은 짝수입니다.");
			break;
		default:
			System.out.println(">> 입력한 값은 홀수입니다.");
		}
		scanner.close();
	}
}
