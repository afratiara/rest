package com.eksad.rest.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eksad.rest.entity.ProductGrocery;

@RepositoryRestResource(path = "groceries")
public interface ProductGroceryDao extends CrudRepository<ProductGrocery, Long>{
	
	public List<ProductGrocery> findByName(@Param("name") String name);
	public List<ProductGrocery> findByBrandName(@Param("brandName") String brandName);

}
