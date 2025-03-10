package com.nt.videoService;

import java.util.List;

import com.nt.entity.Video;

public interface IVideoSerivceImp 
{

	public String addVideo(Video video);
	
	public List<Video>getVideo();
	
	public String removeVideoById(int id);
	
	public Video fetchVideoById(int id);
	
	public String modifyVideo(Video video);
	
	public List<Video>fetchVideoId(int num);
	
	public List<Video>fetchDynamicSearch(String name);
	
}
