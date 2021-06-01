package com.farkalit.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.farkalit.test.model.UserDao;

public interface UserRepository extends CrudRepository<UserDao, Integer> {
	UserDao findByUsername(String username);
}
