package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.PassengerDetails;
import com.lti.service.PassengerService;

@RestController
public class PassengerRestController {
	
	@Autowired
	private PassengerService pser;
	
	@GetMapping("/passenger")
	public ResponseEntity<List<PassengerDetails>> getAllPassenger(){
		try {
			List<PassengerDetails> plist = new ArrayList<PassengerDetails>();
			plist = pser.showAllPassenger();
			if(plist.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(plist, HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/passenger")
	public ResponseEntity<PassengerDetails> addPassenger(@RequestBody PassengerDetails newPassenger){
		try {
			PassengerDetails passenger = pser.addPassenger(newPassenger);
			return new ResponseEntity<>(newPassenger,HttpStatus.CREATED);
		} catch (Exception e) {
	
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
   }
	
	@DeleteMapping("/passenger/{pid}")
	 public ResponseEntity<PassengerDetails> deletePassenger(@PathVariable int pid){
		try {
			PassengerDetails oldPassenger = pser.removePassenger(pid);
			
			return new ResponseEntity<>(oldPassenger, HttpStatus.OK);
   	}
   catch (Exception e) {
     return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
   }
	}
}
