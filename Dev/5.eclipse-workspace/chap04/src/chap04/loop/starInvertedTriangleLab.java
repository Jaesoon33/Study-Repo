package chap04.loop;

import java.util.Scanner;


public class starInvertedTriangleLab {
/*
 * 	2. 별 찍기 (역삼각형)
 * 		- 출력 결과 (height = 7)
 * 
 * 		*******
 * 		******
 * 		*****
 * 		****
 * 		***	
 * 		**
 * 		*
 * 
 * 		- 직각삼각형 vs 역 직각삼각형 비교
 * 			- 직각삼각형: i가 1부터 height까지 증가 --> 별 개수도 1개부터 증가
 * 			- 역 직각삼각형: i가 height부터 1까지 감소 --> 별 개수도 height개부터 감소
 * 			- 핵심 차이: for문의 초기값, 조건, 증감식
 * 				- 직각 삼각형: for(int i = 1; i <= height; i++)
 * 				- 역 직각 삼각형: for(int i = height; i > 0; i--)
 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int height;
		
		System.out.println("=== 별 찍기: 다양한 구현 방법 비교 ===\n");
		System.out.print("높이를 입력하세요: ");
		while(!scanner.hasNextInt()) {
			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		height = scanner.nextInt();
		
		
		
		System.out.println("\n--- 방법 1: 기본 중첩 for문(i 감소) ---");
		for(int i = height; i > 0; i--) {		
			for(int j = 0; j < i; j++)	{		
				System.out.print("*");
			}
			System.out.println();
		}
		
		/*
		 * 방법 2: 
		 * 		동작 원리 (height = 4 예시)
		 * 		i = 1: 별 개수 = 4 - 1 + 1 --> **** 출력
		 * 		i = 2: 별 개수 = 4 - 2 + 1 --> *** 출력
		 * 		...
		 */
		System.out.println("\n--- 방법 2: i 증가, 별 개수 계산 ---");
		for(int i = 1; i<= height; i++) {		// i = 1부터 height까지 증가
			for(int j = 1; j <= height - i + 1; j++)	// 별 개수 = height - i +1
				System.out.print("*");
			System.out.println();
		}
		
		
		
		// 방법 3: String의 repeat() 메서드 사용 (Java 11+)
		System.out.println("\n--- 방법 3: repeat() 메서드 사용 (Java 11+) ---");
		for(int i = height; i >= 1; i--) {
			System.out.println("*".repeat(i));
		}
		
		
		
		// 방법 4: StringBuilder 사용 (역순 출력)
		// 1. sb에 height개의 별을 할당하고
		// 2. 매 반복마다 마지막 문자(별)을 제거함
		
//		System.out.println("\n--- 방법 4: StringBuilder 사용 ---");
//		StringBuilder sb = new StringBuilder();
//		for(int i = height; i >= 1; i--) {
//			sb.append("*".repeat(i) + "\n");
//		}
//		System.out.println(sb);
		
		System.out.println("\n--- 방법 4: StringBuilder 사용 ---");  
		StringBuilder sb = new StringBuilder("*".repeat(height));                  
		for(int i = height; i >= 1; i--) {                       
			System.out.println(sb);
			if(sb.length() > 0)
				sb.deleteCharAt(sb.length()-1);
		}                                        
		
		
		// 방법 5: while문 사용
		System.out.println("\n--- 방법 5: while문 사용 ---");
		int i = height;
		
		while(i >= 1) {		// i가 1 이상인 동안 반복
			int j = 1;
			while(j <= i) {		// j가 i 이하인 동안 별을 출력
				System.out.print("*");
				j++;
			}
			System.out.println();
			i--;
		}
		
		
		
		scanner.close();
		
		
		
		
		
	}
}
