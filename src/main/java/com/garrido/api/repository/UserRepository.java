package com.garrido.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.garrido.api.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
