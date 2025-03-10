package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.AdminLogin;
import com.nt.repository.IAdminLoginRepository;

@Service
public class AdminServiceImpl implements IAdminServiceImp {

	@Autowired
	private IAdminLoginRepository adminRepo;
	
	@Override
	public List<AdminLogin> getAdmin() {
		
		return adminRepo.findAll();
	}

}
