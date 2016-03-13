package com.fahad.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fahad.example.model.UserObject;


@Controller
public class HelloWorldController {
	String message = "Welcome to Spring MVC!";
	 
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("Name: " + name);
 
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
	
	@RequestMapping(value="/getAge", method=RequestMethod.POST)
	public @ResponseBody UserObject GetUserAge (@RequestBody UserObject user) {
		System.out.println(user);
		user.setAge(22);
		return user;
	}
	
}
