package com.farkalit.test.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.farkalit.test.model.UserDto;
import com.farkalit.test.model.Userinfo;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	private static final Logger LOG = LogManager.getLogger(JwtUserDetailsService.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return getUserInfo(username);
	}

	/**
	 * 
	 * @param username
	 * @return
	 */
	public UserDetails getUserInfo(String username) {
		final String baseUrl = "http://localhost:8090/userinfo";
		try {
			UserDto user = new UserDto();
			user.setUsername(username);
			user.setPassword("");

			HttpEntity<UserDto> entity = new HttpEntity<>(user, getHeaders());
			ResponseEntity<Userinfo> response = restTemplate().exchange(new URI(baseUrl), HttpMethod.POST, entity,
					Userinfo.class);
			LOG.info("response:{} ", response.getBody());
			Userinfo userinfo = response.getBody();
			return new org.springframework.security.core.userdetails.User(userinfo.getUsername(),
					userinfo.getPassword(), new ArrayList<>());
		} catch (Exception e) {
			LOG.error("Error:{}", e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Get header values
	 * 
	 * @return
	 */
	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	/**
	 * Create Rest template
	 * 
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
