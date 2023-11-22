package com.intecbrussel.bankingclientsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.intecbrussel.bankingclientsservice.clients.repository")
public class BankingClientsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingClientsServiceApplication.class, args);
	}

}
