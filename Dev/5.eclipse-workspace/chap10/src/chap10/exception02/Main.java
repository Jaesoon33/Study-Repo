package chap10.exception02;

public class Main {
	public static void main(String[] args) {
		// 5. try-with-resources
		/*
		 * 	AutoCloseable 인터페이스를 구현한 객체는 try()안에 선언하면
		 * 	자동으로 close() 호출됨
		 * 
		 * 	MyResource는 AutoCloseable을 구현함
		 *    - try 블록이 끝나면 (정상 종료든 예외든) 자동으로 close() 호출
		 */
		
		System.out.println("\n==== 5. try-with-resources ====");
		System.out.println("[정상 흐름]");
		try(MyResource resource = new MyResource("DB 연결")){
			resource.doWork();
		}catch(Exception e) {
			System.out.println(" 오류: " + e.getMessage());
		}
		
		System.out.println();
		
		// 예외 발생 시에도 close() 호출 됨
		System.out.println("[에외 발생 시에도 close() 호출됨]");
		try(MyResource resource = new MyResource("파일")){
			resource.doWorkWithException(); // 인위적으로 예외 발생
		} catch(Exception e) {
			System.out.println(" 오류처리: " + e.getMessage());
		}
		System.out.println();
		
		// 여러 리소스 (역순으로 close)
		System.out.println("[여러 리소스 (역순으로 close)]");
		try(MyResource r1 = new MyResource("리소스1");
			MyResource r2 = new MyResource("리소스2");
			MyResource r3 = new MyResource("리소스3");){
			System.out.println("작업 수행 중...");
			// r1,r2,r3는 stack 구조로 close 순서는 r3 -> r2 -> r1이 된다.
			// nested 구조에서 가장 나중에 열린 리소스가 먼저 닫혀야 안전함 (stack)
		} catch(Exception e) {
			
		}
	}
}
