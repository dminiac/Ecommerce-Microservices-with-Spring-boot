package com.example.orderService.service;

import com.example.orderService.entity.Order;
import com.example.orderService.model.OrderDetails;

public interface OrderService {

	public Order saveOrder(Order order);

	public OrderDetails getOrderDetails(int orderId);

}