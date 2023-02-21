// 8-9 : 문자스트림 FileReader와 FileWriter를 이용하여 C:\windows\system.ini를
//		 C:\Temp\system.txt 파일로 복사하는 프로그램을 작성하시오.
import java.io.*;

public class TextCopyEx {

	public static void main(String[] args) {
		File src = new File("C:\\windows\\system.ini"); // 원본 파일 경로명 (파일명 포함)
		File dest = new File("C:\\Temp\\system.txt"); // 복사본 파일 경로명 (파일명 포함)
		int c;
		try {
			FileReader fr = new FileReader(src); // 문자스트림-입력스트림 객체 생성
			FileWriter fw = new FileWriter(dest); // 문자스트림-출력스트림 객체 생성
			while((c = fr.read()) != -1) { // fr의 텍스트를 읽을 때 컴퓨터에 저장돼있는 숫자로 읽기 때문에
										   // c가 int 타입인 것이다.
				fw.write((char)c); // 출력할 때는 그 숫자를 char로 형변환 해서 출력한다.
			}
			fr.close();
			fw.close();
			System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다.");
		} catch(IOException e) {
			System.out.println("파일 복사 오류");
		}
	}

}
