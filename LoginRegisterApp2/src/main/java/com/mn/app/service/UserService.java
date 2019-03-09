/**
 * 
 */
package com.mn.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mn.app.entity.Role;
import com.mn.app.entity.User;
import com.mn.app.repository.UserRepository;

/**
 * @author Md Nazish
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void createUser(User user) {

		// Security - save password in encoded format
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));

		// create Role object
		Role userRole = new Role("USER");

		// create List object of roles
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);

		// set role
		user.setRoles(roles);

		// save into DB
		userRepository.save(user);
	}

	public void createAdmin(User user) {

		// Security - save password in encoded format
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));

		// create Role object
		Role userRole = new Role("ADMIN");

		// create List object of roles
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);

		// set role
		user.setRoles(roles);

		// save into DB
		userRepository.save(user);
	}

	public Optional<User> findByEmail(String email) {
		return userRepository.findById(email);
	}

	public boolean isUserPresent(String email) {
		/** 
		 * It will return either object or throw an Runtime Exception
		 * RE: java.util.NoSuchElementException
		 * @see java.util.Optional.get(Optional.java:135) [Java 8]
		 */
		//User user = userRepository.findById(email).get();
		
		User user = userRepository.findById(email).orElse(null);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}
}
