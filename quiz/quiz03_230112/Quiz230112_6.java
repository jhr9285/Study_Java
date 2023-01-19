// 6. 1부터 100까지 홀수만 출력하기. continue사용

package quiz03_230112;

public class Quiz230112_6 {

	public static void main(String[] args) {
		int[] num;
		num = new int[100];
		
		for(int i = 1; i < 101; i++) {
			num[i - 1] = i;
			
			if(num[i - 1] % 2 == 0) {
				System.out.print(" ");
				continue;
			}
			System.out.print(num[i - 1]);
		}
	}
}
