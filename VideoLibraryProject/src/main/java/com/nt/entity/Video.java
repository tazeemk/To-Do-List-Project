package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tblvideo")
@Data
public class Video 
{
 
	@Id
	@SequenceGenerator(name="abc",sequenceName = "de",allocationSize = 1,initialValue = 1001)
	@GeneratedValue(generator = "abc",strategy = GenerationType.SEQUENCE)
	private Integer videoId;
	
	private String title;
	
	private String url;
	
	private String description;
	
	private String likes;
	
	private String dislikes;
	
	private String categoryId;
	
	
}
