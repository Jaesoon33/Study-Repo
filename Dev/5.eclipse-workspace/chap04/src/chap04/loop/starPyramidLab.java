package chap04.loop;

import java.util.Scanner;



/*
 * 	3. 별 찍기 (피라미드)
 * 
 * 		- 출력 결과 (height = 5)
 * 
 * 				  ★			<-- 공백 4개 + 별 1개 
 * 				 ***		<-- 공백 3개 + 별 3개
 * 				*****		<-- 공백 2개 + 별 5개
 * 			   *******		<-- 공백 1개 + 별 7개
 *  		  *********		<-- 공백 0개 + 별 9개
 *		
 *		행(i)	왼쪽 공백		별 개수	 오른쪽 공백     총 너비
 *	   ---------------------------------------------------
 *		  1		  4개		  1개		4개			9개			
 *		  2		  3개		  3개		3개			9개
 *		  3		  2개		  5개		2개			9개
 *		  4		  1개		  7개		1개			9개
 *		  5 	  0개		  9개		0개			9개
 *
 *	- 핵심 공식
 *		- 왼쪽/오른쪽 공백 = height - i
 *		- 별 개수 = 2 * i - 1
 *		- 총 너비 = 2 * height - 1
 *
 *	- 참고
 *		- 콘솔 출력에서 오른쪽 공백은 보이지않으므로, 
 *		  실제 코드에서는 왼쪽 공백 + 별만 출력함
 */
public class starPyramidLab {
	public static void main(String[] args) {
		
		// 방법 1: 기본 중첩 (공백 + 별)
		Scanner scanner = new Scanner(System.in);
		
		int height;
		
		System.out.println("--- 방법 1: 기본 중첩 for문 ---");
		System.out.print("높이를 입력하세요: ");
		while(!scanner.hasNextInt()) {
			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
			scanner.next();
		}
		height = scanner.nextInt();
		
		for(int i = 1; i <= height; i++) {
			// 공백 출력: height - i 개
			for(int j = 1; j <= height - i; j++) {
				System.out.print(" ");
			}
			// 별 출력: 2 * i - 1개
			for(int k = 1; k <= 2 * i -1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		// 방법 2: String의 repeat() 메서드 사용 (Java 11+)
		System.out.println("\n\n--- 방법2: repeat() 메서드 사용 (Java 11+) ---");
		for(int i = 1; i <= height; i++) {
			String spaces = " ".repeat(height - i);
			String stars = "*".repeat(2 * i - 1);
			System.out.println(spaces + stars);
		}
		
		// 방법 3: StringBuilder 사용
		System.out.println("\n\n--- 방법3: StringBuilder 사용 ---");
		for(int i = 1; i <= height; i++) {
			StringBuilder sb = new StringBuilder();
			// 공백 추가
			for(int j = 1; j <= height - i; j++) {
				sb.append(" ");
			}
			// 별 추가
			for(int j = 1; j <= 2 * i -1; j++) {
				sb.append("*");
			}
			System.out.println(sb);
		}
		
		// 방법 4: printf 포맷 사용
		System.out.println("\n\n--- 방법4: printf 포맷 ---");
		for(int i = 1; i <= height; i++) {
			// 공백 추가
			String spaces2 = " ".repeat(2 * height - i);
			
			// 별 추가
			
			String stars2 = "*".repeat(2 * i -1);
			
			System.out.printf("%s%s%n", spaces2, stars2);
		}
		
		
		scanner.close();
	}
}