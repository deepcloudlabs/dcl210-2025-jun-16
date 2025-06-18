package com.example.demo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domain.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SpringBootJsonApplication implements ApplicationRunner{
	private final ObjectMapper objectMapper;
	
	public SpringBootJsonApplication(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJsonApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		var employees = Arrays.asList(
				new Employee("1", "Jack Shephard", "jack.shephard@example.com", null, BigDecimal.valueOf(100_000.1234)),
				new Employee("2", "Kate Austen", "kate.austen@example.com", "TR2", BigDecimal.valueOf(200_000.54321))
		);
		employees.stream().map(employee -> {
			try {
				return objectMapper.writeValueAsString(employee);
			}catch (JsonProcessingException e) {
				return null;
			}
		})
		.filter(Objects::nonNull)
		.forEach(System.out::println);
		
	}

}
