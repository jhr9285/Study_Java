import java.util.Scanner;

// 예제 3-7 : 양수 5개를 입력 받아 배열에 저장하고, 제일 큰 수를 출력하는 프로그램을 작성하시오.
public class Sample0505 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] intArray = new int[5];
		
		int max = 0;
		System.out.println("양수 5개를 입력하세요.");
		for(int i = 0; i < intArray.length; i++) {  // 배열의 크기 : 배열이름.length
			intArray[i] = scanner.nextInt();
			if(intArray[i] > max) {
				max = intArray[i];
			}
		}
		System.out.println("가장 큰 수는 " + max + " 입니다.");
		scanner.close();
	}

}
