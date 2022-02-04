package com.pinhobrunodev.sendemailms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class SendemailMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendemailMsApplication.class, args);
	}

}
