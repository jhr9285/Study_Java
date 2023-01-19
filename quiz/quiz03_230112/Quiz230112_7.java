// 7. 1부터 100까지 3의 배수만 출력하기. continue사용

package quiz03_230112;

public class Quiz230112_7 {

	public static void main(String[] args) {
		int[] num;
		num = new int[100];
		
		for(int i = 0; i < 100; i++) {
			num[i] = i + 1;
			
			if(num[i] % 3 == 0) {
				System.out.print(num[i] + " ");
			} else {
				continue;
			}
		}
	}
}
