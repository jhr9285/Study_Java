/*
	5. 다음과 같은 형식으로 출력하시오.이중for문
	     *
	    ***
	   *****
	  *******  
	 *********
 */
package quiz03_230112;

public class Quiz230112_5 {

	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			
			for(int k = (4 - i) ; k > 0; k--) {
				char space = ' ';
				System.out.print(space);
			}
			
			for(int j = 1; j < (i + 1) * 2; j++) {
				char star = '*';
				System.out.print(star);
			}
			System.out.println();
		}

	}

}
