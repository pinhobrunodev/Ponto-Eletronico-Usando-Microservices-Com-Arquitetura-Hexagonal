package com.pinhobrunodev.attendancems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class AttendanceMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceMsApplication.class, args);
	}

}
