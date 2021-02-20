package com.garrido.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garrido.api.domain.Post;
import com.garrido.api.repository.PostRepository;
import com.garrido.api.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		
		return post.orElseThrow(() -> new ObjectNotFoundException("Error! Object not found!"));
	}
}
