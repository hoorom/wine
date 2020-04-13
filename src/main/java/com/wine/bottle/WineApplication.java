package com.wine.bottle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Controller
@Slf4j
public class WineApplication {


	@RequestMapping("/index")
	String index() {
		return "index";
	}

	public static void main(String[] args) {
		try {
			SpringApplication.run(WineApplication.class, args);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

}
