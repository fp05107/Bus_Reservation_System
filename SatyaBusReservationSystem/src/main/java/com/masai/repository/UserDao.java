package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	public User findByMobileNumber(String mobileNumber);
	
}
