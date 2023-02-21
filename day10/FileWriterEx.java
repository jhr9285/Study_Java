// 8-4 : Scanner를 이용하여 키보드에서 입력받은 데이터를 C:\Temp\test.txt 파일에 저장하는 프로그램을 작성하시오.
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FileWriter fout = null;
		int c;
		try {
			fout = new FileWriter("C:\\Temp\\test.txt");
			while(true) {
				String line = scanner.nextLine();
				if(line.length() == 0) {
					break;
				}
				fout.write(line, 0, line.length());
				fout.write("\r\n", 0, 2);
			}
			fout.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
		scanner.close();
	}

}
