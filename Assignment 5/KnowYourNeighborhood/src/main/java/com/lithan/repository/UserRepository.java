package com.lithan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lithan.entity.WebUser;



@Repository
public interface UserRepository extends JpaRepository<WebUser, Integer>{
	public WebUser findByUsername(String username);
}
