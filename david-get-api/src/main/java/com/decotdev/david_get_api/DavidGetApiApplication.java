package com.decotdev.david_get_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DavidGetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DavidGetApiApplication.class, args);
	}

	@Bean
	public List<Question> getQuestions() {
		return new ArrayList<Question>();
	}

}
