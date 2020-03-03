package com.example.test.springconditionalonproperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringConditionalOnPropertyApplication implements CommandLineRunner {

	@Autowired
	private SpringService springService;

	public static void main(String[] args) {
		SpringApplication.run(SpringConditionalOnPropertyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Spring service fully qualified class name: " + springService.getClass());
	}
}
