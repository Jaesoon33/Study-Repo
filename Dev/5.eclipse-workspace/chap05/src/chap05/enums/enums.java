package chap05.enums;



public class enums {
	enum Day {
		SUNDAY, MONDAY, TUESDAY, WENDSEDAY, THURSDAY, FRIDAY, SATURDAY	// 요일 상수
	}
	
	enum Season { // 계절을 나타내는 열거 타입
		SPRING, SUMMER, FALL, WINTER
	}
	
	
	enum Grade {
		A, B, C, D, F
	}
	
	enum Direction{
		NORTH, SOUTH, WEST, EAST
	}
	
	enum TrafficLight {
		RED, YELLOW, GREEN
	}
	
	enum Hand{
		ROCK, PAPER, SCISSORS
	}
	
	public static void main(String[] args) {
		// enum 변수 변경과 사용
		Day today = Day.MONDAY;		// Day 타입 변수에 Day.MONDAY 할당
		Season currentSeason = Season.WINTER;
		Grade myGrade = Grade.A;
		
		System.out.println("오늘: " + today);
		System.out.println("오늘 계절: " + currentSeason);
		System.out.println("내 성적: " + myGrade);
		
		
		// values() - 모든 상수 배열로 가져옴
		
		// valuOf() - 문자열과 일치하는 enum 상수 반환 (대소문자 구분)
		// 일치하는 상수가 없을 시 IllegalArgumentException 발생
		
		// switch 문과 함께 사용
		Day someday = Day.FRIDAY;
		Day[] allDays = Day.values();
		for(int i = 0; i < allDays.length; i++) {
			System.out.println(" " + allDays[i]);
		}
		
		// 일반적인 switch
		String dayType;
		switch(someday) {
			case MONDAY:
			case TUESDAY:
			case WENDSEDAY:
			case THURSDAY:
			case FRIDAY:
				dayType = "평일";
				break;
			case SATURDAY:
			case SUNDAY:
				dayType = "주말";
				break;
			default:
				dayType = "알 수 없음";
		}
		System.out.println(someday + "은(는) " + dayType + "입니다.");
		
		// switch 표현식 (더 간결함)
		String dayType2 = switch(someday) {
			case MONDAY, TUESDAY, WENDSEDAY, THURSDAY, FRIDAY -> "평일";
			case SATURDAY, SUNDAY -> "주말";
			default -> "알수 없음";
		};
		System.out.println(someday + "은(는) " + dayType2 + "입니다.");
		
		TrafficLight light = TrafficLight.RED;
		// 현재 신호에 따른 동작
		String action = switch(light) {
			case RED -> "정지하세요";
			case YELLOW -> "주의";
			case GREEN -> "진행";
		};
		System.out.println("현재 신호: " + light + " - " + action);
		
		System.out.println("\n--- 실습: 가위바위보 ---");
		
		Hand player = Hand.ROCK;		// 플레이어 선택: 바위
		Hand computer = Hand.SCISSORS;	// 컴퓨터 선택: 가위
		
		System.out.println("플레이어: " + player);
		System.out.println("컴퓨터: " + computer);
		
		// 승패 판정
		String result;
		if(player == computer) { // enum의 값을 비교하므로 equal 메소드 사용 x
			result = "무승부";			
		} else{
			// player = ROCK ==> computer는 SCISSORS 또는 PAPER만 가능
			result = switch(player) {
			case ROCK -> (computer == Hand.SCISSORS) ? "승리" : "패배";
			case PAPER -> (computer == Hand.ROCK) ? "승리" : "패배";
			case SCISSORS -> (computer == Hand.PAPER) ? "승리" : "패배";
			};
		}
		
		System.out.println("결과: " + result);
		
	}
	
}
