package com.garrido.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.garrido.api.domain.User;
import com.garrido.api.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		User gabriel = new User(null, "Gabriel Garrido", "gabriel@gmail.com");
		User giulia = new User(null, "Giulia Boechat", "giulia@gmail.com");
		User livia = new User(null, "Livia Garrido", "livia@gmail.com");
	
		userRepository.saveAll(Arrays.asList(gabriel, giulia, livia));
		
		
	}

}
