package chap04.loop;

import java.util.Scanner;

public class forLab {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("--- 1. 1부터 N까지 출력 ---");
		System.out.print("N 값을 입력하세요: ");
		while(!scanner.hasNextInt()) {
			System.out.println("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		
		int n = scanner.nextInt();
		for(int i = 1; i <= n; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		System.out.println("--- 2. 합계 계산 ---");
		System.out.print("합계를 구할 범위의 시작값: ");
		while(!scanner.hasNextInt()) {
			System.out.println("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		int start = scanner.nextInt();
		
		System.out.print("합계를 구할 범위의 끝값: ");
		while(!scanner.hasNextInt()) {
			System.out.println("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		int end = scanner.nextInt();
		
		int sum = 0;
		for (int j = start; j <= end; j++)
			sum += j;
		System.out.printf("%d부터 %d까지의 합: %d", start, end, sum);
		
//		// 3. 구구단 출력
//		System.out.println("\n--- 3. 구구단 출력 ---");
//		System.out.print("몇 단을 출력할까요? (2-9): ");
//		while(!scanner.hasNextInt()) {
//			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
//			scanner.next();
//		}
//		int dan = scanner.nextInt();
//		
//		if(dan >= 2 && dan <= 9) {		// 2-9 범위인지 검사
//			System.out.println("\n\n=== " + dan + "단 ===");
//			for(int i = 1; i <= 9; i++) {
//				System.out.printf("%d * %d = %2d\n", dan, i, dan * i);
//			}
//		}
		
		
		
		
		
		
		System.out.println("\n--- 3-1. 구구단 출력 (재입력 버전) ---");
		System.out.print("몇 단을 출력할까요? (2-9): ");
		
		int dan2;
		
		while(true) {		// 단수 유효성 확인
			while(!scanner.hasNextInt()) {
				System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
				scanner.next();
			}
			dan2 = scanner.nextInt();
			
			
			while(!(dan2 >= 2 && dan2 <= 9)) {
				System.out.println("2에서 9 사이의 숫자를 입력하세요");
				System.out.print("몇 단을 출력할까요? (2-9): ");
				
				while(!scanner.hasNextInt()) {
					System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
					scanner.next();
				}
				dan2 = scanner.nextInt();
			}
			
			if(dan2 >= 2 && dan2 <=9)
				break;
		}			
	
		System.out.println("\n\n=== " + dan2 + "단 ===");
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %2d\n", dan2, i, dan2 * i);
		}
		
		
		/*
		 * 	4. 팩토리얼(Factorial) 계산
		 * 		1) n! = n * (n-1) * (n-2) * ... * 1
		 * 		2) 활용 사례
		 * 			- 추천 알고리즘 : 사용자에게 보여줄 상품 조합 계산
		 * 			- 통계/데이터 : 확률 계산
		 */
		
		System.out.println("\n--- 4. 팩토리얼(Factorial) 계산 ---");
		System.out.print("팩토리얼을 계산할 숫자 (0-20): ");
		while(!scanner.hasNextInt()) {
			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		
		int num = scanner.nextInt();
		
		if(num >= 0 && num <=20) {	// 0-20 범위인지 검사 (long 오버플로우 방지)
			long factorial = 1;
			for(int i = 1; i <= num; i++){
				factorial *= i;
			}
			System.out.println(num + "!= " + factorial);
			System.out.printf("%d!= %,d", num, factorial);
		}
		else
			System.out.println("0에서 20 사이의 숫자를 입력하세요.");
		
		
		
		
		
		// 4-1. 팩토리얼(Factorial) 계산 (올바른 값 입력까지 반복)
		System.out.println("\n--- 4-1. 팩토리얼 계산 (재입력 버전) ---");
		System.out.print("팩토리얼을 계산할 숫자 (0-20): ");

		int num2;
		
		while(true) {
			while(!scanner.hasNextInt()) {
				System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
				scanner.next();
			}
			num2 = scanner.nextInt();
			
			while(!(num2 >= 0 && num2 <=20)) {
				System.out.println("0에서 20 사이의 숫자를 입력하세요.");
				System.out.print("팩토리얼을 계산할 숫자 (0-20): ");
				while(!scanner.hasNextInt()) {
					System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
					scanner.next();
				}
				num2 = scanner.nextInt();
			}
			
			if((num2 >= 0 && num2 <=20))
				break;
		}
		
		if(num2 != 0) {
			long factorial2 = 1;
			for(int i = 1; i <= num; i++){
				factorial2 *= i;
		}
			System.out.println(num2 + "! = " + factorial2);
			System.out.printf("%d!= %,d", num2, factorial2);
		}
		else
			System.out.println(num2 + " != " + "1");
		
		
		
		
		
		
		
		
		
	
		scanner.close();
	}
}
