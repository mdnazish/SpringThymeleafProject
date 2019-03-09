/**
 * 
 */
package com.mn.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mn.app.entity.User;
import com.mn.app.service.UserService;

/**
 * @author Md Nazish
 *
 */
@Controller
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String registerForm(Model model){
		model.addAttribute("user", new User());
		return "views/register";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
	
		if(bindingResult.hasErrors()) {
			return "views/register";
		}
		if(userService.isUserPresent(user.getEmail())) {
			model.addAttribute("exist", true);
			return "views/register";
		}else {
			userService.createUser(user);
			model.addAttribute("register", true);
			return "views/login";
		}
	}
}
