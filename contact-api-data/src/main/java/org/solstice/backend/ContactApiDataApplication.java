package org.solstice.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration

public class ContactApiDataApplication {
			
	public static void main(String[] args) {
		
		SpringApplication.run(ContactApiDataApplication.class, args);
	}
}
