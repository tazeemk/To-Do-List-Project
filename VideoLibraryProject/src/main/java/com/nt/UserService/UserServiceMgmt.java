package com.nt.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.User;
import com.nt.repository.IUserRepository;
@Service
public class UserServiceMgmt implements IUserServiceRepoImpl {

	@Autowired
	private IUserRepository userRepo;
	
	
	@Override
	public String addUser(User user) {
		           userRepo.save(user);
		return "User saved Successfully";
	}

	
	@Override
	public List<User> fetchAllUser() {
		return userRepo.findAll();
	}
}
