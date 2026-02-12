package chap06.oopbasic;


class Dog{
	String name;
	String breed;
	int age; 
	int energy;
	
	void bark() {
		System.out.println(name + ": 멍멍!");
	}
	
	void tailShake(String name1) {
		System.out.println(name + "이(가) " + name1 + "에게 꼬리를 흔듭니다!");
	}
	
	void displayInfo() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("이름: "+ name);
		System.out.println("품종: "+ breed);
		System.out.println("나이: "+ age + "살");
		System.out.println("에너지: " + energy + "/100");
	}
	
	void play() {
		if(energy >= 15) {
			energy -= 15;
			System.out.print(name + "이(가) 신나게 놀았습니다! ");
			System.out.print("에너지: " + energy + "\n");
			}
		else
			System.out.println(name + "은(가) 에너지가 부족해요. 먼저 밥을 주세요!");
	}
	
	void eat() {
		energy += 20;		
		// 100 초과방지
		if(energy > 100)
			energy = 100;
		System.out.print(name + "이(가) 밥을 먹엇습니다. ");
		System.out.print("에너지: " + energy + "\n");
	}
	
	void sleep() {
		energy = 100;
		System.out.println(name + "이(가) 푹 잤습니다. 에너지가 가득 찼어요"); 
	}
}

/*
 *  eat() 밥먹기
 *  	- 동작: 에너지 +20, 최대 100제한
 *  	- 에너지 회복 +20
 */

/*
 * play() - 놀기
 * 		- 동작: 에너지가 15이상이면 놀고, 부족하면 밥 먼저 달라고함조
 */


/*
 * sleep() - 자기
 * 	- 동작: 에니저를 100으로 완전 회복
 * 	- 에너지 회복: 100
 */

/*
 * greet(Dog other)
 */
public class objectCreation {
	public static void main(String[] args) {
		System.out.println("--- 1. 강아지 객체 관리 ---");
		System.out.println();
	
		Dog dog1 = new Dog();
		Dog dog2 = new Dog();
		Dog dog3 = new Dog();
		
		dog1.name = "초코";
		dog1.breed = "푸들";
		dog1.age  = 3;
		dog1.energy = 80;
		
		dog2.name = "뽀삐";
		dog2.breed = "시바견";
		dog2.age = 2;
		dog2.energy = 60;
		
		dog3.name = "맥스";
		dog3.breed = "리트리버";
		dog3.age = 5;
		dog3.energy = 30;
		
		System.out.println();
		
		dog1.displayInfo();
		dog2.displayInfo();
		dog3.displayInfo();
		System.out.println();
		
		dog1.play();
		dog2.bark();
		dog3.eat();
		dog3.play();
		System.out.println();
		
		System.out.println();
		dog1.tailShake(dog2.name);
		dog2.bark(); 
		
		System.out.println("dog 1 참조값: " + dog1);
		System.out.println("dog 2 참조값: " + dog2);
		System.out.println("dog 3 참조값: " + dog3);
		
		System.out.println("--- 2. 객체 배열 ---\n");
		
		// 객체 배열 생성 및 할당
		Dog[] dogs = new Dog[3];
		dogs[0] = dog1;
		dogs[1] = dog2;
		dogs[2] = dog3;
		System.out.println();
		
		System.out.println(dogs);
		for(int i = 0; i< dogs.length; i++)
			System.out.println(dogs[i]);
		System.out.println("모든 강아지에게 밥을 줍니다.");
		for(Dog dog : dogs) {
			dog.eat();
		}
		
		System.out.println();
		
		for(int i = 0; i < dogs.length; i++) {
			System.out.println("[" + (i + 1) + "] 번");
			dogs[i].displayInfo();
			System.out.println();
		}
	}
}
