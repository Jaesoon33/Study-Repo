package chap09.nested02;


/* 
 * 주문처리 클래스
 * 	- 중첩 인터페이스를 포함하고 있음
 */
public class Order {

	public interface OnOrderListener{
		void onOrderComplete(String orderId, int totalprice);
		void onOrderCanceled(String orderId);
	}
	
	/*
	 * 	콜백을 받을 객체를 저장하는 필드
	 */
	private OnOrderListener listener;
	
	/*
	 * 	외부에서 리스너(콜백 받을 객체)를 등록하는 메서드
	 */
	public void setOnOrderListener(OnOrderListener listener) {
		this.listener = listener;
	}
	
	
	
	public void cancelOrder(String orderID)
	
	
	
}

	