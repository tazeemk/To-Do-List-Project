package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Video;

public interface IAddVideoRepository extends JpaRepository<Video, Integer> 
{

	
	@Query(" from Video where categoryId=:num")
	public List<Video>fetchVideoById(int num);
	
	@Query("from Video where title like %:name%")
	public List<Video>fetchDynamicSearch(String name);
	
}
