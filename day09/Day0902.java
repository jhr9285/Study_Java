// 7-6 : 해시맵을 이용하여 학생의 이름과 자바 점수를 기록 관리하는 프로그램을 작성하시오.
import java.util.*;

public class Day0902 {

	public static void main(String[] args) {
		HashMap<String, Integer> javaScore = new HashMap<String, Integer>();
		
		javaScore.put("김성동", 97);
		javaScore.put("황기태", 88);
		javaScore.put("김남윤", 98);
		javaScore.put("이재문", 70);
		javaScore.put("한원선", 99);
		
		System.out.println("HashMap의 요소 개수 : " + javaScore.size());
		
		// Set<E> 타입의 레퍼런스 변수 keys 생성, javaScore의 모든 키값 넣음 (순서 없이 랜덤으로 넣음) 
		// Set<E> 는 인터페이스라서 객체 생성 불가. keySet()은 HashMap<E> 소속 메소드지만 리턴값이 Set<E> 타입임
		Set<String> keys = javaScore.keySet();
		
		// Iterator<E> 타입의 레퍼런스 변수 it 생성, keys의 모든 키값 순차적으로 넣음
		Iterator<String> it = keys.iterator();
		// it 에 방문할 요소가 하나라도 있으면 블럭 내용 반복
		while(it.hasNext()) {
			String name = it.next(); // name에 it의 요소 첫번째부터 순서대로 반복하여 넣음, 다음 요소 없으면 반복끝
			int score = javaScore.get(name);
			System.out.println(name + " : " + score);
		}
		
		System.out.println();
		// iterator 코딩 대신 for each 문 사용하는 게 더 간결하고 빠르고 쉽다.
		// for(변수 : ' ') <-- ' ' 부분에는 배열과 유사하게 '여러 가지 데이터가 나열된' 무언가가 들어가면 된다.
		for(String key : javaScore.keySet()) {
			System.out.println(key + " : " + javaScore.get(key));
		}
	}

}
