package com.example.SportsJerseyKingdom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class SportsJerseyKingdomApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsJerseyKingdomApplication.class, args);
	}
	
	@RequestMapping
	@ResponseBody
	public String home(){
		return "SportsJerseyKingdom";
	}



}
