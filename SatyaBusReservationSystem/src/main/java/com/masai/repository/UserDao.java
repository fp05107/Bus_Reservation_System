package com.masai.repository;


import com.masai.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    public User findByMobileNumber(String mobileNumber);

}