package com.stackroute.contactapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class ContactappApplication {

	public static void main(String[] args) {

		SpringApplication.run(ContactappApplication.class, args);
		System.out.println("MongoDB Application Started");
	}

}
