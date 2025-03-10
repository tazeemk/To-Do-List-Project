package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.User;

public interface IUserRepository  extends JpaRepository<User, Integer> {

	
	@Query("select userName,password from User where userName=:username and password =:password")
	public Object[] getCredentials(String username,String password);
	
}
