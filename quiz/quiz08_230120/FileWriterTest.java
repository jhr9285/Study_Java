package quiz08_230120;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) throws IOException {
		
		String arr = "/ by zero";
		
		FileWriter fr = new FileWriter("C:\\log\\errortest.txt");
		try {
			fr.write(arr, 0, arr.length());
			fr.close();
		} catch(IOException e) {
			System.out.println("내용 입력 오류");
		}
	}

}
