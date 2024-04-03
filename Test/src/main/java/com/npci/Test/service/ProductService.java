package com.npci.Test.service;

import java.util.List;
import java.util.Map;

import com.npci.Test.domain.Products;

public interface ProductService {
	
	public Products addproduct(Products products);
	public List<Products> getProducts();
	public Map<String,Object> genrateBills();
	public void deleteProduct(String productId);

}
