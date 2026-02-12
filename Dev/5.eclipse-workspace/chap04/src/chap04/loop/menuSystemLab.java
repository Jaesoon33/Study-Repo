package chap04.loop;

import java.util.Scanner;

/*
 * 	--- 간단한 메뉴 시스템 ---
 * 	=== ATM 메뉴 ===
 *  1. 잔액 조회
 *  2. 입금
 *  3. 출금
 *  0. 종료
 *  현재 잔액: 10000원
 *  
 *  === ATM 메뉴 ===
 *  1. 잔액 조회
 *  2. 입금
 *  3. 출금
 * 	0. 종료
 *  선택: 2
 *  입금액: 5000
 *  5000원이 입금되었습니다.
 *  현재 잔액: 15000원
 *  
 *  === ATM 메뉴 ===
 *  1. 잔액 조회
 *  2. 입금
 *  3. 출금
 *  0. 종료
 *  선택: 3
 *  출금액: 3000
 *  3000원이 출금되었습니다.
 *  현재 잔액: 12000원
 *  
 *  === ATM 메뉴 ===
 *  1. 잔액 조회
 *  2. 입금
 *  3. 출금
 *  0. 종료
 *  선택: 3
 *  출금액: 50000
 *  잔액이 부족합니다
 *  
 *  === ATM 메뉴 ===
 *  1. 잔액조회
 *  2. 입금
 *  3. 출금
 *  0. 종료
 *  선택: 0
 *  ATM을 종료합니다. 이용해주셔서 감사합니다.
 */
public class menuSystemLab {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("--- 간단한 메뉴 시스템 ---");
		
		int choice = 1;
		int balance = 10000;
		
		do {
			System.out.println("\n=== ATM 메뉴 ===");
			System.out.println("1. 잔액 조회");
			System.out.println("2. 입금");
			System.out.println("3. 출금");
			System.out.println("0. 종료");
			
			System.out.print("선택: ");
			while(!scanner.hasNextInt()) {
				System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
				scanner.next();
			}
			choice = scanner.nextInt();
			
			switch(choice) {
			case 0 -> System.out.println("ATM을 종료합니다. 이용해주셔서 감사합니다.");
			case 1 -> System.out.printf("현재 잔액: %,d원\n", balance);
			case 2 -> {
				System.out.print("입금액: ");
				while(!scanner.hasNextInt()) {
					System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
					scanner.next();
				}
				int deposite = scanner.nextInt();
				if(deposite > 0) {
					balance += deposite;
					System.out.printf("%,d원이 입금되었습니다.\n", deposite);
					System.out.printf("현재 잔액: %,d원\n", balance);
				}
				else
					System.out.println("올바른 금액을 입력하세요.");
			}
			case 3 -> {
				System.out.print("출금액: ");
				while(!scanner.hasNextInt()) {
					System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
					scanner.next();
				}
				int withdraw = scanner.nextInt();
				if(withdraw > 0 && withdraw <= balance) {
					balance -= withdraw;
					System.out.printf("%,d원이 출금되었습니다.\n", withdraw);
					System.out.printf("현재 잔액: %,d원\n", balance);
				}
				else if(withdraw > balance)
					System.out.println("잔액이 부족합니다.");
				else
					System.out.println("올바른 금액을 입력하세요.");
			}
			default -> System.out.println("잘못된 선택입니다.");
			}
			
		}while(choice != 0);
		
		
		
		
		scanner.close();
	}
}
