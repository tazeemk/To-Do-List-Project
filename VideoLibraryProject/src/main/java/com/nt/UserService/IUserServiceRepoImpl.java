package com.nt.UserService;

import java.util.List;

import com.nt.entity.User;

public interface IUserServiceRepoImpl 
{

	public String addUser(User user);
	
	public List<User>fetchAllUser();
}
