package com.chandara.spring_crud.UserService.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chandara.spring_crud.Entity.User;
import com.chandara.spring_crud.Exception.ResourceNotFoundException;
import com.chandara.spring_crud.UserRepository.UserRepository;
import com.chandara.spring_crud.UserService.UserServices;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServices{

	private final UserRepository userRepository;
	@Override
	public User create(User user) {
		return userRepository.save(user);
	}
	@Override
	public User getUserId(Long id) {
		return userRepository.findById(id)
				                          .orElseThrow(()->new ResourceNotFoundException("user",id));
	}
	@Override
	public User updateUser(Long id, User Updateuser) {
		User user = getUserId(id);
		user.setFullName(Updateuser.getFullName());
		user.setEmail(Updateuser.getEmail());
		user.setPhoneNumber(Updateuser.getPhoneNumber());
		return userRepository.save(user);
	}
	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}
	@Override
	public void delete(Long id) {
		User userId = getUserId(id);
		userRepository.delete(userId);
	}

}
