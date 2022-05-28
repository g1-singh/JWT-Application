package com.life.spring.login.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.life.spring.login.entity.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

	Admin findByUserName(String userName);

}
