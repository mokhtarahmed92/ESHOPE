package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * IndexController.java is a rest api redirect to the index page
 * 
 * @Author Mokhtar Ahmed
 * @Version 1.0
 */

@Controller
@RequestMapping("/")
public class IndexController {

	/**
	 * getIndexPage is a rest api that redirect the index.jsp page
	 * 
	 * @return List of all items in the supermarket
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String getIndexPage() {
		return "index";
	}

}