package com.abc.ecom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.ecom.entity.Product;
import com.abc.ecom.exception.ProductNotFoundException;
import com.abc.ecom.repository.ProductRepository;

@SpringBootTest
public class ProductServiceTest {

	@InjectMocks
	private ProductService productService = new ProductServiceImpl();

	@Mock
	private ProductRepository productRepository;

	@Test
	public void testSaveProduct() {

		Product product = new Product();
		product.setProductId(101);
		product.setProductName("dummyname");
		product.setProductPrice(1111);
		product.setCreateOn(LocalDate.of(2000, 10, 10));
		product.setProductCategory("dummy");

		Optional<Product> optionalProduct = Optional.of(product);

		int productId = 101;

		when(productRepository.findById(101)).thenReturn(optionalProduct);

		Product existingProduct = productService.getProductById(productId);

		assertEquals("dummyname", existingProduct.getProductName());
	}
	
	@Test
	public void testGetProductByIdNotFound() {
		
		int productId = 200;
		
		when(productRepository.findById(productId)).thenThrow(ProductNotFoundException.class);

		assertThrows(ProductNotFoundException.class,()->productService.getProductById(productId));
		
	}
	
	@Test
    public void testSaveProduct1() {

        Product product = new Product();
        product.setProductId(10);
        product.setProductName("dummyname");
        product.setProductPrice(11111);
        product.setCreateOn(LocalDate.of(2000, 10, 10));
        product.setProductCategory("dummy");   

        when(productRepository.save(product)).thenReturn(product);

        Product newProduct = productService.saveProduct(product);

        //assertEquals(product.getProductName(), newProduct.getProductName());

        verify(productRepository,times(1)).save(product);       

    }
	
	@Test
	public void deleteProductById() {
		
		int productId = 222;
		
		Product product = new Product();
		product.setProductId(10);
		product.setProductName("dummyname");
		product.setProductPrice(1111);
		product.setCreateOn(LocalDate.of(2000, 10, 10));
		product.setProductCategory("dummy");
		
		Optional<Product> optionalProduct = Optional.of(product);
		
		when(productRepository.findById(222)).thenReturn(optionalProduct);
		
		productService.deleteProduct(productId);
		
		verify(productRepository,times(1)).deleteById(productId);
		
		
		
		
	}

}
