package chap05.enums;

import java.util.Scanner;


public class enumscannerLab {
	
	enum Day {
		SUNDAY, MONDAY, TUESDAY, WENDSEDAY, THURSDAY, FRIDAY, SATURDAY	// 요일 상수
	}

	enum MenuOption { // 계절을 나타내는 열거 타입
		VIEW_DAYS,		// 요일 정보 보기
		EXIT			// 종료
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("=== 열거형 기초 (Scanner 버전) ===");
		
		boolean running = true;		// 프로그램 실행 상태 (플래그/토글)
		while(running) {
			printMenu();
			System.out.print("선택: ");
			
			// 입력 검증 (숫자가 아닌 입력 처리)
			while(!scanner.hasNextInt()) {
				System.out.print("잘못된 입력입니다. 숫자를 입력하세요:");
				scanner.next();
			}
			int choice = scanner.nextInt();
			
			MenuOption selected = getMenuFromChoice(choice);
			
			if(selected == null) {
				System.out.println("잘못된 선택입니다. 0~1 사이의 숫자를 입력하세요.\n");
				continue;		// 입력이 잘못된 경우 다시 할당받음
			}
			
			switch(selected) {
				case VIEW_DAYS -> viewDaysInfo(scanner);	// 요일 정보 조회 메서드
				
				case EXIT -> {
					running = false;		// 루프 종료 조건
					System.out.println("프로그램을 종료합니다.");
					continue;
				}
			}
			
		}
		
		scanner.close();
	}

	private static void viewDaysInfo(Scanner scanner) {
		System.out.println("--- 요일 정보 ---");
		
		String[] businessHours = {"휴무", "09:00-18:00",
								  "09:00-18:00", "09:00-18:00", "09:00-18:00", "09:00-18:00", "10:00-15:00"};
		
		System.out.println("\n[영업시간 안내]");
		Day[] allDays = Day.values(); // values를 통해 모든 enum의 값들을 배열로 가져옴
		for(int i = 0; i < allDays.length; i++) {
			// switch로 평일/주말 구분
			String type = switch(allDays[i]) {
				case SATURDAY, SUNDAY -> "(주말)";
				default -> "(평일)";
			};
			System.out.printf("   %s %s: %s%n", allDays[i].toString(), type, businessHours[i] );
		}
		
		// 사용자 입력 받기 - 올바른 요일을 입력
		Day day = null;
		while(day == null) {
			System.out.print("\n요일을 입력하세요 (예: MONDAY): ");
			String input = scanner.next().toUpperCase();
			
			try {
				day = Day.valueOf(input);	// 문자열 --> Enum으로 변환 ("MONDAY" --> Day.MONDAY(열거형으로 반환함))
			}
			catch(IllegalArgumentException e) {
				System.out.println("잘못된 요일입니다. 영문 요일명을 정확히 입력하세요.");
				System.out.println("예: SUNDAY, MONDAY, TUESDAY, WENDSEDAY, THURSDAY, FRIDAY, SATURDAY");
			}	
		}
		System.out.println("입력한 요일: " + day);
		
		Day[] days = Day.values();
		int nextIndex = (day.ordinal() + 1) % days.length;		// 입력한 요일 바로 다음 날 저장
		Day nextDay = days[nextIndex];
		System.out.println("다음 요일: " + nextDay);
		
		String dayType = switch(day) {
			case SATURDAY, SUNDAY -> "주말";
			default -> "평일";
		};
		
		System.out.println("유형: " + dayType);
				
	}

	private static MenuOption getMenuFromChoice(int choice) {
		// switch 표현식으로 숫자를 Enum으로 매핑
		return switch(choice) {
			case 0 -> MenuOption.EXIT;
			case 1 -> MenuOption.VIEW_DAYS;
			default -> null;		// 유효하지 않은 선택 -> null 반환
		};
	}

	private static void printMenu() {
		System.out.println("\n=========== 메뉴 ===========");
		System.out.println("1. 요일 정보 보기");
		System.out.println("0. 종료");
	}
}
