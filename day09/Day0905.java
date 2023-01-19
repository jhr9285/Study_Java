// 7-9 : 스택을 제네릭 클래스로 작성하고, String과 Integer형 스택을 사용하는 예를 보이시오.
class GStack<T> {   // 제네릭 클래스 선언 (매개면수는 타입)
	int idx; 		// 인덱스 선언
	Object[] stck;	// Object 배열 stck 레퍼런스 선언
	public GStack() { // 생성자함수 작성
		idx = 0;
		stck = new Object[10];
	}
	public void push(T item) {
		if(idx == 10) {
			return;
		}
		stck[idx] = item;
		idx++;
	}
	public T pop() {
		if(idx == 0) {
			return null; 
		}
		idx--;
		return (T)stck[idx];
	}
}

public class Day0905 {

	public static void main(String[] args) {
		GStack<String> stringStack = new GStack<String>();
		stringStack.push("seoul");
		stringStack.push("busan");
		stringStack.push("LA");
		
		for(int i = 0; i < 3; i++) {
			System.out.println(stringStack.pop());
		}
		
		GStack<Integer> intStack = new GStack<Integer>();
		intStack.push(1);
		intStack.push(3);
		intStack.push(5);
		
		for(int i = 0; i < 3; i++) {
			System.out.println(intStack.pop());
		}
	}
}
