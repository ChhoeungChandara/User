package com.chandara.spring_crud.UserService;

import java.util.List;

import com.chandara.spring_crud.Entity.User;

public interface UserServices {
	User create(User user);
	User getUserId(Long id);
	User updateUser(Long id,User Updateuser);
	List<User> getAll();
	void delete(Long id);

}
