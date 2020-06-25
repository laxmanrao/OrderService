package com.capgemini.fs.dbs.order.service;

import org.springframework.stereotype.Service;

import com.capgemini.fs.dbs.order.dto.CreateOrderResponse;
import com.capgemini.fs.dbs.order.dto.Order;
import com.capgemini.fs.dbs.order.exception.OrderNotFoundException;

@Service
public interface OrderService {

	CreateOrderResponse createOrder(Order orderRequest);
	
	Order fetchOrderByOrderID(long orderId) throws OrderNotFoundException;
	
	

}
