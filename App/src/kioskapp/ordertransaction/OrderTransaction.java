package kioskapp.ordertransaction;

import java.io.Serializable;
import java.sql.Date;

import kioskapp.order.Order;


public class OrderTransaction implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	private int orderTransactionId;
	private Date transactioDate;
	private float amountCharged;
	private boolean transactionStatus;
	private int last4Digits;
	private String orderMode;
	
	
	private Order order;


	public int getOrderTransactionId() {
		return orderTransactionId;
	}

	
	public void setOrderTransactionId(int orderTransactionId) {
		this.orderTransactionId = orderTransactionId;
	}


	public Date getTransactioDate() {
		return transactioDate;
	}

	
	public void setTransactioDate(Date transactioDate) {
		this.transactioDate = transactioDate;
	}

	
	public float getAmountCharged() {
		return amountCharged;
	}


	public void setAmountCharged(float amountCharged) {
		this.amountCharged = amountCharged;
	}


	public boolean isTransactionStatus() {
		return transactionStatus;
	}


	public void setTransactionStatus(boolean transactionStatus) {
		this.transactionStatus = transactionStatus;
	}


	public int getLast4Digits() {
		return last4Digits;
	}


	public void setLast4Digits(int last4Digits) {
		this.last4Digits = last4Digits;
	}


	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	
	public String getOrderMode() {
		return orderMode;
	}

	
	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}
	
	

}
