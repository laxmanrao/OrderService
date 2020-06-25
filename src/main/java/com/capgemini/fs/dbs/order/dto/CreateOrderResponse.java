package com.capgemini.fs.dbs.order.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CreateOrderResponse {
	
	private String orderId;
	
	private String message;
	
	private Order order;

}
