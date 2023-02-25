package com.lithan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lithan.entity.WebUser;


@Controller
public class ConfigurationController {
	 @GetMapping("/login")
	  public String loginPage(Model model) {
	    WebUser user = new WebUser();

	    model.addAttribute("user", user);
	    return "login";
	  }
}
