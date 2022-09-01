package com.lti.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lti.entity.Flight;
import com.lti.exception.NoFlightFoundException;
import com.lti.service.FlightService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class FlightRestController {

	@Autowired
	private FlightService fser;
	
	@GetMapping("/adminflight")
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
	@PostMapping("/adminflight")
	public ResponseEntity<Flight> addNewFlight(@RequestBody Flight newFlight){
		try {
			Flight flight1 = fser.addFlight(newFlight);
			return new ResponseEntity<>(newFlight,HttpStatus.CREATED);
		} catch (Exception e) {
	
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
   }
	
	@GetMapping("/adminflight/{fid}")
	  public ResponseEntity<Flight> getFlightById(@PathVariable("fid") int fid)throws NoFlightFoundException{
		Flight flight1 = fser.findFlightById(fid);
		if (flight1 != null) {
      	return new ResponseEntity<Flight>(flight1,HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@DeleteMapping("/adminflight/{fid}")
	 public ResponseEntity<Flight> deleteFlight(@PathVariable int fid)throws NoFlightFoundException{
		try {
			Flight oldFlight = fser.deleteFlight(fid);
			
			return new ResponseEntity<>(oldFlight, HttpStatus.OK);
    	}
    catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
 }
	@PutMapping("/adminflight/{fid}")
	  public ResponseEntity<Flight> modifyFlight(@PathVariable("fid") int fid, @RequestBody Flight f) {
	    Flight flight1 = fser.updateFlightDetails(fid,f);
      if (flight1 != null) {
	      flight1.setFlight_id(fid);;
	      flight1.setFlightName(f.getFlightName());
	      flight1.setArrivalTime(f.getArrivalTime());
	      flight1.setBusinessPrice(f.getBusinessPrice());
	      flight1.setEconomyPrice(f.getEconomyPrice());
	      flight1.setSource(f.getSource());
	      flight1.setDestination(f.getDestination());
	      flight1.setDepartureTime(f.getDepartureTime());
	      return new ResponseEntity<>(flight1, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	
}
