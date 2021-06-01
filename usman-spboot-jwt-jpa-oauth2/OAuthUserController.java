package com.farkalit.test.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.farkalit.test.model.UserDto;
import com.farkalit.test.service.UsersService;

@RestController
public class OAuthUserController {

	
	@Autowired
	private UsersService usersService;

	
	@PostMapping(value = "/user/register", produces = "application/json")
	public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws Exception {
		return ResponseEntity.ok(usersService.save(user));
	}
}
