package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.CurrentUserSession;


@Repository
public interface UserSessionDao extends JpaRepository<CurrentUserSession, Integer>{

	public CurrentUserSession findByUserUID(String userUID);
	
}
