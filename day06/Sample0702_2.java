// 오버로딩된 메소드 호출
public class Sample0702_2 {

	public static void main(String[] args) {
		Sample0702_1 a = new Sample0702_1();
		
		int i = a.getSum(1, 2);
		
		int j = a.getSum(1, 2, 3);
		
		double k = a.getSum(1.1, 2.2);

		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
	}

}
