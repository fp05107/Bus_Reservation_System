package com.masai.service;

import com.masai.DTO.AdminLoginDTO;
import com.masai.exception.LoginException;
import com.masai.model.CurrentAdminSession;

public interface AdminLoginService {

	public CurrentAdminSession logIntoAdminAccount(AdminLoginDTO dto) throws LoginException;

	public String logOutFromAdminAccount(String key) throws LoginException;

}
