// 7-8 : Collections 클래스를 활용하여 문자열 정렬, 반대로 정렬, 이진 검색 등을 실행하시오.
import java.util.*;

public class Day0904 {
	static void printList(LinkedList<String> l) { // printList 메소드 생성
		Iterator<String> iterator = l.iterator();
		while(iterator.hasNext()) {
			String e = iterator.next();
			String separator;
			if(iterator.hasNext()) {
				separator = "->";
			} else {
				separator = "\n";
			}
			System.out.print(e + separator);
		}
	}
	
	public static void main(String[] args) {
		LinkedList<String> myList = new LinkedList<String>();
		myList.add("트랜스포머");
		myList.add("스타워즈");
		myList.add("매트릭스");
		myList.add(0, "터미네이터");
		myList.add(2, "아바타");
		
		Collections.sort(myList);   // Collections.sort() : 오름차순 정렬 
		printList(myList);    		// sort()는 static 메소드로, 클래스명.메소드명 으로 바로 호출 가능
		
		Collections.reverse(myList);  // Collections.reverse() : 역순으로 나열
		printList(myList);		   	  // reverse()는 static 메소드로, 클래스명.메소드명 으로 바로 호출 가능
		
		// Collections.binarySearch(a, b) : a에서 b의 위치값 찾아서 반환 (binarySearch()도 static 메소드)
		int index = Collections.binarySearch(myList, "아바타");  
		System.out.println("아바타는 " + index + "번째 인덱스(= 실제 " + (index + 1) + "번째 칸)에 위치한 요소입니다.");
	}

}
