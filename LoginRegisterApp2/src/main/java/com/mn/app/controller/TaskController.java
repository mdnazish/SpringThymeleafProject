/**
 * 
 */
package com.mn.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mn.app.entity.Task;
import com.mn.app.service.TaskService;
import com.mn.app.service.UserService;

/**
 * @author Md Nazish
 *
 */
@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/add-task")
	public String addTask(String email, Model model, HttpSession session) {
		
		session.setAttribute("email", email);
		model.addAttribute("task", new Task());
		return "views/task";
	}
	
	@PostMapping("/task")
	public String AssignTask(@Valid Task task, BindingResult bindingResult, HttpSession session) {
		// check validation 
		if(bindingResult.hasErrors()) {
			return "views/task";
		}
		
		// get email from session
		String email = (String) session.getAttribute("email");
		
		// add task to selected user
		taskService.addTask(task, userService.findByEmail(email).get());
		
		// go back to user list page
		return "redirect:/users";
	}
}