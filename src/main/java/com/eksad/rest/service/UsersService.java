package com.eksad.rest.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eksad.rest.dao.UsersDao;
import com.eksad.rest.entity.Users;

@Service
public class UsersService implements UserDetailsService {
	
	@Autowired
	UsersDao usersDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersDao.findByUsername(username);
		if(username != null) {
			GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
			return new User(user.getUsername(), user.getPassword(), Arrays.asList(authority));
		} else {
			throw new UsernameNotFoundException("User not found");
		}
	}
	
	

}
