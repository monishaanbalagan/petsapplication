package com.example.petshop.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.petshop.model.User;


@Repository
public interface UserDao extends CrudRepository<User ,Integer> {

	User findByUserNameAndPassword(String userName, String password);

	Optional<User> findAllByUserId(int userId);

	

}
