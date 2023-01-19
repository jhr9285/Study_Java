import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// Calendar, SimpleDateFormat 활용
public class DateTest {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();  // getInstance()는 Calendar 클래스에 static으로 올라간 메소드
		System.out.println(c.get(Calendar.YEAR) + "년");
		System.out.println(c.get(1) + "년"); // 가능은 하지만 뭔지 모르므로 위 코드처럼 쓰는 걸 권장함
		System.out.println(c.get(Calendar.MONTH) + 1 + "월");
		System.out.println(c.get(Calendar.DAY_OF_YEAR) + "일");
		System.out.println(c.get(Calendar.DAY_OF_MONTH) + "일");
		System.out.println(c.get(Calendar.HOUR) + "시"); // 12시간 체계
		System.out.println(c.get(Calendar.HOUR_OF_DAY) + "시"); // 24시간 체계
		System.out.println(c.get(Calendar.MINUTE) + "분"); 		
		System.out.println(c.get(Calendar.SECOND) + "초"); 		
		System.out.println(c.get(Calendar.MILLISECOND) + "초");
		
		String month;  // String month = Integer.toString(c.get(Calendat.MONTH)); 하면 됨
		if(c.get(Calendar.MONTH) <= 8) {
			month = "0" + (c.get(Calendar.MONTH)+1); 
		} else {
			month = Integer.toString(c.get(Calendar.MONTH));
		}
		System.out.println(c.get(Calendar.YEAR) + "-" + (month) + "-" + (c.get(Calendar.DAY_OF_YEAR)));
		
		System.out.println("=====================");
		
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("YYYY년 MM월 DD일");
		System.out.println(format.format(now));
		
		SimpleDateFormat format2 = new SimpleDateFormat("YYYY.MM.DD a HH:mm:ss");
		System.out.println(format2.format(now));
		
		SimpleDateFormat format3 = new SimpleDateFormat("오늘은 E요일입니다.");
		System.out.println(format3.format(now));
	}

}
