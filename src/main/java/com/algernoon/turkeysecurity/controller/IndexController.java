package com.algernoon.turkeysecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RestController
public class IndexController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		System.err.println("com.algernoon.turkeysecurity.controller.IndexController.index()");
		return "index";
	}

}
