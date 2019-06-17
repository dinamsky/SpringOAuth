package com.dinamsky.Spring.OAuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@SpringBootApplication
public class SpringOAuthApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringOAuthApplication.class, args);
	}

}
