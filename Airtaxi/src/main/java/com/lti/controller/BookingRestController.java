package com.lti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ViewBookingDto;
import com.lti.dto.ViewUserDto;
import com.lti.entity.BookingDetails;
import com.lti.exception.NoBookingFoundException;
import com.lti.service.BookingService;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class BookingRestController {
	
	@Autowired
	private BookingService bookSer;
	
	@GetMapping("/booking")
	public ResponseEntity<List<BookingDetails>> getAllBooking(){
		try {
			List<BookingDetails> blist = new ArrayList<BookingDetails>();
			blist = bookSer.showAllBooking();
			if(blist.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(blist, HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/booking")
	public ResponseEntity<BookingDetails> addBooking(@RequestBody BookingDetails newBooking){
		try {
			BookingDetails booking = bookSer.addBooking(newBooking);
			return new ResponseEntity<>(newBooking,HttpStatus.CREATED);
		} catch (Exception e) {
	
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
   }
	
//	@GetMapping("/booking/{bid}")
//	  public ResponseEntity<BookingDetails> getBookingById(@PathVariable("bid") int bid)throws NoBookingFoundException{
//		BookingDetails booking = bookSer.findBookingById(bid);
//		if (booking != null) {
//      	return new ResponseEntity<BookingDetails>(booking,HttpStatus.OK);
//	    } else {
//	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	  }
	@DeleteMapping("/booking/{bid}")
	 public ResponseEntity<BookingDetails> deleteBooking(@PathVariable int bid)throws NoBookingFoundException{
		try {
			BookingDetails oldBooking = bookSer.cancelBooking(bid);
			
			return new ResponseEntity<>(oldBooking, HttpStatus.OK);
    	}
    catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
 }
	
	  @GetMapping("/booking/{email_Id}")
	  public ResponseEntity<List<BookingDetails>> getBookingByEmail(@PathVariable("email_Id") String email_Id)throws NoBookingFoundException{
		List<BookingDetails> booking = bookSer.findBookingByEmail(email_Id);
		if (booking != null) {
  	return new ResponseEntity<>(booking,HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
//	  public ResponseEntity<List<BookingDetails>> getAllBooking(){
//			try {
//				List<BookingDetails> blist = new ArrayList<BookingDetails>();
//				blist = bookSer.showAllBooking();
//				if(blist.isEmpty()) {
//					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//				} else {
//					return new ResponseEntity<>(blist, HttpStatus.OK);
//				}
//
//			} catch (Exception e) {
//				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//			}

	
	
	
	
}
