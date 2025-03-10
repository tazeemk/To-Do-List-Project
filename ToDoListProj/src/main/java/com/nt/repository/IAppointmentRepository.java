package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Appointment;

public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {

	public List<Appointment>findByuserNameEquals(String userName);

    
}
