/**
 * 
 */
package com.farkalit.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


/**
 * @author farkalitusman
 *
 */
@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
public class ApiOAuthUsmanTest{

	public static void main(String[] args) {
		SpringApplication.run(ApiOAuthUsmanTest.class, args);
	}
}
