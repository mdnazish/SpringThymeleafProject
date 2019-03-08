/**
 * 
 */
package com.mn.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Md Nazish
 *
 */
@Controller
public class IndexController {

	@GetMapping("/")
	public String showIndexPage() {
		return "index";
	}
}
