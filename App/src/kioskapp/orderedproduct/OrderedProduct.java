package kioskapp.orderedproduct;

import java.io.Serializable;

import kioskapp.product.Product;


public class OrderedProduct implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int orderedItem;	
	

	private Product itemProduct;
	
	private int quantity;
	private float subTotalAmount;
	
	
	public int getOrderedItem() {
		return orderedItem;
	}
	
	
	public void setOrderedItem(int orderedItem) {
		this.orderedItem = orderedItem;
	}
	
	
	public Product getItemProduct() {
		return itemProduct;
	}
	
	
	public void setItemProduct(Product itemProduct) {
		this.itemProduct = itemProduct;
	}
	

	public int getQuantity() {
		return quantity;
	}
	
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public float getSubTotalAmount() {
		return subTotalAmount;
	}
	
	
	public void setSubTotalAmount(float subTotalAmount) {
		this.subTotalAmount = subTotalAmount;
	}

}
