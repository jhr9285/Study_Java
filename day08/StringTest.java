import java.util.ArrayList;
import java.util.StringTokenizer;

// String 클래스 메소드 활용
public class StringTest {
	public static void main(String[] args) {
		String fileName = "report.hwp";
		System.out.println(fileName.indexOf(".")); // 앞에서부터 "."이 몇 번째 위치하는지 추출 (처음 나오는 것만)
		
		int positionOfDot = fileName.indexOf(".");
		System.out.println(fileName.substring(positionOfDot));  // beginIndex 포함하여 마지막까지 추출
		System.out.println(fileName.substring(positionOfDot + 1));  // beginIndex 다음 글자부터 마지막까지 추출
		
		System.out.println("==========");
		
		String fileName2 = "2023.01.18.report.hwp"; // 파일명에 점을 여러 개 쓸 수 있다.
		System.out.println(fileName2.lastIndexOf(".")); // 뒤에서부터 "."이 몇 번째 위치하는지 추출 (처음 나오는 것만)
														// 숫자는 앞에서부터 센 숫자로 반환
		int positionOfDot2 = fileName2.lastIndexOf(".");
		System.out.println(fileName2.substring(positionOfDot2));  // beginIndex 포함하여 마지막까지 추출
		System.out.println(fileName2.substring(positionOfDot2 + 1));  // beginIndex 다음 글자부터 마지막까지 추출
		
		// 예전에는 lastIndexOf()가 없어서 문자열을 reverse()로 뒤집어서 indexOf()를 사용했다.
		
		System.out.println("==========");
		
		String data = "서울시 구로구,홍길동,컴퓨터공학과"; // ,로 구분되어있는 데이터 : csv (comma seperated value)
		String[] result = data.split(",");
		
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
		String data2 = "서울시 구로구-홍길동-컴퓨터공학과"; 
		String[] result2 = data2.split("-");
		
		for(int i = 0; i < result2.length; i++) {
			System.out.println(result2[i]);
		}
		
		System.out.println("==========");
		
		String data3 = data.replace(",", "|");
		System.out.println(data3);
		
		System.out.println("=========="); // ArrayList, StringTokenizer 사용한 별도 사례
		
		StringTokenizer st = new StringTokenizer("A,B,C", ","); // A, B, C를 "," 기준으로 나눠서 토큰들의 배열 생성 (레퍼런스 = st)
		String[] tokens = new String[st.countTokens()]; // tokens 라는 스트링 타입 배열에 위 토큰들의 갯수만큼 길이 지정
														// countTokens() : 스트링 토크나이저가 분리한 토큰의 갯수 리턴
		ArrayList<String> arrayList = new ArrayList<String>(); // ArrayList 객체 생성
		int i = 0;	// 변수 i 선언 및 0으로 초기화
		while(st.hasMoreTokens()) { // st 레퍼런스변수가 가리키는 토큰들의 배열에 토큰이 1개 이상 있으면 반복
			arrayList.add(st.nextToken());  // arrayList에 st의 토큰을 순차적으로 삽입
			System.out.println(arrayList.get(i));  // arrayList 배열을 순차적으로 출력
			i++; 
		}
		
	}
}
