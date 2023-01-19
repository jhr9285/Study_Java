// 1. 이름과 국어,영어,수학 점수를 저장할 수 있는 Student클래스를 만들어서
//    객체를 생성하고 이름과 평균을 출력하기. scanner사용
package quiz05_230116;

import java.util.Scanner;

class Student {
	String name;
	int korean, english, math = 0;
	
	int avg() {
		return (int)((korean + english + math) / 3);
	}
}

public class Quiz230116_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Student student = new Student();

		while(true) {
			
			System.out.println("======================================");
			System.out.println("        점수 입력을 시작합니다.");
			System.out.println("======================================");
			
			System.out.print("이름 입력 : ");
			String input = scanner.next();
			student.name = input;
			System.out.println();
			if(input.equals("-1")) {
				System.out.println("Close.");
				break;
			}
			
			System.out.print("국어 점수 입력 : ");
			int grade = scanner.nextInt();
			student.korean = grade;
			if(grade == -1) {
				System.out.println("Close.");
				break;
			}
			
			System.out.print("영어 점수 입력 : ");
			grade = scanner.nextInt();
			student.english = grade;
			if(grade == -1) {
				System.out.println("Close.");
				break;
			}
			
			System.out.print("수학 점수 입력 : ");
			grade = scanner.nextInt();
			student.math = grade;
			System.out.println();
			if(grade == -1) {
				System.out.println("Close.");
				break;
			}
			System.out.println("======================================");
			System.out.print(" " + student.name + " 학생의 평균 점수는 " + student.avg() + "점입니다. \n");
			System.out.println("======================================");
		}
	
		scanner.close();
	}
}
