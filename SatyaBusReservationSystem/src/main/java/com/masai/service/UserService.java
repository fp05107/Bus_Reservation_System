package com.masai.service;
import com.masai.model.Reservation;

import java.time.LocalDate;
import java.util.List;

import java.util.List;

import com.masai.exception.AdminException;
import com.masai.exception.UserException;
import com.masai.model.User;

public interface UserService {

	public User createUser(User user) throws UserException;

	public User updateUser(User user, String key) throws UserException;

	public User deleteUser(Integer userId, String key) throws UserException, AdminException;

	public User viewUserById(Integer userId, String key) throws UserException, AdminException;

	public List<User> viewUsers(String key) throws UserException, AdminException;

}
