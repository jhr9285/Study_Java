
public class Sample01 {
	public int add(int a, int b) {
		return a + b;
	} // 객체지향에서는 이처럼 코딩하지 않고 new 를 사용해서 instance 를 만들어서 코딩한다. (static은 instance를 만들지 않음)
	
	public static void main(String[] args) {
//		int result = add(10, 20);  // ** return 값은 함수를 호출한 자리에 나타난다. **
//		System.out.println(result);
		
//		System.out.println(add(10, 20));	// result 변수를 쓴 경우와 동일한 결과가 나온다.
		
		Sample01 s = new Sample01();  // new 키워드를 사용함으로써 인스턴스가 생성되었음  (앞쪽의 Sample01은 클래스, 뒤쪽의 Sample01은 '생성자')
		s.add(10, 20);
		System.out.println("s = " + s.add(10, 20));
		
		Sample01 s2 = new Sample01();
		System.out.println("s2 = " + s2.add(30, 40));
	}
}

