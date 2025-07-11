package com.amigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class AmigoElectronicWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmigoElectronicWalletApplication.class, args);
	}
}
