package com.chandara.spring_crud.UserController;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chandara.spring_crud.Entity.User;
import com.chandara.spring_crud.UserService.UserServices;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {
	private final UserServices userServices;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody User user){
		 user = userServices.create(user);
		return ResponseEntity.ok(user);
	}
	@GetMapping("{id}")
	public ResponseEntity<?> getUserId(@PathVariable Long id){
		User userId = userServices.getUserId(id);
		return ResponseEntity.ok(userId);
	}
	@PutMapping("{id}")
	public ResponseEntity<?> Update(@PathVariable Long id,@RequestBody User userId){
		User user = userServices.updateUser(id, userId);
		return ResponseEntity.ok(user);
	}
	@GetMapping
	public ResponseEntity<?> getAllUser(){
		List<User> users =userServices.getAll();
		return ResponseEntity.ok(users);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable Long id){
		   userServices.delete(id);
		return ResponseEntity.ok("delete Success");
	}

}
