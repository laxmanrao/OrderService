package com.capgemini.fs.dbs.order.dto;

public class OrderItemCreatedResponse {
	
	private String message;
	
	private String productCode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	

}
