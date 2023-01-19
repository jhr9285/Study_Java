import java.util.Scanner;

// 4-12. static 멤버를 이용하여 달러와 원화를 변환해주는 환율 계산기를 만드시오.
class CurrencyConverter {
	private static double rate;
	public static double toDollar(double won) {
		return won/rate;
	}
	public static double toKWR(double dollar) {
		return dollar * rate;
	}
	public static void setRate(double r) {
		rate = r;
	}
}

public class Sample0705 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("환율(1달러)>> ");
		double rate = scanner.nextDouble();
		CurrencyConverter.setRate(rate);
		System.out.println("백만원 = $" + CurrencyConverter.toDollar(1000000) + "입니다.");
		System.out.println("$100 = " + CurrencyConverter.toKWR(100) + "원입니다.");
		scanner.close();
	}

}
