package chap04.loop;

import java.util.Scanner;

/*
 * 	목표: do-while 메뉴 시스템과 배열을 활용한 CRUD(Create, Read, Update, Delete)
 * 		- 배열로 데이터 저장 및 관리
 * 		- switch문으로 메뉴 분기 관리
 * 
 * 	출력 예시 (최대 10까지 저장 가능)
 *  === Todo 메뉴 ===
 *  1. 할 일 추가
 *  2. 목록 조회
 *  3. 완료 표시
 *  4. 할 일 삭제
 *  0. 종료
 *  선택: 1
 *  할 일 입력: 자바 공부하기
 *  "자바 공부하기"가 추가되었습니다.
 *  
 *  === Todo 메뉴 ===
 *  1. 할 일 추가
 *  2. 목록 조회
 *  3. 완료 표시
 *  4. 할 일 삭제
 *  0. 종료
 *  선택: 1
 *  할 일 입력: 알고리즘 문제 풀기
 *  "알고리즘 문제 풀기"가 추가되었습니다.
 *  
 *  === Todo 메뉴 ===
 *  1. 할 일 추가
 *  2. 목록 조회
 *  3. 완료 표시
 *  4. 할 일 삭제
 *  0. 종료
 *  선택: 2
 *  
 *   === 할 일 목록 (2개) ===
 *   1. [ ] 자바 공부하기
 *   2. [ ] 알고리즘 문제
 *  
 *  === Todo 메뉴 ===
 *  1. 할 일 추가
 *  2. 목록 조회
 *  3. 완료 표시
 *  4. 할 일 삭제
 *  0. 종료
 *  선택: 3
 *  완료할 항목 번호: 1
 *  "자바 공부하기"를 완료했습니다.
 *  
 *  === Todo 메뉴 ===
 *  1. 할 일 추가
 *  2. 목록 조회
 *  3. 완료 표시
 *  4. 할 일 삭제
 *  0. 종료
 *  선택: 2
 *  
 *  === 할 일 목록 (2개) ===
 *   1. [V] 자바 공부하기
 *   2. [ ] 알고리즘 문제
 *   
 *   === Todo 메뉴 ===
 *  1. 할 일 추가
 *  2. 목록 조회
 *  3. 완료 표시
 *  4. 할 일 삭제
 *  0. 종료
 *  선택: 4
 *  삭제할 항목 번호: 1
 *  
 *   === Todo 메뉴 ===
 *  1. 할 일 추가
 *  2. 목록 조회
 *  3. 완료 표시
 *  4. 할 일 삭제
 *  0. 종료
 *  선택: 2
 *  
 *  === 할 일 목록 (2개) ===
 *   1. [ ] 알고리즘 문제
 *   
 *  === Todo 메뉴 ===
 *  1. 할 일 추가
 *  2. 목록 조회
 *  3. 완료 표시
 *  4. 할 일 삭제
 *  0. 종료
 *  선택: 0
 *  프로그램을 종료합니다. 오늘도 수고하셨습니다.
 */
public class toDoListLab {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("--- 할 일 목록 관리 시스템 ---");
		System.out.println("할 일을 추가하고, 완료 표시하고, 삭제할 수 있습니다.");
		System.out.println("(최대 10개까지 저장가능)\n");
		
		final int MAX_SIZE = 10;			  // 최대 저장 가능 개수
		String[] todos = new String[MAX_SIZE];
		boolean[] completed = new boolean[MAX_SIZE];		// 완료 여부 저장 boolean의 기본값: false
		int count = 0;		// 현재 저장된 할 일 개수 
		int choice = 0; // 프로그램 선택자
		
		do {
			System.out.println("\n=== Todo 메뉴 ===");
			System.out.println("1. 할 일 추가");
			System.out.println("2. 목록 조회");
			System.out.println("3. 완료표시");
			System.out.println("4. 할 일 삭제");
			System.out.println("0. 종료");
			
			System.out.print("선택: ");
			while(!scanner.hasNextInt()) {
				System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
				scanner.next();
			}
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			case 0 -> {System.out.println("\n프로그램을 종료합니다. 오늘도 수고하셨습니다");
			
				}
			case 1 -> {
				System.out.print("할 일 입력: ");
				String todo = scanner.nextLine();
				if(count >= 10) {
					System.out.println("할 일은 최대 10개까지 저장가능 합니다.");
					break;
				}
				else {
					for(int i = 0; i < todos.length; i++) {
						if( null == todos[i]) {
							todos[i] = todo;
							completed[i] = false;
							count ++;
							System.out.printf("%s가 추가되었습니다.\n", todos[i]);
							break;
						}
					}
				}
			}
			case 2 -> {
				System.out.printf("\n\n=== 할 일 목록 (%d개) ===", count);
				for(int j = 0; j < todos.length; j++) {
					if(todos[j] != null) {
					System.out.printf("\n%d. [%s] %s", j+1 ,completed[j] == false ? " " : "V", todos[j]);
					}
				}
				System.out.println();
			}
			case 3 -> {
				System.out.print("완료할 항목 번호: ");
				int comNum = scanner.nextInt();
				completed[comNum-1] = true;
			}
			case 4 -> {
				System.out.print("삭제할 항목 번호: ");
				int delNum = scanner.nextInt();
				if(delNum == count) {
					todos[count-1] = null;
					completed[count-1] = false;
					count --;
				}
				else {
					for(int k = delNum-1; k <= count-1; k++) {
						if(k != count) {
							if(k != 9) {
								todos[k] = todos[k + 1];
								completed[k] = completed[k + 1];
							}
							else {
								todos[k] = null;
								completed[k] = false;
								break;
							}
								
						}
						else {
							todos[k] = null;
							completed[k] = false;
						}
					}
					count --;
				}
			}
		}
		}while(choice != 0);
		scanner.close();
	}
}
