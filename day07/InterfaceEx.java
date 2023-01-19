// 5-9 : 인터페이스를 구현하고 동시에 클래스를 상속받는 사례
interface PhoneInterface { 				// 인터페이스 선언
	final int TIMEOUT = 10000; 			// 상수 필드 선언
	public abstract void sendCall();	// 추상메소드
	void receiveCall(); 				// 추상메소드
	default void printLogo() {			// 디폴트메소드 (인터페이스에서 코드 입력 가능한 메소드)
		System.out.println("** Phone **");
	}
}
interface MobilePhoneInterface extends PhoneInterface { // 인터페이스끼리 상속은 extends로
	public void sendSMS();
	abstract void receiveSMS(); 
}
interface MP3Interface { // 인터페이스 선언
	public void play();
	public void stop();
}
class PDA { // 클래스 작성
	public int calculate(int x, int y) {
		return x + y;
	}
}

class SmartPhone extends PDA implements MobilePhoneInterface, MP3Interface {
// SmartPhone 클래스가 PDA 클래스를 extends로 상속받고, 두 개의 인터페이스를 implements 로 상속받음
	@Override
	public void sendCall() {
		System.out.println("전화 거는 중");
	}
	@Override
	public void receiveCall() {
		System.out.println("전화 오는 중");
	}
	@Override
	public void play() {
		System.out.println("음악 재생");
	}
	@Override
	public void stop() {
		System.out.println("음악 중지");
	}
	@Override
	public void sendSMS() {
		System.out.println("문자 전송 중");
	}
	@Override
	public void receiveSMS() {
		System.out.println("문자 도착");
	}

	public void schedule() { 				 // SmartPhone 클래스만의 메소드 추가 입력
		System.out.println("일정 관리");
	}
}

public class InterfaceEx {
	public static void main(String[] args) {
		SmartPhone phone = new SmartPhone(); // SmartPhone 클래스 타입 인스턴스 생성, 레퍼런스 phone 지정
		phone.printLogo();
		phone.sendCall();
		phone.receiveCall();
		phone.play();
		phone.stop();
		System.out.println("계산 - 3과 5를 더하면 " + phone.calculate(3, 5));
		phone.schedule();
	}

}
