package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Appointment;
import com.nt.entity.User;
import com.nt.repository.IAppointmentRepository;
import com.nt.repository.IUserRepository;

@Service
public class UserAppointmentServiceImpl implements IUserAppointmentServiceRepo {

	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private IAppointmentRepository appointRepo;
	
	
	@Override
	public String addUser(User user) {
	
		
     int idval =userRepo.save(user).getUserId();
	return "User is Registerd with id no :"+idval;
	}


	@Override
	public Object[] getCredentials(String username, String password) {
	
		Object[] list= userRepo.getCredentials(username, password);
		
		return list;
	}

	@Override
	public List<User> getAllUser() {
	
	    return userRepo.findAll();
	}
	
	
	@Override
	public String registerUser(Appointment appoint) {
	          appointRepo.save(appoint);
		return "Appoinment added successfully";
	}
	
	@Override
	public List<Appointment> getAppointments(String userName) {
	  
		  
		return appointRepo.findByuserNameEquals(userName);
	}
	
	@Override
	public Appointment findByappointment(Integer id) {
		
		Optional<Appointment>op = appointRepo.findById(id);
		if(op.isPresent()) {
			return op.get();
		}
		throw new IllegalArgumentException("Invalid Number");
	}
	
	
	@Override
	public String updateAppointment(Appointment appoint) {
	
		Optional<Appointment>op = appointRepo.findById(appoint.getAppointment_Id());
		if(op.isPresent()) {
			  appointRepo.save(appoint);
			  return "Updated";			
		}
		
		throw new IllegalArgumentException("Invalid ID:");
	}
	
	@Override
	public String removeAppointmentById(int id) 
	{
	
		 appointRepo.deleteById(id);
		return "delete successfully";
	}
	
	
}
