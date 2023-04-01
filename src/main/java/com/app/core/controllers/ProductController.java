package com.app.core.controllers;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.core.classes.Product;
import com.app.core.repositories.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/products/{sku}")
	public List<Product> getProductBySku(@PathVariable String sku, @RequestParam(required = false) String name) {
		List<Product> productList = StringUtils.isBlank(name) ? productRepository.findBySku(sku)
				: productRepository.findBySkuAndName(sku, name);
		return productList;
	}

}
