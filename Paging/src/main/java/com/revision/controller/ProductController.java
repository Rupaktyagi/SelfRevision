package com.revision.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revision.DTO.APIResponse;
import com.revision.model.Product;
import com.revision.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;
	
	
	@PutMapping("/registor")
	public ResponseEntity<Product> registorProductHandler(Product product)
	{
		Product pro=service.registorProduct(product);
		return new ResponseEntity<Product>(pro, HttpStatus.CREATED);
		
		
	}
	
	 @GetMapping("/{field}")
	    private APIResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
	        List<Product> allProducts = service.getproductwithSorted(field);
	        return new APIResponse<>(allProducts.size(), allProducts);
	    }

	    @GetMapping("/pagination/{offset}/{pageSize}")
	    private APIResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
	        Page<Product> productsWithPagination = service.findproductwithpagination(offset, pageSize);
	        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
	    }

	    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
	    private APIResponse<Page<Product>> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
	        Page<Product> productsWithPagination = service.findProductsWithPaginationAndSorting(offset, pageSize, field);
	        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
	    }
	
	
	
	
}
