package com.revision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.revision.model.Product;
import com.revision.repository.Productrepo;

@Service
public class ProductService {

	@Autowired
	private Productrepo repo;
	
	public Product registorProduct(Product pro)
	{
		
		Product prod=repo.save(pro);
		return prod;
		
		
	}
	
	public List<Product> getAllProduct(){
		List<Product> list=repo.findAll();
		
		return list;
		
	}
	
	
	public List<Product> getproductwithSorted(String field)
	{
		
		List<Product> list=repo.findAll(Sort.by(Sort.Direction.ASC,field));
		
		return list;
	}
	
	public Page<Product> findproductwithpagination(int offset,int pageSize){
		
		Page<Product> products=repo.findAll(PageRequest.of(offset, pageSize));
		return products;
		
		
	}
	
	 public Page<Product> findProductsWithPaginationAndSorting(int offset,int pageSize,String field)
	 {
		 
		 Page<Product> products=repo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
		 return products;
		 
	 }
	
	
	
}
