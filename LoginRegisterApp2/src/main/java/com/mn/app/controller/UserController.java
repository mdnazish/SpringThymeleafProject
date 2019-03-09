/**
 * 
 */
package com.mn.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mn.app.service.UserService;

/**
 * @author Md Nazish
 *
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public String listusers(Model model, @RequestParam(defaultValue="") String name) {
		/**
		 * To display all the existing records.
		 */
		//model.addAttribute("users", userService.findAll());
		
		/**
		 * To display searched record by name
		 */
		model.addAttribute("users", userService.findByName(name.trim()));
		
		return "views/userList";
	}
}
