// 예제 3-12 : 정수 4개를 가지는 1차원 배열을 생성하고 1,2,3,4,로 초기화한 다음,
// 			   배열을 리턴하는 makeArray() 메소드를 작성하고,
// 		 	   이 메소드로부터 배열을 전달 받아 값을 출력하는 프로그램을 작성하시오.
public class Sample0507 {

	static int[] makeArray() {  // 정수형 배열을 리턴하는 메소드 생성
		int temp[] = new int[4];  // 배열 생성 (4칸)
		for(int i = 0; i < temp.length; i++) { 
			temp[i] = i; // 배열 temp의 원소를 0, 1, 2, 3으로 초기화 (temp.length가 4로 지정됨)
		}
		return temp; // 메소드에서 배열 temp 리턴
	}
	public static void main(String[] args) { 
		int[] intArray; // 새로운 배열 레퍼런스 생성
		intArray = makeArray();  // 메소드 호출하면 반환되는 배열 temp 레퍼런스를 intArray 레퍼런스에 대입
		for(int i = 0; i < intArray.length; i++) { 
			System.out.print(intArray[i] + " ");  // 배열 intArray의 모든 원소 출력
		}

	}

}
