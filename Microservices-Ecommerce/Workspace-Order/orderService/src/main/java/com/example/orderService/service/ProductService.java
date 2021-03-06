package com.example.orderService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.orderService.model.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class ProductService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "productServiceFallBack", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000") })
	public Product getProductDetails(int productId) {

		String resourceUrl = "http://ecom-product-service/ecom/product/get/" + productId;

		Product product = restTemplate.getForObject(resourceUrl, Product.class);

		return product;

	}

	@SuppressWarnings("unused")
	private Product productServiceFallBack(int productId) {

		System.out.println("Product Service is down!!! fallback route enabled...");
		return null;

		/*
		 * return
		 * "CIRCUIT BREAKER ENABLED!!! No Response From Student Service at this moment. "
		 * + " Service will be back shortly - " + LocalDate.now();
		 */
	}

}
