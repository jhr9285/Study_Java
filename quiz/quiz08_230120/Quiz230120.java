// 1. 책제목, 저자, 출판사, 가격을 키보드 입력을 통해서 ArrayList에 저장하시오.
package quiz08_230120;

import java.util.*;

class Book {
	private String title, author, publisher, price;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public Book() {}
	
	public Book(String title, String author, String publisher, String price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}
}

public class Quiz230120 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> bookArr = new ArrayList<String>();

			System.out.print("책제목 입력 >> ");
			String input = scanner.nextLine();
			bookArr.add(input);
			
			System.out.print("저자 입력 >> ");
			input = scanner.nextLine();
			bookArr.add(input);

			System.out.print("출판사 입력 >> ");
			input = scanner.nextLine();
			bookArr.add(input);
			
			System.out.print("가격 입력 (ex, 20000) >> ");
			input = scanner.nextLine();

			bookArr.add(input);
		
		// 2. 1번을 HashMap을 이용해서 저장하고 출력하시오.
		//    key => 책제목, 저자, 출판사, 가격
		HashMap<String, String> bookInfo = new HashMap();
		String[] keys = {"책제목", "저자", "출판사", "가격"};
		
		for(int i = 0; i < bookArr.size(); i++) {
			for(int j = 0; j < keys.length; j++) {
				bookInfo.put(keys[j], bookArr.get(i));
			}
		}
		
		System.out.println("======================");
		for(int i = 0; i < bookInfo.size(); i++) {
			System.out.println(keys[i] + " : " + bookInfo.get(keys[i]));
		}
		System.out.println("======================");
		
		// 3. 1번을 Book이라는 클래스를 만든 다음 ArrayList에 Book객체를 넣어서 처리하기.
		//	  ArrayList<Book> data=new ArrayList<Book>();
		ArrayList<Book> data1 = new ArrayList<Book>();
		ArrayList<Book> data2 = new ArrayList<Book>();
		ArrayList<Book> data3 = new ArrayList<Book>();
		
		System.out.println("[철학] 분류의 책 정보를 입력합니다.");
		System.out.print("책제목 입력 >> ");
		String inputT1 = scanner.nextLine();
		System.out.print("저자 입력 >> ");
		String inputA1 = scanner.nextLine();
		System.out.print("출판사 입력 >> ");
		String inputPS1 = scanner.nextLine();
		System.out.print("가격 입력 (ex, 20000) >> ");
		String inputPR1 = scanner.nextLine();
		
		Book book1 = new Book(inputT1, inputA1, inputPS1, inputPR1);
		
		data1.add(book1);
		
		System.out.println("[언어] 분류의 책 정보를 입력합니다.");
		System.out.print("책제목 입력 >> ");
		String inputT2 = scanner.nextLine();
		System.out.print("저자 입력 >> ");
		String inputA2 = scanner.nextLine();
		System.out.print("출판사 입력 >> ");
		String inputPS2 = scanner.nextLine();
		System.out.print("가격 입력 (ex, 20000) >> ");
		String inputPR2 = scanner.nextLine();
		
		Book book2 = new Book(inputT2, inputA2, inputPS2, inputPR2);
		
		data2.add(book2);
		
		System.out.println("[컴퓨터공학] 분류의 책 정보를 입력합니다.");
		System.out.print("책제목 입력 >> ");
		String inputT3 = scanner.nextLine();
		System.out.print("저자 입력 >> ");
		String inputA3 = scanner.nextLine();
		System.out.print("출판사 입력 >> ");
		String inputPS3 = scanner.nextLine();
		System.out.print("가격 입력 (ex, 20000) >> ");
		String inputPR3 = scanner.nextLine();
		
		Book book3 = new Book(inputT3, inputA3, inputPS3, inputPR3);
		
		data3.add(book3);
		
		scanner.close();
		
		// 4. HashMap에 ArrayList<Book>을 넣어서 처리하기.
		//    HashMap의 key는 "철학", "언어", "컴퓨터공학"
		HashMap<String, ArrayList<Book>> bookInfo2 = new HashMap();
		String[] keys2 = {"철학", "언어", "컴퓨터공학"};
		
		bookInfo2.put(keys2[0], data1);
		bookInfo2.put(keys2[1], data2);
		bookInfo2.put(keys2[2], data3);
		
		System.out.println(bookInfo2.get("철학").get(0).getTitle() + ", "+ bookInfo2.get("철학").get(0).getAuthor()
						   + ", "+ bookInfo2.get("철학").get(0).getPublisher() + ", " + bookInfo2.get("철학").get(0).getPrice() + "원");
		System.out.println(bookInfo2.get("언어").get(0).getTitle() + ", " + bookInfo2.get("언어").get(0).getAuthor()
						   + ", " + bookInfo2.get("언어").get(0).getPublisher() + ", " + bookInfo2.get("언어").get(0).getPrice() + "원");
		System.out.println(bookInfo2.get("컴퓨터공학").get(0).getTitle() + ", " + bookInfo2.get("컴퓨터공학").get(0).getAuthor()
						   + ", " + bookInfo2.get("컴퓨터공학").get(0).getPublisher() + ", " + bookInfo2.get("컴퓨터공학").get(0).getPrice() + "원");

	}

}
