// 예제 3-3 : do-while문을 이용하여 'a'부터 'z'까지 출력하는 프로그램을 작성하시오.
public class Sample0501 {
	public static void main(String[] args) {
		
		// do-while문
		char c = 'a';  // 문자 'a'를 변수 c에 대입
		
		do {
			System.out.print(c);
			c = (char)(c + 1);  // 변수 c에 a 다음 글자를 대입 (c + 1 = 'a'의 아스키코드 정수 + 1)
		} while (c <= 'z');  // 변수 c에 문자 'z'가 대입될 때까지 반복 
		
		// while문은 {} 뒤에 ;이 붙지 않지만, do-while문은 while() 뒤에 ; 붙어야 함
		
		System.out.println();  // println() 에 파라미터가 없으면 줄바꿈만 일어남
		
		// while문
		c = 'a';
		while(c <= 'z') {
			System.out.print(c);
			c=(char)(c + 1);
		}
		
		System.out.println();  // println() 에 파라미터가 없으면 줄바꿈만 일어남
		
		// for문
		for(char d = 'a'; d <= 'z'; d++) {  // d++ = (char)(c + 1)
			System.out.print(d);
		}
		
	} 
}
