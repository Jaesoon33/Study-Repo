package chap06.constructors;

class Book {
	// 필드
	String title;
	String author;
	int pages;
	double prices;
	String isbn;
	
	// 생성자 1: 기본 생성자
	public Book() {
		this.title = "Unknown";
		this.author = "Unknown";
		this.pages = 0;
		this.prices = 0;
		this.isbn = "000-0-00-000000-0"; 		
	};
	
	// 생성자 2: 제목만 할당 
	public Book(String title) {
		this.title = title;
		this.author = "Unknown";
		this.pages = 0;
		this.prices = 0;
		this.isbn = "000-0-00-000000-0"; 		
	}
	
	// 생성자 3: 제목 + 저자 할당
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.pages = 0;
		this.prices = 0;
		this.isbn = "000-0-00-000000-0"; 		
	}
	
	// 생성자 3: 제목 + 저자 + 페이지 할당
	public Book(String title, String author, int pages) {
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.prices = 0;
		this.isbn = "000-0-00-000000-0"; 		
	}	
	
	// 생성자 4: 제목 + 저자 + 페이지 + 가격 할당
	public Book(String title, String author, int pages, double price) {
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.prices = price;
		this.isbn = "000-0-00-000000-0"; 		
	}
	
	// 생성자 5: 모두 할당 - 전체 필드
	public Book(String title, String author, int pages, double prices, String isbn) {
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.prices = prices;
		this.isbn = isbn;	
	}			

	void displayInfo() {
		System.out.println("----------------------------------");
		System.out.println("제목: " + this.title);
		System.out.println("저자: " + this.author);
		System.out.println("페이지: " + this.pages);
		System.out.printf("가격: %,.0f원\n", this.prices);
		System.out.println("ISBN: " + this.isbn);
	}
	
}

public class Constructors {
	public static void main(String[] args) {
		System.out.println("=== 1. 생성자를 오버로딩 기본 (this() 사용하기 전) ===");
		Book b1 = new Book();
		Book b2 = new Book("피지컬 AI 메가 트렌드");
		Book b3 = new Book("2026 피지컬 AI 기술, 시장 전망과 유망 분야별 적용 동향 및 사업 전략","IRS글로벌 산업조사실, 이중원, 이윤혜 저자(글)");
		Book b4 = new Book("AI 에이전트 마스터 클래스","김구현", 340, 23400, "9791175790155");
		b1.displayInfo();
		b2.displayInfo();
		b3.displayInfo();
		b4.displayInfo();
		
	}
}
