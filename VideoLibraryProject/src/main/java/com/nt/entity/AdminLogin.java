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
@Table(name="tbladmin")
public class AdminLogin 
{

	@Id
	@SequenceGenerator(name="adseq",sequenceName = "swee",initialValue = 1002,allocationSize = 1)
	@GeneratedValue(generator = "adseq",strategy = GenerationType.AUTO)
	private Integer aid;
	
	private String userName;
	
	private String password;
	
	private String addr;
	
	
	
}
