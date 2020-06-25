package com.capgemini.fs.dbs.order.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {
	
	private String customerName;
	
	private String orderDate;
	
	private String shippingAddress;
	
	private double total;
	
	private List<OrderItem> orderItems;

}
