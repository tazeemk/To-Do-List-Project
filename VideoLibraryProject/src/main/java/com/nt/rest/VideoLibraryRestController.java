package com.nt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.MongoRepoSerivce.ICategorySeriveRepo;
import com.nt.UserService.IUserServiceRepoImpl;
import com.nt.entity.AdminLogin;
import com.nt.entity.Category;
import com.nt.entity.User;
import com.nt.entity.Video;
import com.nt.service.IAdminServiceImp;
import com.nt.videoService.IVideoSerivceImp;

@RestController
@RequestMapping("video-api")
public class VideoLibraryRestController 
{
   @Autowired
	private IAdminServiceImp repo;
	
   @Autowired
   private ICategorySeriveRepo categoryRepo;
   
   
   @Autowired
   private IVideoSerivceImp videoRepo;
   
   
   @Autowired
   private IUserServiceRepoImpl userRepo;
   
   
	@GetMapping("get")
	public ResponseEntity<?>getAdmin(){
		
		List<AdminLogin>list=repo.getAdmin();
		return new ResponseEntity<List<AdminLogin>>(list,HttpStatus.OK);
	}
	
	//=========================Category=====================
	
	@PostMapping("add-category")
	public ResponseEntity<?>addCategory(@RequestBody Category cat)
	{
	 	  String msg= categoryRepo.addCategory(cat);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
	@GetMapping("get-category")
	public ResponseEntity<?>getCategory(){
		try {
			List<Category>list=categoryRepo.getCategory();
			return new ResponseEntity<List<Category>>(list,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	//=================Video=======================================
	
	@PostMapping("add-video")
	public ResponseEntity<?>addVideo(@RequestBody Video video){
		  String msg = videoRepo.addVideo(video);
	    return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping("get-video")
	public ResponseEntity<?>getVideos(){
		   List<Video>list=videoRepo.getVideo();
		return new ResponseEntity<List<Video>>(list,HttpStatus.OK);
	}
	
	@DeleteMapping("delete-video/{id}")
	public ResponseEntity<?>removeVideoById(@PathVariable String id)
	{   
		try {
	    	  int num = Integer.parseInt(id);
	          String msg=videoRepo.removeVideoById(num);
	          return new ResponseEntity<String>(msg,HttpStatus.OK);
	      }catch(Exception e) {
	    	  return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	      }
		
	}
	
	@GetMapping("video-id/{id}")
	public ResponseEntity<?>fetchVideoById(@PathVariable String id){
		
		int num = Integer.parseInt(id);
	  Video video = videoRepo.fetchVideoById(num);
	   return new ResponseEntity<Video>(video,HttpStatus.OK);	
	}
	
	@PutMapping("modify")
	public ResponseEntity<?>modifyVideo(@RequestBody Video video)
	{
		
		 String msg= videoRepo.modifyVideo(video);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
	@GetMapping("byid/{num}")
	public ResponseEntity<?>getVideoId(@PathVariable int num)
	{       // int id =Integer.parseInt(num);
		   List<Video>list=videoRepo.fetchVideoId(num);
	       return new ResponseEntity<List<Video>>(list,HttpStatus.OK);
	}
	
	
	@GetMapping("dynimic/{name}")
	public ResponseEntity<?>fetchDynamicSearch(@PathVariable String name){
		List<Video>list=videoRepo.fetchDynamicSearch(name);
		
		return new ResponseEntity<List<Video>>(list,HttpStatus.OK);
	}
	
	//=======================User=============================================
	
	@PostMapping("add-user")
	public ResponseEntity<?>addUser(@RequestBody User user){
		  
		           String msg =  userRepo.addUser(user);
		 
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping("get-user")
	public ResponseEntity<?>fetchAllUser(){
		  List<User>list=userRepo.fetchAllUser();
		
		  return new ResponseEntity<List<User>>(list,HttpStatus.OK);
	}
	

}
