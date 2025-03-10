package com.nt.videoService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Video;
import com.nt.repository.IAddVideoRepository;

@Service
public class VideoServiceImpl implements IVideoSerivceImp {

	@Autowired
	private IAddVideoRepository videoRepo;
	
	@Override
	public String addVideo(Video video) {
		  videoRepo.save(video);
		return "Video Added Successfully";
	}

	
	@Override
	public List<Video> getVideo() {
	     
		return videoRepo.findAll();
	}


	@Override
	public String removeVideoById(int id) {
		Optional<Video>op = videoRepo.findById(id);
		if(op.isPresent()) {
			   videoRepo.deleteById(id);
			   return "Video Delete Successfully";
		}else {
		throw new IllegalArgumentException("Id NOt Found :");
	}
}
	  @Override
	public Video fetchVideoById(int id) {
	 
		  Optional<Video> op=videoRepo.findById(id);
		  if(op.isPresent()) {
			  
			  Video video =op.get();
			  return video;
		  }else {
			  throw new IllegalArgumentException("Invalid Id");
		  }
	}
	  
	  @Override
	public String modifyVideo(Video video) {
	Optional<Video>op=videoRepo.findById(video.getVideoId());
	if(op.isPresent()) {
		videoRepo.save(video);
		return "updated Successfully";
	}else {
		  throw new IllegalArgumentException("invalid");
	}
	  }
	  
	  @Override
	public List<Video> fetchVideoId(int num) {
	           List<Video>list=videoRepo.fetchVideoById(num);
		  return list;
	}
	
	  @Override
	public List<Video> fetchDynamicSearch(String name) {
	List<Video>list=videoRepo.fetchDynamicSearch(name);
		  return list;
	}
	  
	}
