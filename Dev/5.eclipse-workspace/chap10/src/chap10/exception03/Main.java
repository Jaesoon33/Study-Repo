package chap10.exception03;

import java.util.prefs.BackingStoreException;

/*
 * 	핵심 개념
 * 		- throw: 예외 객체를 직접 만들어서 발생시키기 (메소드 내부)
 * 		- throws: "이 메소드는 이런 예외를 던질 수 있다"고 선언 (메소드 시그니처)
 * 		- Checked exception: 컴파일러가 처리를 강제 (extends Exception)
 * 		- Unchecked exception: 처리를 강제하지 않음 (extends RuntimeException)
 * 		- 커스텀 exception: 비즈니스 의미가 담긴 예외 (추가 정보 포함 가능)
 */
public class Main {
	public static void main(String[] args) {
		// 1. 정상 흐름
		System.out.println("===== 1. 정상 흐름 =====");
		
		BankAccount account = new BankAccount("123-456", "이순신");
		System.out.println("계좌 생성: " + account.toString());		// 멤버 값을 출력하기 위해 toString을 오버라이딩함
		
		// 입금
		account.deposit(100000);		
		account.deposit(50000);
		System.out.println("현재 상태: " + account);
		
		// 출금
		try {
			account.withdraw(30000);
		} catch (InsufficientBalanceException e) {
			System.out.println(" 출금 실패 :" + e.getMessage());
		}
		System.out.println("현재 상태: " + account);
		System.out.println();
		
		// 2. 잔액 부족 (Checked 예외)
		System.out.println("===== 2. 잔액 부족 =====");

		try {
			account.withdraw(200000);
		} catch (InsufficientBalanceException e) {
			// 커스텀 예외의 장점: 추가 정보 조회
			//e.printStackTrace();
			System.out.println(" 출금 실패: " + e.getMessage());
			System.out.println(" 현재 잔액: " + e.getBalance());
			System.out.println(" 요청 금액: " + e.getAmount());
			System.out.println(" 부족 잔액: " + e.getShortfail());
			
		}
		System.out.println("현재 상태: " + account);
		System.out.println();
		
		// 3. 잘못된 계좌 번호 (Unchecked)
		System.out.println("===== 3. 잘못된 계좌 번호 (Unchecked) =====");
		
		// 3-1. 빈 계좌번호
		try {
			BankAccount bad1 = new BankAccount("", "신사임당");
		} catch(InvalidAccountException e) {
			System.out.println(" 생성 실패: " + e.getMessage());
		}
		
		// 3-2. 잘못된 형식 (정규식에 부합 X)
		try {
			BankAccount bad2 = new BankAccount("1234567", "이도");
		} catch(InvalidAccountException e) {
			System.out.println(" 생성 실패: " + e.getMessage());
		}
		
		// 3-3. null 소유자
		try {
			BankAccount bad3 = new BankAccount("123-456", null);
		} catch(InvalidAccountException e) {
			System.out.println(" 생성 실패: " + e.getMessage());
		}
		
		// 3-4. 음수 입금
		try {
			account.deposit(-50000);
		} catch(IllegalArgumentException e) {
			System.out.println(" 입금 실패: " + e.getMessage());
		}
		
		// 4. 계좌 이체
		System.out.println("===== 4. 계좌 이체 =====");
		BankAccount sender = new BankAccount("111-222", "송금자");
		BankAccount receiver = new BankAccount("333-444", "수취인");
		
		sender.deposit(200000);		// 20만원 입금
		try {
			sender.transfer(receiver, 80000);
		} catch (InsufficientBalanceException e) {
			System.out.printf(" 현재 잔액: %,d" , e.getBalance());
			System.out.printf(" 요청 금액: %,d" , e.getAmount());
			System.out.printf(" 부족 금액: %,d" , e.getShortfail());
			System.out.println();
		}
		System.out.println("    송금자: " + sender);
		System.out.println("    수취인: " + receiver);
		System.out.println();
		
		
		try {
			sender.transfer(receiver, 500000);
		} catch (InsufficientBalanceException e) {
			// 커스텀 예외의 장점: 추가 정보 조회
			//e.printStackTrace();
			System.out.printf(" 현재 잔액: %,d" , e.getBalance());
			System.out.printf(" 요청 금액: %,d" , e.getAmount());
			System.out.printf(" 부족 금액: %,d" , e.getShortfail());
			System.out.println();
		}
		
		System.out.printf("    송금자 잔액 (변동 없음): %,d\n" , sender.getBalance());
		System.out.printf("    수취인 잔액 (변동 없음): %,d\n" , receiver.getBalance());
		System.out.println();	
	}
}
