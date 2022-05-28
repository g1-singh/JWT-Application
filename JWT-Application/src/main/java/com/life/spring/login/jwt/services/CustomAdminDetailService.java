package com.life.spring.login.jwt.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.life.spring.login.entity.Admin;
import com.life.spring.login.repository.AdminRepository;

@Service
public class CustomAdminDetailService implements UserDetailsService{

	@Autowired
	private AdminRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		System.out.println("userName: "+userName);
		System.out.println("repository: "+this.repository);
		Admin admin =repository.findByUserName(userName);
		System.out.println("admin: "+admin);
		if(userName.equals(admin.getUserName())) {
		return new User(admin.getUserName(),admin.getPassword(),new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("User not Found");
		}
	}

}
