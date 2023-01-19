// 8-1 : FileReader를 이용하여 C:\windows\system.ini 텍스트 파일을 읽어 화면에 출력하는 프로그램을 작성하시오.

import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
	public static void main(String[] args) {
		FileReader fin = null;
		try {
			fin = new FileReader("C:\\windows\\system.ini");
			int c;
			while((c = fin.read()) != -1) {  // 파일의 끝을 만나면 read()가 -1 리턴
				System.out.print((char)c);
			}
			fin.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
	}
}
