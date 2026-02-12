package chap08.interfacePackage02;




/*
 * 	기본 인터페이스 -- 문서 출력 시스템 
 * 		- 시나리오
 * 			- 회사의 문서 출력 시스템을 개발합니다.
 * 			- 다양한 문서 타입(Word, PDF, Memo)이 있고, 모두 "출력" 기능이 필요합니다.
 * 
 * 		- 목표
 * 			- 인터페이스 정의 방법
 * 			- implements 키워드로 인터페이스 구현
 * 			- @Override로 메서드 구현
 * 			- 인터페이스 타입으로 다형성 활용
 * 
 * 		인터페이스 안의 메서드는 자동으로 public abstract
 * 		인터페이스 안의 변수는 자동으로 public static final 
 */

abstract interface Printable {
	// 추상 메서드(구현부 없음)
	void print();			// 문서를 출력한다. 각 문서 타입마다 다르게 출력됨
	int getPageCount();		// 총 페이지 수를 반환
	
	// 상수 - 인터페이스에서 변수 선언 시 자동으로 상수로 캐스팅 됨
	int DEFAULT_DPI = 300;
}

/*
 * 	인터페이스 구현 클래스
 * 	
 * 		- 핵심 문법
 * 			- class 클래스명 implements 인터페이스명 { ... 구현}
 * 			- 인터페이스에 선언된 추상 메서드를 구현해야함
 */

class WordDocument implements Printable{
	
	// 필드 (class 고유 속성)
	private String title;		// 문서 제목
	private String content;		// 문서 내용
	private int pageCount;		// 페이지 수
	
	// 생성자
	public WordDocument(String title, String content, int pageCount) {
		//super();
		this.title = title;
		this.content = content;
		this.pageCount = pageCount;
	}
	
	
	@Override
	public void print() {
		System.out.println("    >> [WordDocument.print() 호출됨]");
		System.out.println("       [Word 문서 출력]              ");
		System.out.println("    제목: " + title);
		
		// 내용이 30자 초과 시 앞의 30자만 표시 후 "..."을 붙임
		String preview = content.length() > 30 ? content.substring(0, 30) + "..." : content; 
		System.out.println("    내용: " + preview);
		System.out.println("    인쇄 품질: " + DEFAULT_DPI + " DPI");
	}

	
	@Override
	public int getPageCount() {		// Word 문서의 페이지 수를 반환함
		return pageCount;
	}

	
	// Getter 메서드 (인터페이스와 무관)
	public String getTitle() {
		return title;
	}


	public String getContent() {
		return content;
	}
}


/*
 * 	PDFDocument 클래스: PDF 문서
 * 
 * 	Printable 인터페이스를 구현 -> print(), getPageCount() 구현
 */
class PDFDocument implements Printable{
	// Field
	private String fileName;		// PDF 파일명
	private String content;			// PDF 내용
	private int pageCount;			// 페이지 수
	
	
	// Constructor
	public PDFDocument(String fileName, String content, int pageCount) {
		//super();
		this.fileName = fileName;
		this.content = content;
		this.pageCount = pageCount;
	}
	
	@Override
	public void print() {
		System.out.println("    >> [PDFDocument.print() 호출됨]");
		System.out.println("       [PDF 문서 출력]              ");
		System.out.println("    파일: " + fileName);	
		System.out.println("    (PDF 뷰어에서 인쇄 대화상자 열림)   ");
		System.out.println("    인쇄 품질: " + DEFAULT_DPI + " DPI");
	}
	
	@Override
	public int getPageCount() {
		return pageCount;
	}	
	
	
	// Getter method
	public String getFileName() {
		return fileName;
	}

	public String getContent() {
		return content;
	}	
}


/*
 *  Memo 클래스: 간단한 메모
 *  	- 메모는 항상 1페이지이므로 getpageCount()는 항상 1을 반환
 */
class Memo implements Printable{
	// Field
	private String content;		// 메모 내용
	
	// Constructor
	public Memo(String content) {
		//super();
		this.content = content;
	}

	@Override
	public void print() {
		System.out.println("    >> [Memo.print() 호출됨]");
		System.out.println("       [Memo 출력]              ");
		System.out.println("    " + content);
		System.out.println("    인쇄 품질: " + DEFAULT_DPI + " DPI");
	}

	@Override
	public int getPageCount() {
		return 1;		// 메모는 항상 1페이지
	}
	
	// class method
	public String getContent() {
		return content;
	} 	
}


/*
 * 	문서 관리자 클래스 (다형성 활용)
 */
class PrintManager {
	// Printable 타입의 배열을 생성하여 다양한 문서를 관리
	private Printable[] documents;
	private int count;
	
	
	
	public PrintManager(int capacity) {
		//super();
		documents = new Printable [capacity];
		count = 0;
	}
	
	/* 
	 *  문서를 추가한다
	 *  	- 매개변수가 Printable 타입
	 *  		--> Printable을 구현한 어떤 클래스의 객체를 받을 수 있음
	 *  
	 *  doc.getClass(): 객체의 실명 패키지어ㅏ==
	 */
	
	public void addDocument(Printable doc) {
		if(count < documents.length) {
			documents[count++] = doc;
			System.out.println("문서 추가됨: " + doc.getClass().getSimpleName());
		}
	}
	
	/*
	 * 	모든 문서를 출력함
	 * 		- 다형성
	 * 		- print()
	 */
	
	public void printAll() {
		int totalPages = 0;
		int cnt = 0;
		System.out.println("\n[모든 문서 출력]");
		System.out.println("-".repeat(50));
		
		for(Printable n : documents) {
			if(n!= null) {
				System.out.println();
				totalPages += n.getPageCount();
				System.out.println("▶ 문서 " + ++cnt + ": " + n.getClass().getSimpleName());
				n.print();
				System.out.println("-> 총 " + n.getPageCount() + "페이지");
			}
		}
		System.out.println();
		System.out.println("-".repeat(50));
		System.out.println("등록된 문서 수: " + cnt +"개");
		System.out.println("총 페이지 수: " + totalPages + "페이지");
	}
	
	
}



public class BasicInterface {
	public static void main(String[] args) {
		System.out.println("기본 인터페이스 - 문서 출력 시스템");
		
		// 테스트 1: 다양한 문서 생성
		System.out.println("\n▶ 테스트 1: 다양한 문서 생성");
		System.out.println("-------------------------");
		
		// 각 클래스의 생성자로 객체 생성
		WordDocument wordDoc = new WordDocument(
				"기획서",
				"프로젝트 기획 내용입니다. 이 문서는 새로운 서비스 권한을 위한 기획안입니다.",
				5);
		
		PDFDocument pdfDoc = new PDFDocument(
				"사용자메뉴얼.pdf",
				"프로그램 사용 방법 안내",
				20);
		
		Memo memo = new Memo("TODO: 내일까지 보고서 작성 완료하기");
		
		System.out.println("WordDocument 생성: " + wordDoc.getTitle());
		System.out.println("PDFDocument 생성: " + pdfDoc.getFileName());
		System.out.println("Memo 생성 완료");
		
		// 테스트 2: 개별 문서 출력 (직접 메서드 호출)
		System.out.println("\n▶ 테스트 2: 개별 문서 출력");
		System.out.println("-------------------------");
		
		System.out.println("[Word 문서]");
		wordDoc.print();
		System.out.println("페이지 수: " + wordDoc.getPageCount());
		System.out.println();
		
		System.out.println("[PDF 문서]");
		pdfDoc.print();
		System.out.println("페이지 수: " + pdfDoc.getPageCount());
		System.out.println();
		
		System.out.println("[Memo]");
		memo.print();
		System.out.println("페이지 수: " + memo.getPageCount());
		System.out.println();
		
		// 테스트 3: 인터페이스 타입으로 참조 (업캐스팅)
		/*
		 * 	인터페이스 타입 변수에 구현 클래스 객체를 대입
		 * 		-> 업캐스팅: 자식 타입 -> 부모(인터페이스) 타입
		 */
		System.out.println("\n▶ 테스트 3: 인터페이스 타입으로 참조 (업캐스팅)");
		System.out.println("-------------------------------------");
		Printable p1 = wordDoc;		// WordDocument -> Printable (업캐스팅)
		Printable p2 = wordDoc;		// PDFDocument -> Printable (업캐스팅)
		Printable p3 = wordDoc;		// Memo -> Printable (업캐스팅)
		
		System.out.println("\n -> 인터페이스 타입으로 메서드 호출");
		System.out.println("p1.getPageCount() = " + p1.getPageCount() + "페이지 (Word)");
		
		System.out.println("\n -> 인터페이스 타입으로 메서드 호출");
		System.out.println("p2.getPageCount() = " + p2.getPageCount() + "페이지 (PDF)");
		
		System.out.println("\n -> 인터페이스 타입으로 메서드 호출");
		System.out.println("p3.getPageCount() = " + p3.getPageCount() + "페이지 (Memo)");
		
		
		// 테스트 4: 인터페이스 타입 배열로 다형성활용
		System.out.println("\n▶ 테스트 4: 인터페이스 타입 배열로 다형성활용");
		System.out.println("----------------------------------");
		
		// Printable 타입 배열에 다양한 문서 저장
		Printable[] documents = {wordDoc, pdfDoc, memo};
		
		int totalPages = 0; 		// 페이지 수의 합계를 저장
		for(Printable n : documents) {
			totalPages += n.getPageCount();
			System.out.println("[" + n.getClass().getSimpleName() + "]");
		}
		
		System.out.println("\n-> 총 페이지 수: " + totalPages + "페이지");
		
		// 테스트 5: PrintManager로 문서 관리
		System.out.println("\n▶ 테스트 5: PrintManger로 문서 관리");
		System.out.println("----------------------------------");
		
		PrintManager manager = new PrintManager(10);
		
		// 다양한 문서 추가 (모두 Printable 타입으로 받음)
		manager.addDocument(new WordDocument("보고서", "분기별 실적 보고서 내용입니다.", 10));
		manager.addDocument(new PDFDocument("계약서.pdf", "계약 내용", 3));
		manager.addDocument(new Memo("회의 내용: 다음 주 월요일 10시 미팅"));
		manager.addDocument(new WordDocument("제안서", "신규 프로젝트 내용입니다.", 15));
		
		// 모든 문서 출력
		manager.printAll();
		
		// 테스트 6: instanceof로 타입 확인
		System.out.println("\n▶ 테스트 6: instanceof로 타입 확인");
		System.out.println("----------------------------------");
		
		// 다형성: 하나의 타입(Printable)으로 여러 구현체를 다룰 수 있음
		Printable[] docs = {wordDoc, pdfDoc, memo};
		
		
		for(Printable doc : docs) {
			if(doc instanceof WordDocument) {
				System.out.println("Word 문서 입니다 - 제목: " + ((WordDocument)doc).getTitle());
			}
			else if(doc instanceof PDFDocument) {
				System.out.println("PDF 문서 입니다 - 제목: " + ((PDFDocument)doc).getFileName());
			}
			else if(doc instanceof Memo) {
				System.out.println("메모 입니다 - 제목: " + ((Memo)doc).getContent());
			}
		}
		
	}
}
