package com.ait.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.dto.ProductDto;
import com.ait.entity.ProductEntity;
import com.ait.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public String saveProduct(ProductDto productDto) {
		ProductEntity entity=new ProductEntity();
		
		BeanUtils.copyProperties(productDto, entity);
		productRepo.save(entity);
		
		return "product Saved Sucessfully";
	}
	@Override
	public List<ProductEntity> getAllProducts() {
		return productRepo.findAll();
	}
	
	@Override
	public String deleteProduct(Integer id) {
		productRepo.deleteById(id);
		return "product Deleted sucessfully";
	}
}
