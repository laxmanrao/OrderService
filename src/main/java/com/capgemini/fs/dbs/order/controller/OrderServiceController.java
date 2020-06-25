package com.capgemini.fs.dbs.order.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.fs.dbs.order.dto.CreateOrderResponse;
import com.capgemini.fs.dbs.order.dto.Order;
import com.capgemini.fs.dbs.order.exception.OrderNotFoundException;
import com.capgemini.fs.dbs.order.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Api(value="OrderManagementSystem", description="This Microservice is resposnible to Create Order and Retrieve existinfg Orders")
public class OrderServiceController {
	
	@Autowired
	OrderService orderService;
	
	@ApiOperation(value = "/OrderService/createNewOrder", response = CreateOrderResponse.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@PostMapping(value = "/createNewOrder")
	public ResponseEntity<?> createNewOrder(@ApiParam @RequestBody @Valid Order orderRequest)  {
		log.info("Calling createNewOrder service!!!");
		log.info("Request:::{}", orderRequest);
		CreateOrderResponse response = orderService.createOrder(orderRequest);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getOrders/{orderId}", produces = "application/json")
	public ResponseEntity<?> retrievePreviousOredrDetails(@PathVariable("orderId") long orderId) throws OrderNotFoundException {
		log.info("Calling retrievePreviousOredrDetails API!!!");
		Order order = orderService.fetchOrderByOrderID(orderId);
		return new ResponseEntity<>(order, HttpStatus.OK);
		
	}

 
}
