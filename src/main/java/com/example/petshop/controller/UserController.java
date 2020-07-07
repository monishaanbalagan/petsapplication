package com.example.petshop.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.petshop.dto.LoginRequestDto;
import com.example.petshop.exception.InvalidCredentialsException;
import com.example.petshop.service.UserService;

@RestController
public class UserController {
	private static Log logger = LogFactory.getLog(UserController.class);
	@Autowired
	UserService userService;

	/**
	 * @param loginDto
	 * @return
	 * @throws InvalidCredentialsException
	 */
	@PostMapping("/users/login")
	public String authenticateUser(@Valid @RequestBody LoginRequestDto loginDto) {
		logger.info("authenticating the user");
		boolean isExists;
		isExists = userService.authenticateUser(loginDto.getUserName(), loginDto.getPassword());
		if (isExists)
			return "logged in successfully";
      else {
            return "Credentials are incorrect";
		}

	}

}
