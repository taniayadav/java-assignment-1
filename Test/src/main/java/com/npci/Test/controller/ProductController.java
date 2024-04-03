package com.npci.Test.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.Test.domain.Products;
import com.npci.Test.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<String> addProduct(@RequestBody Products product) {
		productService.addproduct(product);
		return ResponseEntity.status(HttpStatus.OK).body("Product added successfully");
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Products>> findAllProducts() {
		List<Products> products = productService.getProducts();
		return ResponseEntity.status(HttpStatus.OK).body(products);
	}

	@GetMapping("/checkout")
	public ResponseEntity<Map<String, Object>> checkout() {
		Map<String, Object> billDetails = productService.genrateBills();
		return ResponseEntity.status(HttpStatus.OK).body(billDetails);
	}
	
	

}
