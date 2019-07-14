package com.eksad.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eksad.rest.entity.Brand;

public interface BrandDao extends CrudRepository<Brand, Long> {
	
	// ini kalo mau nyari kek pake where
//	public Brand findOneByName(String name);
	
	
	public List<Brand> findByName(String name);
	public List<Brand> findByProductType(String product_type);
	
//	@Query("select b from Brand b where name = ?1") // ?1 menunjukkan indeksnya 1
//	public List<Brand> findBySearch(String search);
	
	@Query("select b from Brand b where name = :search")
	public List<Brand> findBySearch(@Param("search") String search);

}
