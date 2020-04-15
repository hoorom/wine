package com.wine.bottle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class WineApplication {


	@RequestMapping("/index")
	String index() {
		return "index";
	}

	public static void main(String[] args) {
			SpringApplication.run(WineApplication.class, args);
	}

}
