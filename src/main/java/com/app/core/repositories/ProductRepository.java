package com.app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.core.classes.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

	List<Product> findBySku(String sku);

	List<Product> findBySkuAndName(String sku, String name);

}
