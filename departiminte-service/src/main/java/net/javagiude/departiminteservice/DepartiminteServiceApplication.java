package net.javagiude.departiminteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DepartiminteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartiminteServiceApplication.class, args);
	}

}
