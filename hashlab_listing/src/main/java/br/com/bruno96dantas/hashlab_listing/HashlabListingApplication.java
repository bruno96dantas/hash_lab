package br.com.bruno96dantas.hashlab_listing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HashlabListingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HashlabListingApplication.class, args);
	}

}

