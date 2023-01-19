package quiz07_230119;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Quiz230119 {
	public static void main(String[] args) {
		
		// 1. 주민등록번호(010101-123456)에서 생년월일을 추출하시오.
		
		System.out.println("=========== 1번 ===========");
		StringTokenizer st = new StringTokenizer("010101-123456", "-");
		System.out.println("생년월일: " + st.nextToken());
		
		// 2. 전화번호(010-1234-5678)에서 '-'을 제거하시오. => 01012345678 로 변경하기.
		
		System.out.println("=========== 2번 ===========");
		String tel = "010-1234-5678";
		String[] telArr = tel.split("-");
		System.out.print("변경된 전화번호: ");
		for(int i = 0; i < telArr.length; i++) {
			System.out.print(telArr[i]);
		}
		
		// 3. 상품코드(E20160001)에서 상품카테고리('E')를 추출하시오.
	
		System.out.println("\n=========== 3번 ===========");
		String code = "E20160001";
		char c = code.charAt(0);
		System.out.println("상품카테고리: " + c);
		
		// 4. 상품코드(E20160001)에서 년도('2016')를 추출하시오.
		
		System.out.println("=========== 4번 ===========");
		System.out.println("년도: " + code.substring(1, 5));
		
		// 5. 주소록 csv데이터에서 데이터를 분리하시오. (홍길동,010-1111-2222,hkd@hkd.com)
		
		System.out.println("=========== 5번 ===========");
		String info = "홍길동,010-1111-2222,hkd@hkd.com";
		StringTokenizer infoSplit = new StringTokenizer(info, ",");
		while(infoSplit.hasMoreTokens()) {
			System.out.println(infoSplit.nextToken());
		}
		
		// 6. csv데이터에 다음과 같은 학번이 저장되어 있을 때 각 학번의 학과명을 출력하시오.
		// EL201800001,CH201800021,EN12231
		// EL-전자공학과, CH-화학공학과, EN-영어영문학과
		
		System.out.println("============= 6번 =============");
		HashMap<String, String> department = new HashMap();
		department.put("EL", "전자공학과");
		department.put("CH", "화학공학과");
		department.put("EN", "영어영문학과");
		
		String idList = "EL201800001,CH201800021,EN12231";
		String[] dp = idList.split(",");

		for(int i = 0; i < dp.length; i++) {
			System.out.println(dp[i] + "의 학과: "+ department.get(dp[i].substring(0, 2)));
		}
		
		// 7. 아이디에 !,@,#,$,%,^가 포함된 경우 '아이디에 !,@,#,$,%,^가 포함되면 안됩니다.' 
		// 	  메시지 출력하기. charAt()참고.
		
		System.out.println("============= 7번 =============");
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("아이디를 입력하세요 >> ");
		String id = scanner.nextLine();
		for(int i = 0; i < id.length(); i++) {
			char oneChar = id.charAt(i);
			
			if(oneChar == '!' || oneChar == '@' || oneChar == '#' || 
			   oneChar == '$' || oneChar == '%' || oneChar == '^') {
				System.out.println("아이디에 !,@,#,$,%,^가 포함되면 안됩니다.");
				System.out.print("아이디를 입력하세요 >> ");
				id = scanner.nextLine();
			}
		}
		System.out.println("입력한 아이디: " + id);
		scanner.close();
	}
}
