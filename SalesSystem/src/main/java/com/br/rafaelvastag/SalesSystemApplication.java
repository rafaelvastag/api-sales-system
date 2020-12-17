package com.br.rafaelvastag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.br.rafaelvastag.model.entity.ClienteEntity;
import com.br.rafaelvastag.model.repository.ClienteRepository;

@SpringBootApplication
public class SalesSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesSystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner run( @Autowired ClienteRepository repository) {
		
		return args -> {
			
			ClienteEntity cliente = ClienteEntity.builder()
													.cpf("22222222222")
													.nome("rafael")
													.build();
			
			repository.save(cliente);
			
		};
		
	}

}
