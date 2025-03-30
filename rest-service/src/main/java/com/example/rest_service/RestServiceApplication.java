package com.example.rest_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

}

/*
On widows PowerShell
Invoke-RestMethod -Uri "http://localhost:8080/api/v0/users" -Method Post -Headers @{"Content-Type"="application/json"} -Body '{"id":4, "email":"email4@email.com","fullName":"User 4","password":"1234"}'

 */