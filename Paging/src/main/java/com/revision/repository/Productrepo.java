package com.revision.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revision.model.Product;
@Repository
public interface Productrepo extends JpaRepository<Product,Integer>{

}
