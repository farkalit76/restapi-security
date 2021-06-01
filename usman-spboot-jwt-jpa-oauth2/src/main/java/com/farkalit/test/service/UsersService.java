package com.farkalit.test.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.farkalit.test.model.UserDao;
import com.farkalit.test.model.UsersHelper;
import com.farkalit.test.model.UsersPojo;
import com.farkalit.test.repository.UserRepository;

@Service
public class UsersService implements UserDetailsService {

	private static final Logger LOG = LogManager.getLogger(UsersService.class);

	@Autowired
	private UserRepository userDao;

//	@Autowired
//	private PasswordEncoder bcryptEncoder;

	@Override
	public UsersHelper loadUserByUsername(String username) throws UsernameNotFoundException {
		LOG.info("loadUserByUsername:{}", username);
		UsersHelper userhelper = null;

		List<UserDao> user = userDao.findByUsername(username);
		if (user.isEmpty()) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		} else {
			UserDao userdao = user.get(0);
			Collection<GrantedAuthority> listOfgrantedAuthorities = new ArrayList<>();
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
			listOfgrantedAuthorities.add(grantedAuthority);
			UsersPojo userpojo = new UsersPojo(userdao.getUsername(), userdao.getPassword());
			userpojo.setListOfgrantedAuthorities(listOfgrantedAuthorities);
			userhelper = new UsersHelper(userpojo);
			return userhelper;
		}
	}

//	public UserDao save(UserDto user) {
//		UserDao newUser = new UserDao();
//		newUser.setUsername(user.getUsername());
//		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
//		newUser.setEmailId(user.getEmailId());
//		newUser.setPhoneNum(user.getPhoneNum());
//		return userDao.save(newUser);
//	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		LOG.info("loadUserByUsername:{}", username);
//		if ("javainusejwt".equals(username)) {
//			return new User("javainusejwt", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//	}
}
