// 멀티스레딩 하는 경우, 특정 스레드가 먼저 끝난다는 보장이 없다. 순차적이지 않고 무작위로 실행된다.
class MyThread extends Thread {
	@Override
	public void run() {
//		super.run();   <- 안 쓰는 편.
		int n = 0;
//		while(true) {
		while(n < 10) {
			System.out.println("MyThread : " + n);
			try {
				sleep(1000);  // 빠른 무한루프 속도를 늦추려고 1초마다 sleep 하도록 설정
			} catch (InterruptedException e) { 				   // sleep은 try,catch 필수
				e.printStackTrace();
			} 
			n++;
		}
	}
}

public class ThreadTest {
	public static void main(String[] args) {  // 메인 메소드가 동작하는 스레드 : 메인 스레드
		MyThread th = new MyThread();  // 무한루프문 아래에 쓰면 실행이 안 돼서 오류 남. 위에 써야 함
		th.start();
		
		int n = 0;
//		while(true) {
		while(n < 10) {
			System.out.println("MainThread : " + n);
			try {
				Thread.sleep(1000); // Thread를 상속받은 게 아니기 때문에 Thread.sleep() 해야 함 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			n++;
		}
	}
}