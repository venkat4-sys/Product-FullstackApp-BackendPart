package com.ait.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ait.dto.ProductDto;
import com.ait.dto.ProductResponse;
import com.ait.entity.ProductEntity;
import com.ait.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductRest {
	
	@Autowired
	private ProductService productservice;
	
	@PostMapping("/save")
	@CrossOrigin
	public ResponseEntity<?> saveProduct(@RequestBody ProductDto productDto){
		String message = productservice.saveProduct(productDto);
		System.out.println("saved");
		ProductResponse response=new ProductResponse();
		response.setMessage(message);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@GetMapping("/getAllproducts")
	@CrossOrigin
	public ResponseEntity<?> getAllProducts(){
		 List<ProductEntity> allProducts = productservice.getAllProducts();
		return new ResponseEntity<>(allProducts,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	@CrossOrigin
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
		String message = productservice.deleteProduct(id);
		ProductResponse response=new ProductResponse();
		response.setMessage(message);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	

}
