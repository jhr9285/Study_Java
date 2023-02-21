// 8-10 : 바이너리 파일 고속 복사
import java.io.*;

public class BinaryCopyEx2 {

	public static void main(String[] args) {
		File src = new File("C:\\Users\\y\\Downloads\\pexels-stayhereforu-13413547.jpg");
		File dest = new File("C:\\Temp\\mood2.jpg");
		int c;
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			while((c = fi.read()) != -1) {
				fo.write((byte)c);
			}
			fi.close();
			fo.close();
			System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다.");
		} catch(IOException e) {
			System.out.println("파일 복사 오류");
		}
	}
}
