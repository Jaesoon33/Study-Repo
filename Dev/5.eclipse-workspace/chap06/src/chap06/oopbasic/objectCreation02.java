package chap06.oopbasic;



class Product {
	String name;
	int price;
	int stock;	// 재고 수량
	
	
	/*
	 * 	if (stock >= quantity){		// sell available case
	 * 	// 판매 성공 처리
	 * 	}
	 * 	else {
	 * 	// 판매 실패 처리
	 * 	}
	 */
	boolean sell(int quantity) {
		if(stock >= quantity) {
			stock -= quantity;
			System.out.printf("%s %d개 판매! 총 %,d원 (남은 재고: %d개)\n", name, quantity, quantity * price, stock);
			return true;
		}
		else {
			System.out.printf("재고가 부족합니다. (요청: %d, 재고 %d)\n", quantity, stock);
			return false;
		}
		
	}
	
	void restock(int quantity) {
		stock += quantity;
		System.out.printf("마우스 %d개 입고! (총 재고: %d개)\n", quantity, stock);
	}
	
	void displayInfo() {
		System.out.printf("%-10s %,10d원     재고: %d개\n", name, price, stock);
	}
	
	void titleDisplayInfo() {
		System.out.println("\n========= 상품 목록 ========");
		System.out.println("상품명             가격            재고");
	}
	 
}




public class objectCreation02 {
	public static void main(String[] args) {
		
		System.out.println("--- 1. 상품 관리 시스템 ---\n");
		
		// 상품 배열 생성 및 초기화
		Product[] products = new Product[4];
		
		products[0] = new Product();
		products[0].name = "노트북";
		products[0].price = 1500000;
		products[0].stock = 10;
		
		products[1] = new Product();
		products[1].name = "키보드";
		products[1].price = 150000;
		products[1].stock = 25;
		
		products[2] = new Product();
		products[2].name = "마우스";
		products[2].price = 50000;
		products[2].stock = 50;
		
		products[3] = new Product();
		products[3].name = "모니터";
		products[3].price = 350000;
		products[3].stock = 15;
		
		products[0].titleDisplayInfo();
		System.out.println("---------------------------------------");
		for(Product prod: products) {
			prod.displayInfo();
		}
		
		System.out.println("\n===== 판매 시뮬레이션 =====");
		products[0].sell(3);
		products[1].sell(10);
		products[2].sell(100);
		System.out.println();
		
		System.out.println("===== 입고 처리 =====");
		products[2].restock(100);
		products[2].sell(50);		
		System.out.println();
		
		System.out.println("===== 재고 현황 =====");
		int total_price = 0;
		
		for(Product prod: products) {
			prod.displayInfo();
			total_price += prod.stock * prod.price;
		}
		System.out.println("---------------------------------------");
		
		
		System.out.printf("총 재고 금액: %,d원", total_price);
	}
}
