package com.capgemini.fs.dbs.order.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgemini.fs.dbs.order.dto.OrderItem;
import com.capgemini.fs.dbs.order.dto.OrderItemCreatedResponse;

@FeignClient(name = "OrderItemsService",url = "http://localhost:8080/OrderItemsService")
public interface OrderItemClient {
	
	@PostMapping(value = "/createOrderItem")
	public ResponseEntity<OrderItemCreatedResponse> createOrderItem(@RequestBody OrderItem orderItem);
	
	@GetMapping(value = "/getOrderItem/{orderId}")
	public ResponseEntity<List<OrderItem>> getOrderItemsByorderId(@PathVariable long orderId);

}
