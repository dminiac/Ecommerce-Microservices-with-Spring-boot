package com.example.orderService.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "order_tbl")
public class Order {

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;

	@Column(name = "order_date")
	private LocalDate orderDate;

	@Column(name = "order_amount")
	private float orderAmount;

	@JoinColumn(name = "product_id")
	@Column(name = "product_id")
	private int productId;

	@Column(name = "quantity")
	private int quantity;

	@JoinColumn(name = "customer_id")
	@Column(name = "customer_id")
	private int customerId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public float getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(float orderPrice) {
		this.orderAmount = orderPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}