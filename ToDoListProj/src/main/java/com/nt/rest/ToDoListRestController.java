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

import com.nt.entity.Appointment;
import com.nt.entity.User;
import com.nt.service.IUserAppointmentServiceRepo;

@RestController
@RequestMapping("proj-api")
public class ToDoListRestController 
{

	@Autowired
	private IUserAppointmentServiceRepo userRepo;
	
	
	
	@PostMapping("add-user")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		
		try {
		String msg = userRepo.addUser(user);
		System.out.println(user);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		}


	  @GetMapping("get/{username}/{password}")
        public ResponseEntity<?>checkCredentials(@PathVariable String username,@PathVariable String password){
        
        	try {
        Object[] user	=userRepo.getCredentials(username, password);
        
          return new ResponseEntity<Object[]>(user,HttpStatus.OK);
        	}catch(Exception e) {
        		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        	}
        }
	
	    @GetMapping("all")
	    public ResponseEntity<?>getAllUser(){
	    	
	    	 List<User>list =userRepo.getAllUser();
	       return new ResponseEntity<List<User>>(list,HttpStatus.OK);
	    }
	    
	    @PostMapping("add-appointment")
	    public ResponseEntity<?>addAppointment(@RequestBody Appointment appoint){
	    	try {
	    		       String msg  =userRepo.registerUser(appoint);             
	    		                  
	    		return new ResponseEntity<String>(msg,HttpStatus.OK);
	    	}catch(Exception e) {
	    		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    }
	    
	    
	    @GetMapping("get-appointment/{userName}")
	    public ResponseEntity<?>findBYUserName(@PathVariable String userName){
	    	try {
	    		  List<Appointment>list =userRepo.getAppointments(userName);
	    		return new ResponseEntity<List<Appointment>>(list,HttpStatus.OK);
	    	}catch(Exception e) {
	    		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    	
	    }
	    
	    @GetMapping("getId/{id}")
	    public ResponseEntity<?>getAppointmentById(@PathVariable String id){
	    	try {
	    		 
	    		 Integer num = Integer.parseInt(id);
	    		 
	    		Appointment ap =userRepo.findByappointment(num);
	    		
	    		return new ResponseEntity<Appointment>(ap,HttpStatus.OK);
	    	}catch(Exception e) {
	    		return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	    	}
	    }
	    
	    @PutMapping("update-appoint")
	    public ResponseEntity<?>updateAppointment(@RequestBody Appointment app){
	    	
	    	String aa=userRepo.updateAppointment(app);
	    return new ResponseEntity<String>(aa,HttpStatus.OK);
	    }
	    
	    
	    @DeleteMapping("remove/{id}")
	    public ResponseEntity<?>removeAppointment(@PathVariable String id){
	    	
	    	int num = Integer.parseInt(id);
	    	String msg = userRepo.removeAppointmentById(num);
	    	return new ResponseEntity<String>(msg,HttpStatus.OK);
	    }
	    
	    

}
