package com.nt.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="tblappointment")
@AllArgsConstructor
@NoArgsConstructor
public class Appointment 
{
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Integer appointment_Id;
 
     private String title;
 
	 private String description;
	 
	 private LocalDate date;
	 
	 private String userName;
	 
}
