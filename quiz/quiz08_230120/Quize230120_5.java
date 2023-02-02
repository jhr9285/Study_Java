/*
 	5. Exception이 발생하면, 에러메시지를 로그파일에 기록하는 프로그램을 작성하시오. (파일입출력)
		현재시각 : 2019년3월5일15시30분10초001(밀리세컨드) 라면
		(파일명 : 20190305153010001.log) 인 파일이 (저장경로 : c:\\log) 에 자동생성되도록 하시오.
		(SimpleDataFormat 이용)
		
		1/0 로 테스트 (0으로 나누는 오류로 테스트)
		
		catch블럭에서 파일에 에러메시지 기록.
		catch(Exception e){
			e.getMessage()=> 에러메시지 구하는 코드
			에러메시지를 여기서 로그파일에 기록 (<<여기에서 코딩) 트라이캐치 안에서 트라이캐치 가능
		}
 */
package quiz08_230120;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Quize230120_5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("입력 >> ");
			int num = scanner.nextInt();
			System.out.print("입력 >> ");
			int num1 = scanner.nextInt();
			int result = num / num1;
			scanner.close();
		} catch(Exception e) {
			Date errorTime = new Date();
			SimpleDateFormat errorTimeLog = new SimpleDateFormat("YYYYMMDDHHmmssSSS");
			
			String errorMessage = e.getMessage();
			String errorLogFileName = errorTimeLog.format(errorTime);
			
			File f = new File("C:\\log\\" + errorLogFileName + ".txt");
			if(!f.exists()) {
				System.out.println("[" + errorMessage + "] 오류가 발생하였습니다.");
				System.out.println(f + "이 C:\\log 경로에 생성되었습니다.");
			}
				
			try {
				FileWriter fw = new FileWriter(f);
				fw.write(errorMessage, 0, errorMessage.length());  // 예외처리를 꼭 해야 하는 write() 메소드는 try catch 안하면 에러 발생
				fw.close();
			} catch(IOException i) {
				System.out.println("에러메시지 파일저장 오류");
			}
		}
	}

}
