package com.masai.service;

import com.masai.DTO.UserLoginDTO;
import com.masai.exception.LoginException;
import com.masai.model.CurrentUserSession;

public interface UserLoginService {

	public CurrentUserSession logIntoUserAccount(UserLoginDTO dto)throws LoginException;

	public String logOutFromUserAccount(String key)throws LoginException;
	
}
