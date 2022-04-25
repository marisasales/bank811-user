package com.letscode.bank811user;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@OpenAPIDefinition(
		info = @Info(
				title = "Bank User Service",
				version = "1.0",
				description = "This is a microservice that manages bank users."))
public class Bank811UserApplication {

	public static void main(String[] args) { SpringApplication.run(Bank811UserApplication.class, args); }
}
