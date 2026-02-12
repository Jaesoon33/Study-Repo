package chap09.nested02;


public class Main {
	public static void main(String[] args) {
		Order order = new Order();
		
		// 리스너 등록(익명 객체 사용)
		OnOrderListener onorderListener;
		order.setOnOrderListener(new Order.onorderListener){
			System.out.println("[알림] 주문이 완료되었습니다.");
			System.out.println("  주문번호: " + orderId);
		};
		
		
		
		
		
		// 주문 처리 실행
		order.processOrder("ORD-2026-001", 150000);
		System.out.println();
		order.processOrder("ORD-2026-002", 150000);
		
		// 2. 다른 리스너로 교체하기
		System.out.println("\n===== 2. 다른 리스너로 교체하기 =====");
		
		// 리스너를 다르게 구현하면 다른 동작
		order.setOnOrderListener(new order.OnOrderListener() {
			
		
		// 할인된 가격 출력
		private static void printDiscountedPrice(Product product, disounter discounter) {
			int original = product.getBasePrice();
			int discounted = discounter.discount(original);
			int saved = original - discounted;
			
			System.out.println(" 원래 가격 : "+String.format("%,d원", original));
			System.out.println(" 할인 가격 : "+String.format("%,d원", discounted));
			System.out.println(" 절약 가격 : "+String.format("%,d원", saved));
		};
		
		
		public int discount(int price * 20 / 100);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
}
