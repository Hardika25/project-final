package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class MainClass {
	public static void main(String[] args) {
		SpringApplication.run(MainClass.class, args);
		System.out.println("Running at port 5000");

	}

}
