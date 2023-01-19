// 6-8 : StirngBuffer 를 이용하여 문자열을 조작하는 다음 코드의 실행 결과는 무엇입니까?
public class Day0801 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("This");
		
		sb.append(" is pencil");
		System.out.println(sb);
		
		sb.insert(7, " my");  // 그 자리(7)에 들어간다.
		System.out.println(sb);
		
		sb.replace(8, 10, "your");
		System.out.println(sb);
		
		sb.delete(8, 13);
		System.out.println(sb);
		
		sb.setLength(4);
		System.out.println(sb);
		
		// StringBuffer로 만든 객체의 데이터는 수정 시 원본이 바뀐다.
	}
}
