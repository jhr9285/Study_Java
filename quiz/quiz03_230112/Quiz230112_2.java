// 2. 구구단을 종적으로 2단부터 9단까지 출력하기.
package quiz03_230112;

public class Quiz230112_2 {

	public static void main(String[] args) {

		for(int k = 1; k < 10; k++) {
			for(int l = 2; l < 10; l++) {
				System.out.print(l + "x" + k + "=" + (l * k));
				System.out.print('\t');
			}
			System.out.println(); 
		} 
	}
}
