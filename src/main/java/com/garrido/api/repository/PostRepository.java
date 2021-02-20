package com.garrido.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.garrido.api.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
