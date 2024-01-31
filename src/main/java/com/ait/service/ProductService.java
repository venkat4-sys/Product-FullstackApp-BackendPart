package com.ait.service;

import java.util.List;

import com.ait.dto.ProductDto;
import com.ait.entity.ProductEntity;

public interface ProductService {
	
	public String saveProduct(ProductDto productDto);
	
	public List<ProductEntity> getAllProducts();
	
	public String deleteProduct(Integer id);

}
