package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.DTO.UserLoginDTO;
import com.masai.exception.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.service.UserLoginService;

@RestController
public class UserLoginController {

	@Autowired
	private UserLoginService userLogin;

	@PostMapping("/login/user")
	public ResponseEntity<CurrentUserSession> logInUser(@Valid @RequestBody UserLoginDTO dto) throws LoginException {

		CurrentUserSession result = userLogin.logIntoUserAccount(dto);

		return new ResponseEntity<CurrentUserSession>(result, HttpStatus.ACCEPTED);

	}

	@PostMapping("/logout/user")
	public String logoutUser(@RequestParam(required = false) String key) throws LoginException {

		return userLogin.logOutFromUserAccount(key);

	}
}