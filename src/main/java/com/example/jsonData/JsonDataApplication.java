package com.example.jsonData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.jsonData.repository"})
public class JsonDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonDataApplication.class, args);
	}

}
