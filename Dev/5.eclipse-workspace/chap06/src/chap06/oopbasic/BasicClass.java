package chap06.oopbasic;

/*
 *	Person Class - 사람의 정보와 행동을 표현
 *	 클래스 구조
 *		 - 필드 (Fields): 객체의 상태/데이터
 *			- 무엇을 가지고 있는가? (명사)
 *		 - 메서드 (Mehod): 객체의 행동/기능
 *			- 무엇을 할 수 있는가? (동사) 
 */
class Person{
	String name;
	int age;
	String gender;
	String occupation;
	
	/*
	 *  자기소개 - introduce()
	 *  		 반환타입: void (반환값 없음, 출력만 함)
	 *  		 파라미터: 없음
	 *  		 동작: 자신의 자신의 필드 값들을 출력
	 */
	void introduce() {
		System.out.println("=== 자기 소개 ===");
		System.out.println("이름: " + name);
		System.out.println("나이: " + age + "세");
		System.out.println("성별: " + gender);
		System.out.println("직업: " + occupation);
	}
	
	/*
	 * 인사하기: greet(String otherName);
	 * 		  - 반환타입: void
	 * 		  - 파라미터: otherName (인사할 상대방 이름)
	 * 		  - 동작: 상대방에게 인사 메시지 출력
	 */
	void greet(String otherName) {
		System.out.println(name + ": 안녕하세요, " + otherName + "님!");
	}
	
	/*
	 * 	생일: haveBirthday()
	 * 				- 반환타입: void
	 * 				- 파라미터: none
	 * 				- 동작: age 필드를 1 증가시킴
	 * 				- 예시) 생일 축하합니다! 이순신님은 이제 26세 입니다.
	 */
	
	void haveBirthday() {
		System.out.println("생일 축하합니다! " + this.name + "님은 이제 " + (++this.age) + "세 입니다.");
	}
}

class SmartPhone {
	// 필드 정의
	String brand;
	String model;
	int batteryLevel;	// 배터리 잔량(10 ~ 100)
	boolean isOn;


	// 	메서드 정의
	// 	전원 켜기
	void powerOn() {
		if(!isOn) {
			isOn = true;
		System.out.println(this.brand + " " + model + " 전원이 켜졌습니다.");
		} else {
		System.out.println("이미 전원이 켜져 있습니다.");
		}
	}
	
	// 전원 끄기
	void powerOff() {
		if(isOn) {
			isOn = false;
		System.out.println(this.brand + " " + model + " 전원이 꺼졌습니다.");
		} else {
		System.out.println("이미 전원이 꺼져 있습니다.");
		}
	}
	
	/*
	 *  현재 상태 출력
	 */
	void displayStatus() {
		System.out.println("===스마트폰 정보===");
		System.out.println("브랜드: " + brand);
		System.out.println("모델:" + model);
		System.out.println("배터리:" + batteryLevel + "%");
		System.out.println("전원: " + (isOn ? "ON" : "OFF"));
	}
	/*
	 *  배터리 사용 - useBattery(int amount)
	 *  
	 *  	- 파라미터: amount - 사용량
	 *  	- 동작
	 *  		- 전원이 꺼져있으면 사용 불가
	 *  		- 배터리가 0 이하가 되면 자동으로 전원 꺼짐
	 *  	- 예시) 배터리 사용. 남은 배터리 30%
	 */
	void useBattery(int amount) {
		boolean power;
		// 1. 전원 체크
		if(isOn == false) {
			System.out.println("휴대전화가 꺼져 있습니다.");
			power = false;
		}
		else {
			power = true;
		}
		
		// 2. 배터리 감소 및 방전 확인
		if(power) {
			if(batteryLevel - amount > 0) {
				batteryLevel -= amount;
				System.out.println("배터리 사용. 남은 배터리: " + batteryLevel + "%");
			}
			else if(batteryLevel - amount < 0) {
				batteryLevel = 0;
				isOn = false;
				power = false;
				System.out.println("배터리가 방전되어 전원이 꺼졌습니다.");
			}
		}
		
		
	}
	/*
	 * 배터리 충전 - charge(int amount)
	 * 		- 파라미터: amount <-- 충전량
	 * 		- 동작: batteryLevel += amount (최대 100으로 제한)
	 * 		- 예시: 충전 완료! 배터리: 30%
	 */
	void charge(int amount){
		if(!isOn)
			isOn = true; 
		
		batteryLevel += amount;
		
		if(batteryLevel >=100) {
			batteryLevel = 100;	// 100% 초과 방지
			System.out.println("충전 완료! 배터리가 완충되었습니다. 배터리: 100%");
		}
		else {
			System.out.println("충전 완료! 배터리: " + batteryLevel + "%");
		}
	}
	
	
}
public class BasicClass {
	public static void main(String[] args) {
		/*
		 * 	Person 클래스 테스트
		 * 	 - 객체 생성 및 필드 설정 --> 메서드 호출
		 */
		
		// 1. 객체 생성
		Person person1 = new Person();
		
		// 2. 필드에 값 할당 (객체의 상태 설정)
		person1.name = "이순신";
		person1.age = 25;
		person1.gender = "남성";
		person1.occupation = "개발자";
		
		// 3. 메서드 호출
		person1.introduce();
		person1.greet("신사임당");
		person1.haveBirthday();
		
		System.out.println("---SmartPhone 클래스 테스트---\n");
		
		SmartPhone phone = new SmartPhone();
		phone.brand = "Samsung";
		phone.batteryLevel = 50;
		phone.model = "Galaxy S24";
		phone.isOn = false;
		
		phone.displayStatus();
		phone.powerOn();
		phone.powerOff();
		phone.powerOn();
		phone.useBattery(20);
		phone.useBattery(20);
		phone.useBattery(20);
		phone.displayStatus();
		phone.charge(20);
		phone.charge(20);
		phone.displayStatus();
		phone.charge(20);
		phone.charge(20);
		phone.charge(70);
		phone.displayStatus();
		phone.powerOff();
		phone.powerOn();
		phone.displayStatus();
		
	}
}
