package com.marlabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan("com.marlabs")
public class Ames1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ames1Application.class, args);
	}

}
