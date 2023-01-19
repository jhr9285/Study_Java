// 7-3 : 이름을 4개 입력받아 ArrayList에 저장하고 모두 출력한 후 가장 긴 이름을 출력하시오.
import java.util.ArrayList; // import 단축키 : ctrl + shift + O
import java.util.Scanner;

public class Day0803 {
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>(); // ★ArrayList<String> 객체 생성, a 레퍼런스와 연결
		
		Scanner scanner = new Scanner(System.in);  	   // 스캐너 생성, 이름 네 번 입력해서 ArrayList에 
		for(int i = 0; i < 4; i++) {				   // 순차적으로 이름 데이터의 레퍼런스 반영
			System.out.print("이름을 입력하세요>>");
			String s = scanner.next();
			a.add(s); // ★
		}
		
		for(int i = 0; i < a.size(); i++) {  // ★위에서 완성된 a 배열의 길이(size)를 
			String name = a.get(i);  		 //  횟수로 삼아서 데이터 반복 출력
			System.out.print(name + " ");
		}
		
		int longestIndex = 0; // 입력된 데이터 중 가장 길이가 긴 데이터의 인덱스를 찾는 변수, 인덱스 0으로 초기화
		for(int i = 1; i < a.size(); i++) { // a 배열의 길이만큼, 두 번째 데이터부터 마지막 데이터까지 반복
			if(a.get(longestIndex).length() < a.get(i).length()) { // 첫 번째 데이터와 2,3,4번째 데이터 순차 비교
				longestIndex = i; // 가장 긴 값 대입
			}
		}
		System.out.println("\n가장 긴 이름은 : " + a.get(longestIndex)); // 가장 긴 값 출력
		scanner.close();
	}
}
