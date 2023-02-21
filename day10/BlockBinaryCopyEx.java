// 8-11 : 블록 단위로 바이너리 파일 고속 복사
import java.io.*;

public class BlockBinaryCopyEx {

	public static void main(String[] args) {
		File src = new File("C:\\Users\\y\\Downloads\\pexels-stayhereforu-13413547.jpg");
		File dest = new File("C:\\Temp\\mood.jpg");
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			byte[] buf = new byte[1024*10]; // 10KB 버퍼
			while(true) {
				int n = fi.read(buf);
				fo.write(buf, 0, n);
				if(n < buf.length) {
					break;
				}
			}
			fi.close();
			fo.close();
			System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다.");
		} catch(IOException e) {
			System.out.println("파일 복사 오류");
		}
	}
}
