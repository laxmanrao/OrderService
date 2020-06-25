package com.capgemini.fs.dbs.order.dto;

public class OrderItem {
	private long orderId;
	
	private String productCode;

	private String productName;

	private int quantity;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItem [orderId=" + orderId + ", productCode=" + productCode + ", productName=" + productName
				+ ", quantity=" + quantity + "]";
	}

}
