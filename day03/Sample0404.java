import java.util.Scanner;

public class Sample0404 {
	public static void main(String[] args) {
		// nextInt() 같은 메소드는 엔터키를 기준으로 구분해서 데이터를 읽기도 하지만
		// 공백(스페이스바)으로 구분해서 읽기도 한다.
		int count = 0;  // 입력한 정수의 개수를 세기 위한 변수
		int sum = 0;
		Scanner scanner = new Scanner(System.in); // 정수 입력
		System.out.println("정수를 입력하고 마지막에 -1을 입력하세요.");
		
		int n = scanner.nextInt();
		while(n != -1) {
			sum += n;
			count++;  // 한번 입력할 때마다 1씩 증가
			n = scanner.nextInt();  // 정수 입력
		}
		if(count == 0) {
			System.out.println("입력된 수가 없습니다.");
		} else {
			System.out.print("정수의 개수는 " + count + "개이며 ");
			System.out.println("평균은 " + (double)sum/count + "입니다.");  // (double) : 강제 타입 변환
		}
		scanner.close();
	}
}
