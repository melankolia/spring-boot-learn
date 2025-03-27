package com.ageng.belajar_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class BelajarSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BelajarSpringbootApplication.class, args);
	}

}
