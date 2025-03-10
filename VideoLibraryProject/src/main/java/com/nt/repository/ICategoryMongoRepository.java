package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.entity.Category;

public interface ICategoryMongoRepository extends MongoRepository<Category, Integer> {

}
