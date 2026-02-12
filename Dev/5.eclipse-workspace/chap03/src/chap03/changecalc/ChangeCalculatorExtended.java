package chap03.changecalc;

import java.util.Scanner;


/*
 * 	거스름돈 계산기
 * 		- 문제: 거스름돈을 최소 개수의 지폐/동전으로 구성하기
 * 		
 * 		- 예시: 거슬므돈 2,660원을 거슬러줄 때
 * 			- 방법1: 1,000원 * 2 + 500원 * 1 + 100원 * 1 + 50원 * 1 + 10원 * 1 = 6개(최적!)
 * 			- 방법2: 500원 * 5 + 100원 * 1 + 50원 * 1 + 10원 * 1 = 8개
 * 			- 방법3: 100원 * 26 + 50원 * 1 + 10원 * 1 = 28개
 * 		
 * 		- solution: Greedy Algorithm(탐욕 알고리즘) 적용
 * 			- 큰 단위부터 최대한 사용하면 최소 개수로 거슬러줄 수 있음
 * 			- 단, 한국 화ㅠ
 *
 */ 
public class ChangeCalculatorExtended {
	public static void main(String[] args) {
		Scanner scanner;
		scanner = new Scanner(System.in);
		
		System.out.println("=== 거스름돈 계산 (확장 버전) ===\n");
		
		System.out.print("물건 가격을 입력하세요 (원): ");
		while(!scanner.hasNextInt()) {
			scanner.next();	// 잘못 입력된 스트림 초기화
			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
		}
		int price = scanner.nextInt();
		
		System.out.print("지불 금액을 입력하세요 (원): ");
		while(!scanner.hasNextInt()) {
			scanner.next();	// 잘못 입력된 스트림 초기화
			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
		}
		int payment = scanner.nextInt();
		
		if(payment < price) {
			System.out.println("지불 금액이 부족합니다!");			
		}
		else {
			int change = payment - price;
			System.out.println("\n거스름돈 : " + change + "원");
			
			// 동전 계산 (Greedy Algorithm - 탐욕 알고리즘 적용)
			int tempChange = change;				// 거스름돈을 임시 변수에 할당
			int sum = 0;
						
			int coins50000 = tempChange / 50000;
			tempChange %= 50000;
			sum += coins50000;
			
			int coins10000 = tempChange / 10000;
			tempChange %= 10000;
			sum += coins10000;
			
			int coins5000 = tempChange / 5000;
			tempChange %= 5000;
			sum += coins5000;
			
			int coins1000 = tempChange / 1000;		// 1000원권 개수 계싼
			tempChange %= 1000;	
			sum += coins1000;// 1000원권 처리 후 나머지
			
			int coins500 = tempChange / 500;		// 500원 계산
			tempChange %= 500;
			sum += coins500;
			
			int coins100 = tempChange / 100;		// 100원 계산
			tempChange %= 100;
			sum += coins100;
			
			int coins50 = tempChange / 50;			// 50원 계산
			tempChange %= 50;
			sum += coins50;
			
			int coins10 = tempChange / 10;			// 10원 계산
			sum += coins10;
			
			System.out.println("\n\n====== 거스름돈 구성 (최소 개수) ======");
			if(coins50000 > 0) System.out.println("50000원: " + coins50000 + "장");
			if(coins10000 > 0) System.out.println("10000원: " + coins10000 + "장");
			if(coins5000 > 0) System.out.println("5000원: " + coins5000 + "장");
			if(coins1000 > 0) System.out.println("1000원: " + coins1000 + "장");
			if(coins500 > 0) System.out.println("500원: " + coins500 + "개");
			if(coins100 > 0) System.out.println("100원: " + coins100 + "개");
			if(coins50 > 0) System.out.println("50원: " + coins50 + "개");
			if(coins10 > 0) System.out.println("10원: " + coins10 + "개");
			System.out.println("======================================");
			System.out.printf("총 %d개의 지폐/동전", sum);
		}
		
		
		
		System.out.println("\n\n\n프로그램을 종료합니다");
		scanner.close();
	}
}
