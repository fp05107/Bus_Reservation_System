package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AdminException;
import com.masai.exception.UserException;
import com.masai.model.CurrentAdminSession;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;
import com.masai.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;


	@Override
	public User createUser(User user) throws UserException {

		User existingUser = userDao.findByMobileNumber(user.getMobileNumber());

		if (existingUser != null)
			throw new UserException("User already registered with this Mobile number!");

		return userDao.save(user);

	}

	@Override
	public User updateUser(User user, String key) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUser(Integer userId, String key) throws UserException, AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User viewUserById(Integer userId, String key) throws UserException, AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> viewUsers(String key) throws UserException, AdminException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
