package br.com.clinicaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ClinicaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaApiApplication.class, args);
	}
}
