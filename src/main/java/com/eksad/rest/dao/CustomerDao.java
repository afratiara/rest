package com.eksad.rest.dao;

import org.springframework.data.repository.CrudRepository;

import com.eksad.rest.entity.Customer;

public interface CustomerDao extends CrudRepository<Customer, Long>{

}
