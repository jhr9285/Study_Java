// 5-7. 다음 추상 클래스 Calculator를 상속받은 goodCalc 클래스를 구현하라.

abstract class Calculator {
	public abstract int add(int a, int b);
	public abstract int subtract(int a, int b);
	public abstract double average(int[] a);
}

public class GoodCalc extends Calculator {
	
	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int subtract(int a, int b) {
		return a - b;
	}

	@Override
	public double average(int[] a) {
		double sum = 0;
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum/a.length;
	}
	public static void main(String[] args) {  // 하나의 인스턴스로 3개 코드 모두 실행하는 방식
		GoodCalc c = new GoodCalc();
		System.out.println(c.add(2, 3));
		System.out.println(c.subtract(2, 3));
		System.out.println(c.average(new int[] {2, 3, 4}));

/*		아래와 같이 입력할 수도 있지만, 
 		이 경우는 각 코드별로 새로운 인스턴스를 생성하는 것이라 메모리 많이 차지함	
 
		System.out.println(new GoodCalc().add(2, 3));
		System.out.println(new GoodCalc().subtract(2, 3));
		System.out.println(new GoodCalc().average(new int[] {2, 3, 4}));
*/
	}
}
