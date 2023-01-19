// 4-10. 다음 코드의 두 클래스 Sample0703_1, Sample0703 클래스는 동일한 패키지에 저장됩니다.
// 		 컴파일 오류를 찾아내고 이유를 설명하시오.
class Sample0703_1 {
		public int a;
		private int b;
		int c;
}
	
public class Sample0703 {
	public static void main(String[] args) {
		Sample0703_1 aClass = new Sample0703_1();
		aClass.a = 10;
//		aClass.b = 10;  // . 입력했을 때 리스트에 b가 아예 나타나지 않음 (접근 불가한 private 상태이므로)
		aClass.c = 10;
	}

}
