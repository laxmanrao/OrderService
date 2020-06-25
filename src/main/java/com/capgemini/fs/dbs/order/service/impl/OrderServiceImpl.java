package com.capgemini.fs.dbs.order.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.fs.dbs.order.dto.CreateOrderResponse;
import com.capgemini.fs.dbs.order.dto.Order;
import com.capgemini.fs.dbs.order.dto.OrderItem;
import com.capgemini.fs.dbs.order.entity.Orders;
import com.capgemini.fs.dbs.order.exception.OrderNotFoundException;
import com.capgemini.fs.dbs.order.feignClient.OrderItemClient;
import com.capgemini.fs.dbs.order.repository.OrderRepository;
import com.capgemini.fs.dbs.order.service.OrderService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderItemClient orderItemClient;

	@Override
	public CreateOrderResponse createOrder(Order orderRequest) {
		CreateOrderResponse response = new CreateOrderResponse();
		com.capgemini.fs.dbs.order.entity.Orders order = new com.capgemini.fs.dbs.order.entity.Orders();
		order.setCustomerName(orderRequest.getCustomerName());
		order.setShippingAddress(orderRequest.getShippingAddress());
		order.setTotal(orderRequest.getTotal());
		com.capgemini.fs.dbs.order.entity.Orders savedOrder = orderRepository.save(order);

		for (OrderItem orderItem : orderRequest.getOrderItems()) {
			orderItem.setOrderId(savedOrder.getId());
			/*
			 * RestTemplate restTemplate = new RestTemplate(); OrderItemCreatedResponse
			 * orderItemCreatedResponse = restTemplate.postForObject(
			 * "http://localhost:8080/OrderItemsService/createOrderItem", orderItem,
			 * OrderItemCreatedResponse.class);
			 * log.info("orderItemCreatedResponse::{}",orderItemCreatedResponse);
			 */
			log.info("OrderItem Saved:::{}", orderItem);
			orderItemClient.createOrderItem(orderItem);
		}
		response.setOrder(orderRequest);
		response.setOrderId(String.valueOf(savedOrder.getId()));
		response.setMessage("Order Created Successfully");
		log.info("Order Created Successfully!!!");
		return response;
	}

	@Override
	public Order fetchOrderByOrderID(long orderId) throws OrderNotFoundException {
		Order order = new Order();
		Optional<Orders> orders = orderRepository.findById(orderId);
		if (orders.isPresent()) {
			Orders r = orders.get();
			order.setCustomerName(r.getCustomerName());
			order.setShippingAddress(r.getShippingAddress());
			order.setTotal(r.getTotal());
		} else {
			throw new OrderNotFoundException("order not found with OrderId::");
		}
		List<OrderItem> orderItems = orderItemClient.getOrderItemsByorderId(orderId).getBody();
		if (orderItems.size() > 0) {

			order.setOrderItems(orderItems);
		}
		return order;
	}

}
