package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="tblVideoUser")
public class User 
{

	@Id
	@SequenceGenerator(name="userseq" ,sequenceName = "videseq",initialValue = 100,allocationSize = 1)
    @GeneratedValue(generator = "userseq" ,strategy = GenerationType.SEQUENCE)
	private Integer userId;
	
	private String userName;
	
	private String password;
	
	private String email;
	
	private Long number;
	
}
