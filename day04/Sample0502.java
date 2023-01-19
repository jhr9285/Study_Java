// 예제 3-4 : 이중 중첩 for문을 사용하여 구구단을 출력하는 프로그램을 작성하시오.
//			  한 줄에 한 단씩 출력하시오.
public class Sample0502 {

	public static void main(String[] args) {
		
		// 구구단의 한 단을 가로로 표기
		
		for(int i = 2; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
				System.out.print(i + "x" + j + "=" + (i * j));
				System.out.print('\t');
			}
			System.out.println();
		}
		
		System.out.println();
		
		// 구구단의 한 단을 세로로 표기
		
		for(int k = 1; k < 10; k++) {
			for(int l = 2; l < 10; l++) {
				System.out.print(l + "x" + k + "=" + (l * k));
				System.out.print('\t');
			}
			System.out.println(); 
		} 
	}

}
