package com.mn.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mn.app.entity.User;
import com.mn.app.service.UserService;

@SpringBootApplication
public class LoginRegisterApp2Application implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(LoginRegisterApp2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Create ROLE_ADMIN as newAdmin object & store into DB
		{
			User newAdmin = new User("admin@gmail.com", "Admin", "admin123");
			userService.createAdmin(newAdmin);
		}
		
	}

}
