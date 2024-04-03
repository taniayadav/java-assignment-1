package com.npci.Test.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.npci.Test.domain.Products;
import com.npci.Test.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	private final List<Products> products = new ArrayList<>();

	@Override
	public Products addproduct(Products product) {
		// TODO Auto-generated method stub
		product.setProductId(String.valueOf(products.size() +1));
		products.add(product);
		return product;
	}

	@Override
	public List<Products> getProducts() {
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public Map<String, Object> genrateBills() {
		 double totalPrice = 0;
	        for (Products product : products) {
	            totalPrice += product.getPrice() * product.getQuantity();
	        }

	        double cgst = 0.09 * totalPrice;
	        double sgst = 0.09 * totalPrice;
	        double finalTotal = totalPrice + cgst + sgst;

	        Map<String, Object> billDetails = new HashMap<>();
	        billDetails.put("Products", products);
	        billDetails.put("Total Price", totalPrice);
	        billDetails.put("CGST 9%", cgst);
	        billDetails.put("SGST 9%", sgst);
	        billDetails.put("Final Total", finalTotal);

	        return billDetails;
	    }
	

	@Override
	public void deleteProduct(String productId) {
		// TODO Auto-generated method stub
		 Iterator<Products> iterator = products.iterator();
	        while (iterator.hasNext()) {
	            Products product = iterator.next();
	            if (product.getProductId().equals(productId)) {
	                iterator.remove();
	                break;
	            }
	        }
		
	}
	
	

}
