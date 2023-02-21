// 9-1 : 300 x 300 크기의 스윙 프레임을 작성하시오.
import javax.swing.JFrame;

public class Swing01 extends JFrame {
	public Swing01() {
		setTitle("학사관리"); // 프레임 위쪽 제목
		setSize(300, 300); // 프레임 사이즈
		setVisible(true); // true 로 해야 보인다.
	}
	public static void main(String[] args) {  // main() 메소드를 frame 클래스에서 분리시키는 것을 권장한다.
		Swing01 frame = new Swing01();		  // 다른 페이지로 넘어가게 구현하다 보면 클래스가 여러 개 필요함.
	}

}
