package chap10.exception02;


/*
 * 	try-resources 테스트를 위한 리소스 클래스
 * 	
 */
public class MyResource implements AutoCloseable {
	private String name;		// 리소스 이름 (어떤 리소스인지 구분용)

	public MyResource(String name) {
		//super();
		this.name = name;
		System.out.println("[" + name + "] 리소스 열림(생성)");
	}
	
	// 작업
	public void doWork() {
		System.out.println("[" + name + "] 작업 수행 중...");
	}
	
	// 예외가 발생하는 작업
	public void doWorkWithException() {
		System.out.println("[" + name + "] 작업 중 예외 발생!");
		throw new RuntimeException(name + " 작업 실패");
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("[" + name + "] 리소스 닫힘(close)");
	}
	
}
