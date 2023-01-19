// 예제 3-10 : 2차원 배열에 학년별로 1,2학기 성적으로 저장하고, 4년간 전체 평점 평균을 출력하시오.
public class Sample0506 {

	public static void main(String[] args) {
		double score[][] = {
								{3.3, 3.4},
								{3.5, 3.6},
								{3.7, 4.0},
								{4.1, 4.2}
							};
		double sum = 0;
		for(int year = 0; year < score.length; year++) {
			for(int term = 0; term < score[year].length; term++) {
				sum += score[year][term];
			}
		}
		
		int n = score.length;
		int m = score[0].length;
		System.out.println("4년 전체 평점 평균은 " + sum/(n*m));
	}
}
