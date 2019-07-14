package com.eksad.rest.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.eksad.rest.entity.Person;

public interface PersonDao extends CrudRepository<Person, Long>{

}

//public interface PersonDao extends PagingAndSortingRepository<Person, Long>{
//	
//	
//
//}