package chap03. logicaloper;

import java.util.Scanner;

public class LoginSystemWithRetry {
	public static void main(String[] args) {
		System.out.println("=== 로그인 시스템 (재시도 버전) ===");
		System.out.println("\n# 로그인 시도는 최대 3회까지 가능합니다.");
		System.out.println("테스트용 계정 - 아이디: admin, 비밀번호: 1234");
		
		Scanner input = new Scanner(System.in);
		
		
		int trycount = 3;
		int count = 1;
		
		String setId = "admin";
		int setPw = 1234;
		
		
		String nowId;
		int nowPw;
		
		while(count <4){
			System.out.println("\n--- " + count + "번째 시도 ---");
			
			System.out.print("아이디: ");
			nowId = input.nextLine();
			System.out.print("비밀번호: " );
			nowPw = input.nextInt();
			
			boolean idmatch = nowId.equals(setId);
			boolean pwmatch = nowPw == setPw;
			
			
			if(idmatch == pwmatch) {
				System.out.println("\nV 로그인 성공! 환영합니다. " + nowId + "님!");
				break;
			}
			else {
				trycount --;
				if(trycount == 0) {
					System.out.println("\nX 로그인 실패!");
					System.out.println("	-> 비밀번호가 일치하지 않습니다.");
					System.out.println("\n\n* 로그인 시도 횟수를 초과했습니다!"
									 + "\n\n계정이 일시적으로 잠겼습니다."
									 + "\n관리자에게 문의하세요.");
					count = 5;
					break;
				}
					
				System.out.println("\nX 로그인 실패!");
				System.out.println("	-> 비밀번호가 일치하지 않습니다.");
				System.out.printf("	-> 남은 시도 횟수: %d회\n", trycount);
				System.out.println();
			}
				
			count++;
			input.nextLine();

		}
		System.out.println("\n프로그램을 종료합니다.");
		input.close();
		
}
}

