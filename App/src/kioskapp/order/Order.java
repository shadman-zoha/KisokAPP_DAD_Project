package kioskapp.order;

import java.io.Serializable;
import java.util.List;

import kioskapp.orderedproduct.OrderedProduct;


public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	private int orderId;
	

	private List<OrderedProduct> orderedItems;
	
	private float totalAmount;
	private  int orderReferenceNumber;
	
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	

	public List<OrderedProduct> getOrderedItems() {
		return orderedItems;
	}
	

	public void setOrderedItems(List<OrderedProduct> orderedItems) {
		this.orderedItems = orderedItems;
	}
	
	
	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	

	public int getOrderReferenceNumber() {
		return orderReferenceNumber;
	}
	

	public void setOrderReferenceNumber(int orderReferenceNumber) {
		this.orderReferenceNumber = orderReferenceNumber;
	}
	
	
	
	
	

}
