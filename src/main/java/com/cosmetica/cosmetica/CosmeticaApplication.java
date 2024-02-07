package com.cosmetica.cosmetica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CosmeticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CosmeticaApplication.class, args);
	}

}
