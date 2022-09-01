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

import com.lti.entity.Flight;
import com.lti.service.FlightService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class SearchFlight {
	
	@Autowired
	private FlightService fser;
	
	@GetMapping("/flight")
	public ResponseEntity<List<Flight>> getAllFlights(){
		try {
			List<Flight> flist = new ArrayList<Flight>();
			flist = fser.findAllFlights();
			if(flist.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(flist, HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/flight")
	public ResponseEntity<Flight> addNewFlight(@RequestBody Flight newFlight){
		try {
			Flight flight1 = fser.addFlight(newFlight);
			return new ResponseEntity<>(newFlight,HttpStatus.CREATED);
		} catch (Exception e) {
	
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
   }

}
