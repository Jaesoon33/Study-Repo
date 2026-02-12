package chap04.loop;

import java.util.Scanner;

/*
 * 	1. 직각삼각형
 * 		- 출력 결과 (height = 7)
 * 		*
 * 		**
 * 		***
 * 		****
 * 		*****
 * 		******
 * 		*******
 */

public class starPrintLab {
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
		
		System.out.println("\n--- 방법 1: 기본 중첩 for문 ---");
		for(int i = 1; i <= height; i++) {		// i = 현재 행 번호 (1행, 2행,,,)
			for(int j = 1; j <= i; j++)	{		// 각 행마다 i 개의 별 출력
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("\n--- 방법 2: 0부터 시작하는 인덱스 ---");
		for(int i = 0; i <= height - 1; i++) {		// i = 현재 행 번호 (1행, 2행,,,)
			for(int j = 0; j <= i; j++)	{		// 각 행마다 i 개의 별 출력
				System.out.print("*");
			}
			System.out.println();
		}
		
		// 방법 3: String의 repeat() 메서드 사용 (Java 11+) 
		System.out.println("\n--- 방법 3: repeat() 메서드 사용 (Java 11+) ---");
		for(int i = 1; i <= height; i++) {
			System.out.println("*".repeat(i));
		}
		
		// 방법 4: StringBuilder 사용 (가장 효율적)
		System.out.println("\n--- 방법 4: StringBuilder 사용 (가장 효율적) ---");
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= height; i++) {
			sb.append("*".repeat(i)+"\n");
		}
		System.out.println(sb);
		
		// 방법 5: while 문 사용
		System.out.println("\n--- 방법 5: while문 ---");
		int i = 0;
		
		while(i < height) {
			int j = 0;
			while(j <= i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			
			i++;	
		}
		
		System.out.println("\n프로그램을 종료합니다.");
		scanner.close();
	}
}
