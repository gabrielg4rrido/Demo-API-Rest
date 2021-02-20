package com.garrido.api.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.garrido.api.domain.Post;
import com.garrido.api.domain.User;
import com.garrido.api.dto.AuthorDTO;
import com.garrido.api.dto.CommentDTO;
import com.garrido.api.repository.PostRepository;
import com.garrido.api.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
	
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User gabriel = new User(null, "Gabriel Garrido", "gabriel@gmail.com");
		User giulia = new User(null, "Giulia Boechat", "giulia@gmail.com");
		User livia = new User(null, "Livia Garrido", "livia@gmail.com");
		
		userRepository.saveAll(Arrays.asList(gabriel, giulia, livia));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem!", "Vou viajar para SP, abraços.", new AuthorDTO(gabriel));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(giulia));
		Post post3 = new Post(null, sdf.parse("08/10/2018"), "Aniversário do boy!", "Te amo baby!", new AuthorDTO(giulia));
		
		CommentDTO c1 = new CommentDTO("Boa viagem maninho!", sdf.parse("21/03/2018"), new AuthorDTO(livia));
		CommentDTO c2 = new CommentDTO("Te amo vida!", sdf.parse("08/10/2018"), new AuthorDTO(gabriel));
		
		post1.getComments().add(c1);
		post3.getComments().add(c2);
		
		postRepository.saveAll(Arrays.asList(post1, post2, post3));
		
		giulia.getPosts().addAll(Arrays.asList(post2, post3));
		gabriel.getPosts().addAll(Arrays.asList(post1));
		
		userRepository.saveAll(Arrays.asList(gabriel, giulia));
	}
}