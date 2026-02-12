package chap03.operators;

import java.util.Scanner;

public class ArithmeticOpsScanner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=== 산술 연산자 연습 ===");
		System.out.print("--- 기본 산술 연산 ---");
		System.out.print("\n첫번째 정수를 입력하세요: ");
		
		while(! scanner.hasNextInt()) {
			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		int a = scanner.nextInt();
		
		
		System.out.print("두번째 정수를 입력하세요: ");
		while(! scanner.hasNextInt()) {
			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		int b = scanner.nextInt();
		
		System.out.println("\n계산 결과: ");
		System.out.println(a+" + "+b+" = "+(a+b));
		System.out.println(a+" - "+b+" = "+(a-b));
		System.out.println(a+" * "+b+" = "+(a*b));
		
		if(b == 0) 
			System.out.println("0으로 나눌 수 없습니다.");
		else {
			System.out.println(a+" / "+b+" = "+(a/b) + " (정수 나숫셈)");
			System.out.println(a+" % "+b+" = "+(a%b) + " (나머지)");
			System.out.printf("%.1f / %.1f = %.4f (실수 나눗셈)", (double)a , (double)b, (double)a/b);
		}

		
		
		scanner.close();
		System.out.println("\n프로그램을 종료합니다.");
		
	}
}
