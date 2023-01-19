// 8-2 : InputStreamReader를 이용하여 MS949 문자 집합으로 한글 텍스트 파일을 읽고 출력하시오.
import java.io.*;

public class FileReadHangulSuccess {
	public static void main(String[] args) {
		InputStreamReader in = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("C:\\Temp\\hangul.txt");
			in = new InputStreamReader(fin, ""); 
			int c;   					  // MS949 : 불러오는 파일이 ANSI 인코딩방식으로 저장되어 있으면 읽힘 
			
			System.out.println("인코딩 문자 집합은 " + in.getEncoding());
			while((c = in.read()) != -1) {
				System.out.print((char)c);
			}
			in.close();  // fin을 이용해서 in이 만들어졌기 때문에 in 먼저 close 해야 함
			fin.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
			e.printStackTrace();
		}
	}
}
