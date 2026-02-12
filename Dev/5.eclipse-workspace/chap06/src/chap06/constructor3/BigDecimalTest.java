package chap06.constructor3;

import java.math.*;

public class BigDecimalTest {
	public static void main(String[] args) {
		System.out.println(0.1+0.3);
		
		double price = 19.99;
		double quantity = 3;
		System.out.println(price * quantity);
		
		// BigDecimal 사용
		BigDecimal a = new BigDecimal("0.1");
		BigDecimal b = new BigDecimal("0.2");
		System.out.println(a.add(b));
	}
}
