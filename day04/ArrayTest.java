
public class ArrayTest {

	public static void main(String[] args) {
		int [] arr = new int[4];
/*		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		
		System.out.println("====="); */
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i * 10;
			System.out.println(arr[i]);
		} 
		
		System.out.println("=====");
		int [] arr2 = arr;  // arr 레퍼런스값을 arr2로 복사
		for(int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);  // arr2[i]로 값을 찾아도 arr[i]와 동일한 결과가 나온다
		}
		
		System.out.println("=====");
		arr2[0] = 1000;  // arr2[0] 데이터 바꾸고
		System.out.println(arr[0]); // arr[0] 데이터 확인하면? 바뀌어 있다.
		                            // 동일한 인스턴스에 연결되어 있기 때문!!
	}

}
