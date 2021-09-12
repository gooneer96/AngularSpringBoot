package pl.springboot.example.controller;


import java.util.HashMap;

import java.util.List;
import java.util.Map;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.springboot.example.exception.ResourceNotFoundException;
import pl.springboot.example.model.User;
import pl.springboot.example.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private UserRepository UserRepository;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return UserRepository.findAll();
	}


	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long UserId)
			throws ResourceNotFoundException {
		User User = UserRepository.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + UserId));
		return ResponseEntity.ok().body(User);
	}

	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User User) {
		return UserRepository.save(User);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long UserId,
			@Valid @RequestBody User UserDetails) throws ResourceNotFoundException {
		User User = UserRepository.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + UserId));

		User.setLogin(UserDetails.getLogin());
		User.setPassword(UserDetails.getPassword());
		User.setLastName(UserDetails.getLastName());
		User.setFirstName(UserDetails.getFirstName());
		User.setRoleId(UserDetails.getRoleId());
		final User updatedUser = UserRepository.save(User);
		return ResponseEntity.ok(updatedUser);
	}


	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long UserId)
			throws ResourceNotFoundException {
		User User = UserRepository.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + UserId));

		UserRepository.delete(User);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;

	}
}
