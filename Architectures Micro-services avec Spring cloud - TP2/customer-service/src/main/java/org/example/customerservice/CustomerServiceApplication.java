package org.example.customerservice;

import org.example.customerservice.entities.Costumer;
import org.example.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(
			CustomerRepository customerRepository ,
			RepositoryRestConfiguration repositoryRestConfiguration) {
		repositoryRestConfiguration.exposeIdsFor(Costumer.class); // to show the ID on the API
		return args -> {
			customerRepository.save(new Costumer(null, "Mohamed" , "med@gmail.com"));
			customerRepository.save(new Costumer(null, "Hassan" , "hassan@gmail.com"));
			customerRepository.save(new Costumer(null, "Salima" , "salima@gmail.com"));

			customerRepository.findAll().forEach(costumer -> {
				System.out.println(costumer.toString());
			});
		};
	}
}
