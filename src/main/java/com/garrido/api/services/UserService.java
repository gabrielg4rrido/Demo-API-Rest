package com.garrido.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garrido.api.domain.User;
import com.garrido.api.dto.UserDTO;
import com.garrido.api.repository.UserRepository;
import com.garrido.api.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		
		return user.orElseThrow(() -> new ObjectNotFoundException("Error! Object not found!"));
	}
	
	public User insertUser(User user) {
		return repository.insert(user);
	}
	
	public User updateUser(User user) {
		User newUser = findById(user.getId());
		updateData(newUser, user);
	
		return repository.save(newUser);
	}
	
	private void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}

	public void deleteUser(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User createUserFromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
