package chap09.nested02;

public class Product {
	private String name;
	private int basePrice;
	
	public Product(String name, int basePrice) {
		super();
		this.name = name;
		this.basePrice = basePrice;
	}
	
	public String getName() {
		return name;
	}
	public int getBasePrice() {
		return basePrice;
	}

	@Override
	public String toString() {
		return String.format("%s (%,d원)", name, basePrice);
	}
	
	
	
	
}
