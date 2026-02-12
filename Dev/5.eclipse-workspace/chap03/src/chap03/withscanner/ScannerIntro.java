package chap03.withscanner;
import java.util.Scanner;

public class ScannerIntro {
	public static void main(String[] args) {
		
//		// 1. Scanner 객체 생성
//		// System.in: 표준 입력(키보드)을 의미
		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("=== Scanner 기본 사용법 ===");
//		
////		// 2. 문자열 입력 받기
		System.out.print("이름을 입력하세요: ");
		String name = scanner.nextLine();
		System.out.println("안녕하세요, " + name + "님\n");
//		
//		// 3. 정수 입력받기 (입력 검증 포함)
//		System.out.print("나이를 입력하세요: ");
//		
//		while(!scanner.hasNextInt()) {
//			System.out.print("잘못된 입력입니다. 나이를 입력하세요: ");
//			scanner.next(); // 잘못된 입력 버리기
//			scanner.nextLine();
//		}
//		int age = scanner.nextInt();
//		System.out.println("입력한 나이 : " + age + "살\n");
//		
//		System.out.print("키를 입력하세요 (cm): ");
//		
//		/**
//		 *	hasNextInt(): 입력 버퍼에 있는 다음 토큰이 정수로 변환 가능한지 확인 (return : boolean value)
//		 *				  정수면 true, 아니면 false 반환
//		 *				  실제로 값을 읽지 않고 "미리 확인"만 함 (peek 동작)
//		 *
//		 *	while() 루프 동작 원리
//		 *	  1) hasNextInt()가 false면 --> 정수가 아님 --> 루프진입
//		 *	  2) 에러 메시지 출력
//		 *	  3) scanner.next()로 잘못 입력된 값을 버퍼에서 제거
//		 * 	  4) 다시 hasNextInt() 검사 반복
//		 * 	  5) hasNextInt()가 true면 --> 정수임\
//		 */
//		while(!scanner.hasNextDouble()) {
//			System.out.print("잘못된 입력입니다. 숫자를 입력하세요: ");
//			scanner.next(); // 잘못된 입력 버리기
//		}
//		int height = scanner.nextInt();
//		System.out.println("입력한 키 : " + height + "cm\n");
//		
//		
//		// 5. 여러 값 한 번에 입력받기 (입력 검증 포함)
//		System.out.println("=== 여러 값 입력받기 ===");
//		System.out.print("두 정수를 공백으로 구분하여 입력하세요: ");
//		
//		// 첫번 째 정수 검증
//		while(!scanner.hasNextInt()) {
//			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
//			scanner.next();
//		}
//		int num1 = scanner.nextInt();
//		
//		// 두번째 정수 거믖ㅇ
//		while(!scanner.hasNextInt()) {
//			System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
//			scanner.next();
//		}
//		int num2 = scanner.nextInt();
//		
//		System.out.println("입력된 값: " + num1 + "," + num2);
//		System.out.println("합계: "+(num1+num2)+"\n");
//	
//		// 6. nextLine()
//		// nextInt(), nextDouble() 후에 nextLine()을 사용할 때 --> 버퍼에 남은 엔터키를 처리해야함
//		scanner.nextLine();	// 버퍼 비우기 (이전 nextInt()의 엔터키 소비)
//		
//		System.out.println("=== nextLine() 버퍼 처리 ===");
//		System.out.print("좋아하는 음식을 입력하세요: ");
//		String food = scanner.nextLine();
//		System.out.println("좋아하는 음식: " + food + "\n");
		System.out.println("=== 자기소개 프로그램 ===");
		System.out.println("정보를 입력해주세요.");
		System.out.print("학번: ");
		int stdnum = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("학과: ");
		String major = scanner.nextLine();
		
		int classnum = 0; // 학년
		int cnt = 0; // 초기조건 확인용
		
		do {
			if(cnt == 0) {
				System.out.print("학년 (1~4): ");
				classnum = scanner.nextInt();
			}
				
			if(cnt != 0) {
				System.out.print("1~4 사이의 값을 입력하세요: ");
				scanner.nextLine();
				classnum = scanner.nextInt();
			}
			cnt ++;
		}while(classnum > 4 || classnum < 0);
		
		cnt = 0;
		float grade = 0;
		
		do {
			if(cnt == 0) {
				System.out.print("학점 (예: 3.5): ");
				grade = scanner.nextFloat();
			}
			if(cnt != 0) {
				System.out.print("0.0~4.5 사이의 값을 입력하세요: ");
				scanner.nextLine();
				grade = scanner.nextFloat();
			}
			cnt ++;
		}while(grade > 4.5 || grade < 0);
		cnt = 0;
		
		System.out.println("\n--- 입력한 정보 ----");
		System.out.println("이름: : " + name);
		System.out.println("학번: " + stdnum);
		System.out.println("학과: " + major);
		System.out.println("학년: " + classnum);
		System.out.println("학점: " + grade);

		/*
		 * 		while vs do-while문
		 * 		while문: 조건을 먼저 검사 후 block을 실행
		 * 		do-whilex
		 **/
		
		scanner.close();   	// 사용이 끝난 Scanner는 close()로 닫아주는 것이 좋은 습관(메모리 관리/ allocated -> free)
	}
}
