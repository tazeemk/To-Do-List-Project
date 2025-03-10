package com.nt.MongoRepoSerivce;

import java.util.List;

import com.nt.entity.Category;

public interface ICategorySeriveRepo 
{

	public String addCategory(Category cat);
	
	public List<Category>getCategory();
}
