package com.dynatrace.micrometer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DynatraceMicrometerSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynatraceMicrometerSampleApplication.class, args);
	}

}
