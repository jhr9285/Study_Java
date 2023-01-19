/*
	4. 다음과 같은 형식으로 출력하시오.이중for문
	*****
	****
	***
	**
	*
 */
package quiz03_230112;

public class Quiz230112_4 {

	public static void main(String[] args) {
		for(int i = 1; i < 6; i++) {
			for(int j = 6; j > i; j--) {
				char star = '*';
				System.out.print(star);
			}
			System.out.println();
		}

	}

}
