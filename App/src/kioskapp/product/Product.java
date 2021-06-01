package kioskapp.product;

import java.io.Serializable;



public class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	private int itemProduct;
	private String name;
	private float price;
	

	public int getItemProduct() {
		return itemProduct;
	}
	

	public void setItemProduct(int itemProduct) {
		this.itemProduct = itemProduct;
	}
	

	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	

	public float getPrice() {
		return price;
	}
	
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	

}
