package com.my.insta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	// home.do 요청이 오면
	@RequestMapping("/home")
	public String home() {
		
		return "home";
	}
}
