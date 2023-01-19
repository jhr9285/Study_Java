// 수업자료 기준 4과, 5과, 7과의 에센스 모음
import java.util.ArrayList;
import java.util.HashMap;

class Phone {
	String number;
	private String brand;
	
	Phone() {}
	Phone(String number) { // 파라미터 있는 생성자의 역할 : 변수 초기화
		this.number = number;
	}
	Phone(String number, String brand) {
		//this.number = number; 를 기본적으로 쓰겠지만, 위에 이미 같은 코드가 있으니 위의 생성자 함수를 호출한다.
		this(number);
		this.brand = brand;
	}
	void sendCall() {
		System.out.println("전화 걸기~send call");
	}
	void receiveCall() {
		System.out.println("전화 받기~receive call");
	}
	// private 변수 brand의 getter, setter  ==> getter : 필드값 읽는 메소드, setter : 필드값 수정하는 메소드
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
}

interface MobileInterface { // 인터페이스는 상수, 추상메소드만 기본적으로 입력 가능하다.
	void sendSMS();		// 추상메소드
	void receiveSMS();	// 추상메소드
}

class SmartPhone extends Phone implements MobileInterface {
	int camera;
	
	public SmartPhone() {}
	public SmartPhone(int camera) {
//		this.number = "000-0000-0000";
//		this.setBrand("미정");           << 이 두 코드를 아래의 super로 압축할 수 있다.
		super("000-0000-0000", "미정");
		this.camera = camera;
	}
	public SmartPhone(String number, String brand, int camera) {
		super(number, brand);
		this.camera = camera;
	}
	void calc(int a, int b) {
		System.out.println("덧셈 계산: " + a + " + " + b + " = " + (a + b));
	}
	// 인터페이스를 상속받은 클래스는 인터페이스의 추상메소드를 반드시 오버라이딩 해야 한다.
	@Override
	public void sendSMS() {
		System.out.println("문자 보내기~send SMS");
	}
	@Override
	public void receiveSMS() {
		System.out.println("문자 받기~receive SMS");
	}
}

public class JavaEssence {

	public static void main(String[] args) {
		Phone p = new Phone("010-1234-5678");
		p.sendCall();
		p.receiveCall();
		System.out.println("전화번호: " + p.number);
		
		System.out.println("===== Phone(1,2) =====");
		
		Phone p2 = new Phone("010-9876-5432", "LG");
		p2.sendCall();
		p2.receiveCall();
		System.out.println("전화번호: " + p2.number);
		System.out.println("브랜드: " + p2.getBrand());
		p2.setBrand("애플");
		System.out.println("브랜드: " + p2.getBrand());
		
		System.out.println("===== SmartPhone() =====");
		
		SmartPhone sp = new SmartPhone();
		sp.sendCall();
		sp.receiveCall();
		sp.sendSMS();
		sp.receiveSMS();
		sp.calc(20, 30);
		
		System.out.println("===== SmartPhone(1,2,3) =====");
		
		SmartPhone sp2 = new SmartPhone("010-8520-0258", "삼성", 2);
		sp2.sendCall();
		sp2.receiveCall();
		sp2.sendSMS();
		sp2.receiveSMS();
		sp2.calc(10, 20);
		System.out.println("전화번호: " + sp2.number);
		System.out.println("브랜드: " + sp2.getBrand());
		System.out.println("카메라 갯수: " + sp2.camera);
		
		System.out.println("===== ArrayList =====");
		// 개발자가 만든 클래스를 ArrayList의 <> 안에 넣을 수가 있다.
		ArrayList<SmartPhone> phoneList = new ArrayList<>();
		phoneList.add(sp);
		phoneList.add(sp2);
		phoneList.add(new SmartPhone("010-7410-0147", "소니", 2));
		phoneList.add(new SmartPhone("010-9630-0369", "엘지", 1));
		phoneList.get(0).calc(90, 110);
		for(int i = 0; i < phoneList.size(); i++) {  // ArrayList의 길이 구할 때는 length 아니고 size!!
			System.out.println(phoneList.get(i).getBrand());
		} // 위의 for문과 아래의 for-each문은 결과가 같다. 코드는 아래가 더 간결하다. 위는 이제 유물이다...
		for(SmartPhone s : phoneList) {			// phoneList의 레퍼런스를 첫번째부터 순차적으로 s 레퍼런스에 저장
			System.out.println(s.getBrand());  	// s == phoneList.get(i),  phoneList 자리는 배열이나 나열 입력
		}
		
		System.out.println("===== HashMap =====");
		HashMap<String, SmartPhone> phoneList2 = new HashMap<>();
		phoneList2.put("홍길동", sp2);  // add가 아니라 put으로 데이터를 추가한다.
		phoneList2.put("김철수", new SmartPhone("010-7530-0357", "애플", 2));
		phoneList2.put("이순신", new SmartPhone("010-9510-0159", "구글", 2));
		for(String name : phoneList2.keySet()) {  // keySet() : phoneList2의 키값만 모두 꺼내와서 배열처럼 나열
			System.out.println(phoneList2.get(name).getBrand());
		}
		phoneList2.get("홍길동").sendCall();
	}
}
