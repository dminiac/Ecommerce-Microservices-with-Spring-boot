package com.abc.ecom.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Order;
import com.abc.ecom.entity.Product;
import com.abc.ecom.exception.ProductNotFoundException;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.repository.OrderRepository;
import com.abc.ecom.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Order saveOrder(Order order) {

		order.setOrderDate(LocalDate.now());

		int productId = order.getProductId();
		Optional<Product> optinalProduct = productRepository.findById(productId);

		if (optinalProduct.isEmpty()) {
			throw new ProductNotFoundException("Product not existing with id:" + productId);
		}

		else {
			Product product = optinalProduct.get();
			double totalPrice = product.getProductPrice();
			float orderPrice = (float) (order.getQuantity() * totalPrice);
			order.setOrderAmount(orderPrice);
		}

		Order newOrder = orderRepository.save(order);
		return newOrder;

	}

	@Override
	public Order getOrderDetails(int orderId) {

		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if (optionalOrder.isEmpty()) {
			throw new ResourceNotFoundException("Order not found with order id:" + orderId);
		}

		return optionalOrder.get();
	}
}