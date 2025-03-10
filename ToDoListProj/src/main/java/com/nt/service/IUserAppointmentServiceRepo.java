package com.nt.service;

import java.util.List;

import com.nt.entity.Appointment;
import com.nt.entity.User;

public interface IUserAppointmentServiceRepo 
{

	public String addUser(User user);
	
	public Object[] getCredentials(String username,String password);
	
	public List<User>getAllUser();
	
	public String registerUser(Appointment appoint);
	
	public List<Appointment>getAppointments(String userName);
	
	public Appointment findByappointment(Integer id);
	
	public String updateAppointment(Appointment appoint);
	
	public String removeAppointmentById(int id);
	
}
