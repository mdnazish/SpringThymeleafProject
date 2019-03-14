/**
 * 
 */
package com.mn.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mn.app.entity.User;
import com.mn.app.service.TaskService;
import com.mn.app.service.UserService;

/**
 * @author Md Nazish
 *
 */
@Controller
public class ProfileController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/profile")
	public String showProfilePage(Model model, Principal principal) {
	
		// fetch id(email) from logged in user using Spring security
		String email = principal.getName();
		// fetch user from DB
		User user = userService.findByEmail(email).get();
		
		model.addAttribute("tasks", taskService.findUserTask(user));
		return "views/userprofile";
	}
}
