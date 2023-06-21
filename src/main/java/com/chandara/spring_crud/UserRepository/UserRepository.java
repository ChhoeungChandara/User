package com.chandara.spring_crud.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.chandara.spring_crud.Entity.User;

public interface UserRepository  extends JpaRepository<User,Long>{

}
