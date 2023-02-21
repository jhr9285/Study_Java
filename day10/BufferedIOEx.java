// 8-7 : 버퍼 크기를 5로 하고, 표준 출력 스트림(System.out)과 연결한 버퍼 출력 스트림을 생성하시오.
//		 C:\Temp\test2.txt 파일을 저장된 영문 텍스트를 읽어 버퍼 출력 스트림을 통해 출력하시오.
import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BufferedIOEx {

	public static void main(String[] args) {
		FileReader fin = null;
		int c;
		try {
			fin = new FileReader("C:\\Temp\\test2.txt"); // test2.txt 파일을 읽어서 객체로 만들어서 변수 fin 연결
			BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
			// 표준출력, 버퍼크기 5인 버퍼아웃풋스트림 객체 생성, 변수 out에 연결
			while ((c = fin.read()) != -1) { // text2.txt 파일을 한 글자씩 읽는데, 
				out.write(c);				 // 읽을 값이 없는 때가 되면 -1 반환되므로 그때 종료
			}								// 읽을 값이 있을 때는 c를 표준출력+버퍼크기 5 로 출력(버퍼에서 사라짐)
			
			new Scanner(System.in).nextLine(); // 스캐너를 변수 없이 객체 생성해서 메소드 사용 가능 (close() 불가)
			out.flush(); // 사이즈 5로 한정하여 출력했기 때문에, 버퍼에 남아있는 그 외의 데이터 모두 출력
			fin.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
