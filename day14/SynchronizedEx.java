// 스레드 동기화 예시
public class SynchronizedEx {
	public static void main(String[] args) {
		SharedBoard board = new SharedBoard();
		Thread th1 = new StudentThread("thread 1", board);
		Thread th2 = new StudentThread("thread 2", board);
		th1.start();
		th2.start();
	}
}

class SharedBoard {
	private int sum = 0; // 집계판의 합 변수(공유데이터!!)
	synchronized public void add() { // synchronized 키워드 유무에 따라 결과가 달라진다.
									 // 이 키워드가 없으면, add() 블럭 내의 코드가 일부만 실행된 채로
		int n = sum;				 // yield()에 의해 다음 스레드로 넘어갈 수도 있다.
									 // 최종 누적값이 마지막에 나오지 않기도 하고, 누적값이 계속 바뀌기도 한다.
		Thread.yield(); // 현재 실행중인 스레드를 보류 ==> runnable(준비) 상태에 두 개의 스레드가 모여있게 되고
		n += 10; // n에 10 증가                            이 중 다음에 실행할 스레드는 random으로 JVM이 자동실행  
		sum = n; // 증가한 n을 sum에 기록
		System.out.println(Thread.currentThread().getName() + " : " + sum);
	}
	public int getSum() {
		return sum;
	}
}

class StudentThread extends Thread {
	private SharedBoard board;

	public StudentThread(String name, SharedBoard board) {
		super(name);
		this.board = board;
	}
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			board.add();
		}
	}
}