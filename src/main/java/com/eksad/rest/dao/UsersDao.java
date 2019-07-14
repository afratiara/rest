package com.eksad.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eksad.rest.entity.Users;

public interface UsersDao extends JpaRepository<Users, Integer>{
	
	public Users findByUsername(String username);

}
