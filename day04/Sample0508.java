// 3-13 : 사용자가 명령행에 입력한 여러 개의 실수를 main() 메소드에서 전달받아 합을 구하는 프로그램을 작성하시오.
public class Sample0508 {

	public static void main(String[] args) {
		double sum = 0.0;
		
		for(int i = 0; i < args.length; i++) {
			sum += Double.parseDouble(args[i]);
		}
		System.out.println("합계 : " + sum);
	}
}
// 코드 입력 하고 실행을 먼저 함. => Sample0508 우클릭 => Run As => Run Configurations
// => Arguments 탭 => Program arguments 에 데이터를 한칸씩 띄어서 입력 => apply => Run
