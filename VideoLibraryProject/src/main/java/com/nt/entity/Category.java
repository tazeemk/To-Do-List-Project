package com.nt.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.Data;

@Document
@Data
public class Category 
{

	@Id
	private Integer categoryId;

    private String categoryName;
}
