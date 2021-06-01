package com.farkalit.test.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.farkalit.test.model.UserDao;

public interface UserRepository extends CrudRepository<UserDao, Integer> {
	List<UserDao> findByUsername(String username);
}
