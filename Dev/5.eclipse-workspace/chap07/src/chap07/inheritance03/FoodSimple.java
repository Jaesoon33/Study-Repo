package chap07.inheritance03;

class Food {
	String name;
	int price;
	
	public Food(String name, int price) {
		//super();
		this.name = name;
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String describe() {
		return name;
	}
	
	public void printInfo() {
		System.out.println("--------------------");
		System.out.println(" " + describe());
		System.out.printf(" 가격: %,d원\n", getPrice());
		System.out.println("--------------------");
	}
}

class Beverage extends Food {
	String size;		// 사이즈: T, G, V
	boolean isIced;		// 아이스 여부
	
	public Beverage(String name, int price, String size, boolean isIced) {
		super(name, price);			// 부모 생성자 호출
		this.size = size;			// 음료 고유 필드 초기화
		this.isIced = isIced;
	}
	
	// 가격 계산 - 사이즈에 따라 추가 요금
	@Override
	public int getPrice() {
		int finalPrice = price;		// 기본가격
		
		// 사이즈 업 추가 요금
		if(size.equals("Grande")){
			finalPrice += 500;
		}
		else if(size.equals("Venti")) {
			finalPrice += 1000;
		}
		return finalPrice;
	}
	
	// 사이즈와 온도 정보 포함
	@Override
	public String describe() {
		String temp = isIced ? "아이스" : "따뜻한";
		return temp + " " + size + " " + name;
	}
	
}


/*
 * 	Dessert 클래스 - Food 상속 (is-a relation)
 */

class Dessert extends Food{
	// 고유 필드 - 디저트만의 속성
	String topping;			// 토핑 이름: " "(없음), "생크림", "초콜릿" 등 (+1000원)
	boolean isGiftBox;		// 선물 포장 여부: (+1500)
	
	// 생성자 - 디저트 객체 초기화
	public Dessert(String name, int price, String topping, boolean isGiftBox) {
		super(name, price);
		this.topping = topping;
		this.isGiftBox = isGiftBox;
	}
	
	// 토핑과 선물 포장에 따른 추가 요금 계산 
	@Override
	public int getPrice() {
		int finalPrice = price;

		if(!topping.equals("")) {		// 토핑 추가
			finalPrice += 1000;
		}
		
		if(isGiftBox) {
			finalPrice += 1500;			// 선물용 포장
		}
		
		return finalPrice;
	}
	
	// 토픽과 포장정보 포함
	@Override
	public String describe() {
		String desc = "";
		
		if(!topping.equals("")) {		// 토핑 추가
			desc += topping + " 추가 ";
		}
		
		desc += name;
		
		if(isGiftBox) {
			desc += "(선물포장)";	// 선물용 포장
		}
		
		return desc;
	}
}


/*
 * 	Food를 상속하는 메인 요리 클래스 (is-a: 메인요리는 음식이다) 
 */
class MainDish extends Food{
	// 고유 필드 - 메인 요리만의 속성
	boolean includeSide;		// 세트 메뉴 여부: 사이드(감자튀김, 음료 등) 포함 시 + 2000원
	int spicyLevel;				// 맵기 정도: 0-순한맛, 1-보통맛, 2-매운맛
	
	// 생성자 - 메인요리 객체 초기화
	public MainDish(String name, int price, boolean includeSide, int spicyLevel) {
		super(name, price);
		this.includeSide = includeSide;
		this.spicyLevel = spicyLevel;
	}
	
	@Override
	public String describe() {
		String desc = "";
		
		switch(spicyLevel){
		case 1: {desc += "✭ ";
				break;}
		case 2: {desc += "✭✭ ";
				break;}
		default:
		}
		
		desc += name;
		
		if(includeSide)
			desc += " 세트";
		
		return desc;
	}
	
	@Override
	public int getPrice() {
		if(includeSide)
			price += 2000;
		return price;
	}
	
	@Override
	public void printInfo() {
		System.out.println(" " + describe());
		System.out.printf(" 가격: %,d원\n", getPrice());
	}
}

public class FoodSimple {
	public static void main(String[] args) {
		Beverage americano = new Beverage("아메리카노", 4500, "Tall", true);
		americano.printInfo();
		
		Beverage latte = new Beverage("카페라떼", 5000, "Grande", false);
		latte.printInfo();
		
		Beverage mocha = new Beverage("카페모카", 5500, "Venti", true);
		mocha.printInfo();
		
		System.out.println("--------------------");
		
		
		Food cheesecake = new Dessert("치즈 케이크", 6000, "", true);
		cheesecake.printInfo();
		
		Food tiramisu = new Dessert("티라미수", 7000, "생크림", true);
		tiramisu.printInfo();
		
		Food macaron = new Dessert("마카롱 세트", 5000, "초콜릿", false);
		macaron.printInfo();
		
		System.out.println("▶테스트: MainDish (메인요리)");
		System.out.println("--------------------------");
		
		Food burger = new MainDish("불고기 버거", 6500, false, 0);
		Food chicken = new MainDish("양념치킨", 18000, true, 2);
		Food bibimbap = new MainDish("비빔밥", 9000, true, 1);
		
		burger.printInfo();
		System.out.println();
		
		chicken.printInfo();
		System.out.println();
		
		bibimbap.printInfo();
	}
}


