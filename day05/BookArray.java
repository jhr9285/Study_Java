import java.util.Scanner;

// 4-7. 4-4의 Book 클래스를 활용하여 2개짜리 Book 객체 배열을 만들고,
// 		사용자로부터 책의 제목과 저자를 입력 받아 배열을 완성하시오.
public class BookArray {

	public static void main(String[] args) {
		Book[] book = new Book[2];  // Book 타입 배열을 선언하고 레퍼런스 변수 book을 함께 선언하여 연결시킴
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i < book.length; i++) {
			System.out.print("제목>>");
			String title = scanner.nextLine();
			System.out.print("저자>>");
			String author = scanner.nextLine();
			book[i] = new Book(title, author); // 배열 원소 객체(instance) 생성 - book의 원소는 객체의 참조값
		}
		
		for(int i = 0; i < book.length; i++) {
			System.out.print("<" + book[i].title + "> " + book[i].author + " 저 \n");
		}
	}

}
