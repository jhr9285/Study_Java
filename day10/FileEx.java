// 8-8 : File 클래스를 이용하여 파일의 타입을 알아내고, 디렉터리에 있는 파일들을 나열하며,
//		 디렉터리 이름을 변경하는 프로그램을 작성하시오.
import java.io.File;
import java.text.SimpleDateFormat;

public class FileEx {
	public static void listDirectory(File dir) { // 메소드 생성
		System.out.println("-----" + dir.getPath() + "의 서브리스트입니다.-----");
//		File[] subFiles = dir.listFiles();
//		for(int i = 0; i < subFiles.length; i++) {
//			File f = subFiles[i];
//			long t = f.lastModified();
//			System.out.print(f.getName());
//			System.out.print("\t파일 크기: " + f.length());
//			System.out.printf("\t수정한 시간: %tb %td %ta %tT\n", t, t, t, t);
		File file = new File("C:\\Temp");
		File[] subFiles = file.listFiles();
			for(File f3 : subFiles) {
				System.out.print(f3.getName() + "\t");
				System.out.print(f3.length() + "\t");
				SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss"); // MM,HH 대문자로, mm,ss는 소문자로
				System.out.println(sf.format(f3.lastModified()));
			}
		}
//	}
	
	public static void main(String[] args) {
		File f1 = new File("C:\\windows\\system.ini");
		System.out.println(f1.getPath() + ", " + f1.getParent() + ", " + f1.getName());
		String res = "";
		if(f1.isFile()) {
			res = "파일";
		} else if(f1.isDirectory()) {
			res = "디렉터리";
		}
		System.out.println(f1.getPath() + "은 " + res + "입니다.");
		
		File f2 = new File("C:\\Temp\\java_sample");
		if(!f2.exists()) {
			f2.mkdir();
		}
		listDirectory(new File("C:\\Temp"));
		f2.renameTo(new File("C:\\Temp\\javaSample"));
		listDirectory(new File("C:\\Temp"));
	}

}
