package com.example.orderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderService.entity.Order;
import com.example.orderService.model.OrderDetails;
import com.example.orderService.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/create")
	public ResponseEntity<Order> placeOrder(@RequestBody Order order) {

		Order newOrder = orderService.saveOrder(order);

		return new ResponseEntity<>(newOrder, HttpStatus.CREATED);

	}

	@GetMapping("/get/{oid}")
	public ResponseEntity<OrderDetails> fetchOrder(@PathVariable("oid") int orderId) {

		OrderDetails orderDetails = orderService.getOrderDetails(orderId);

		return new ResponseEntity<>(orderDetails, HttpStatus.CREATED);
	}
}