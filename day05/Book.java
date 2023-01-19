// 4-5. Book 클래스의 생성자를 this()를 이용하여 작성하시오.
public class Book {
	String title;
	String author;
	void show() {// show() 라는 이름의 메소드를 만들었고, 리턴값이 없어서 void를 앞에 붙였다. (출력은 리턴 아님)
		System.out.println(title + " " + author);
	}
	
	public Book() { // 파라미터 없는 기본생성자를 무조건!! 제일 먼저 작성해야 함
		this("", "");
		System.out.println("생성자 호출됨");
	}
	
	public Book(String title) {
		this(title, "작자미상");
	}
	
	public Book(String title, String author) { // 이 생성자가 위의 두 생성자에 호출되어 사용되고 있는데
		this.title = title;                    // 가장 위에 쓰여야 하거나 하지 않음. 에러 없음!
		this.author = author;
	}
	
	public static void main(String[] args) {
		Book littlePrince = new Book("어린왕자", "생텍쥐페리");
		Book loveStory = new Book("춘향전");
		Book emptyBook = new Book();
		loveStory.show();
	}

}
