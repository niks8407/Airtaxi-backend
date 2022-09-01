package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lti.dto.LoginDto;
import com.lti.entity.Flight;
import com.lti.entity.UserDetails;
import com.lti.exception.UserServiceException;
import com.lti.service.UserDetailsServices;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class UserRestController {

	@Autowired
	private UserDetailsServices userService;
	
	//Registration
	@PostMapping("/user-register")
	public ResponseEntity<UserDetails> addNewUser(@RequestBody UserDetails newUser){
		try {
			UserDetails user1 = userService.createUser(newUser);
			return new ResponseEntity<>(newUser,HttpStatus.CREATED);
		} catch (Exception e) {
	
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
   }
	
	//login
//	@PostMapping(path="/userlogin")
//	public UserDetails userLogin(@RequestBody LoginDto login) {
//		//System.out.println(login);
//		try {
//			UserDetails user = userService.userLogin(login.getEmail_Id(), login.getPassword());
//			if(user != null) {
//				Status status = new Status();
//				status.setStatus(Status.StatusType.SUCCESS);
//				status.setMessage("Login Successful!");
//				return user;
//			}
//			return null;
//		}
//		catch(Exception e) {
//			System.out.println(e);
//			return null;
//		}
//		
//	}
	@GetMapping("/user")
	public ResponseEntity<List<UserDetails>> getAllUsers(){
		try {
			List<UserDetails> ulist = new ArrayList<UserDetails>();
			ulist = userService.findAllUsers();
			if(ulist.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(ulist, HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	public static class Status {
		private StatusType status;
		private String message;
		
		
		public static enum StatusType{
			SUCCESS, FAILURE;
		}

		public StatusType getStatus() {
			return status;
		}

		public void setStatus(StatusType status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
	}

	
}