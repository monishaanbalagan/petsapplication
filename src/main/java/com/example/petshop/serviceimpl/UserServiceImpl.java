package com.example.petshop.serviceimpl;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petshop.dao.UserDao;
import com.example.petshop.exception.InvalidCredentialsException;
import com.example.petshop.model.User;
import com.example.petshop.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	private static Log logger = LogFactory.getLog(UserServiceImpl.class);

	@Autowired
	UserDao userDao;
	@Override
	public boolean authenticateUser(@Valid String userName, String password) {
		logger.info("implementaion of authenticating the user");
		User user = userDao.findByUserNameAndPassword(userName, password);

		if (user != null)
			return true;
		throw new InvalidCredentialsException("invalid credentials !! please try again with valid credentials");
	}
}

