package quiz02_230111;

// Q1. 입력한 값이 홀수인지 짝수인지 판별하는 프로그램 작성하기. if문 사용. scanner사용

import java.util.Scanner;

public class Quiz230111_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		
		int num = scanner.nextInt();
		
		if(num % 2 == 0) {
			System.out.println(">> 입력한 값은 짝수입니다.");
		} else {
			System.out.println(">> 입력한 값은 홀수입니다.");
		}	
		scanner.close();
	}
}
