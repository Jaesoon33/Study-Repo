package chap04.conditional;



public class switchLab {
	public static void main(String[] args) {
		
		// 1. HTTP 메서드 처리
		System.out.println("[1. HTTP 메서드 처리]");
		
		String httpMethod = "POST";
		
		switch(httpMethod) {
			case "GET":
				System.out.println("데이터 조회");
				break;
			case "POST":
				System.out.println("데이터 생성");
				break;
			case "PUT":
				System.out.println("데이터 수정");
				break;
			case "DELETE":
				System.out.println("데이터 삭제");
				break;
			default:
				System.out.println("지원하지 않는 메서드");
		}
		
		System.out.println();
		
		// 2. switch 표현식 - 변수로 저장 가능 (화살표 문법 / Java 14+)
		System.out.println("[2. switch 표현식]");
		
		String memberGrade = "GOLD";
		
		int discount = switch(memberGrade) {
			case "VIP"	-> 15;
			case "GOLD" -> 10;
			case "SILVER" -> 5;
			default -> 0;
		};
		
		System.out.println(memberGrade + " 등급 할인율: " + discount + "%");
		
		System.out.println();
		
		// 3. switch online case (Java 14++)
		System.out.println("[3. 여러 case를 한 번에 (Java 14+)]");
		
		String day = "토요일";
		
		String dayType = switch(day) {
		case "월요일", "화요일", "수요일", "목요일", "금요일" -> "평일";
		case "토요일", "일요일" -> "주말";
		default -> "잘못된 입력";
		};
		System.out.println(day + " = " + dayType);
		
		System.out.println();
		
		// 4. yield 사용하기
		System.out.println("[4. yield 사용하기 (Java 14++)]");		
		
		String orderStatus = "SHIPPED";
		
		String statusMessage = switch(orderStatus) {
			case "PENDING" -> "결제 대기중 입니다.";
			case "PAID" -> "결제 완료! 배송 준비중 입니다.";
			// 복잡한 로직 예시
			case "SHIPPED" -> {
				String trackNumber = "TRACK-" + (int)(Math.random() * 100000);
				yield "배송중 입니다. 추적번호: " + trackNumber;
				} 
			case "DELIVERED" -> "배송이 완료되었습니다.";
			case "CANCELLED" -> "주문이 취소되었습니다.";
			default -> "알 수 없는 상태";
		};
		
		System.out.println(orderStatus + " -> " + statusMessage);
		
		System.out.println();
		
		// 5. HTTP 상태 코드 처리
		System.out.println("[5. HTTP 상태 코드 처리]");
		
		System.out.println("200: " + getStatusMessage(200));
		System.out.println("201: " + getStatusMessage(201));
		System.out.println("400: " + getStatusMessage(400));
		System.out.println("401: " + getStatusMessage(401));
		System.out.println("404: " + getStatusMessage(404));
		System.out.println("500: " + getStatusMessage(500));
		System.out.println("999: " + getStatusMessage(999));
		
		System.out.println();
		
		// 6. 간단한 계산기 구현
		System.out.println("[6. 간단한 계산기 구현]");
		
		int num1 = 10;
		int num2 = 0;
		String operator = "/";
		
		/*
		 * switch 표현식으로 계산기 구현
		 * 나눗셈은 0으로 나누는 경우 처리 필요
		 * 알 수 없는 연산자: "잘못된 연산자" 출력
		 */
		
		int result = switch(operator) {
		case "+" -> num1 + num2;
		case "-" -> num1 - num2;
		case "*" -> num1 * num2;
		case "/" -> {
			if(num2 == 0) {
				System.out.println(num2 +"으로는 나눌 수 없습니다.");
				yield 0;
			}
			yield (num1 / num2);
		}
		
		default ->{ System.out.println("잘못된 연산자: " + operator);
				yield 0;
			}
		};
		 
		if(num2 != 0)
			System.out.printf("%d %s %d = %d", num1, operator, num2, result);
	}

	private static String getStatusMessage(int statusCode) {
			return switch(statusCode) {
				case 200 -> "OK - 요청 성공";
				case 201 -> "Created - 리소스 생성됨";
				case 400 -> "Bad Request - 잘못된 요청";
				case 401 -> "Unauthorized - 인증 필요";
				case 403 -> "Forbidden - 접근 거부";
				case 404 -> "Not found  - 리소스 없음";
				case 500 -> "Internal Server error - 서버 오류";
				case 502, 503 -> "Server Unavailabe - 서버 접근 불가";
				default -> "Unknown Status: " + statusCode;
		};
	}
}
