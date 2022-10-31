package com.argPrograma.Portafolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.argPrograma.Portafolio.model"})
public class PortafolioApplication {
	public static void main(String[] args) {
		SpringApplication.run(PortafolioApplication.class, args);
	}
}