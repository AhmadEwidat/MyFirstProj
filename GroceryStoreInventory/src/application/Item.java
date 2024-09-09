package application;


public class Item implements Comparable<Item> {
	private String type;
	private int quantity;
	private double price;
	private String expiration;
	public Item() {
		

	}

	public String getExpiration() {
		return expiration;
	}

	public Item setExpiration(String expiration) {
		this.expiration = expiration;
		return this;
	}

	public Item(String type) {

		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public Item setQuantity(int quantity) {
		
		this.quantity = quantity;
		return this;
	}

	public Item setPrice(double price) {

		this.price = price;

		return this;

	}

	public Item update(int qtyIncrease) {
		
		this.quantity= (qtyIncrease + quantity);
		return this;

	}

	public Item update(double adjustmentFactor) {
		this.price=(price * (1 + adjustmentFactor));
		return this;
	}
	public Item update(String ex) {
		this.expiration=ex;
		return this;
	}
	

	@Override
	public int compareTo(Item i) {
		return (int) ((getPrice()) - (i.getPrice()));

	}

}

