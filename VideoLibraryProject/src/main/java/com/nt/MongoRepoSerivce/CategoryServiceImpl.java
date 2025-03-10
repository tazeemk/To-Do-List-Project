package com.nt.MongoRepoSerivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Category;
import com.nt.repository.ICategoryMongoRepository;
@Service
public class CategoryServiceImpl implements ICategorySeriveRepo {

	@Autowired
	private ICategoryMongoRepository cateRepository;
	
	@Override
	public String addCategory(Category cat) {
		    cateRepository.save(cat);
		return "Category Added Successfully :";
	}
	
	@Override
	public List<Category> getCategory() {
	
		return cateRepository.findAll();
	}

}
