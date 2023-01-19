// 6-9 : "홍길동/장화/홍련/콩쥐/팥쥐" 문자열을 '/'를 구분문자로 하여 토큰을 분리하여 각 토큰을 출력하시오.
// StringTokenizer 클래스 메소드 활
import java.util.StringTokenizer;

public class Day0802 {

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("홍길동/장화/홍련/콩쥐/팥쥐", "/");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}
