package com.lti.service;

import java.util.List;

import com.lti.entity.BookingDetails;
import com.lti.exception.NoBookingFoundException;

public interface BookingService {

	public BookingDetails addBooking(BookingDetails bookingDetails);
	public List<BookingDetails> showAllBooking();
	public BookingDetails findBookingById(int booking_id) throws NoBookingFoundException;
	public BookingDetails editBooking(int booking_id,BookingDetails bookingDetails);
	public BookingDetails cancelBooking(int booking_id) throws NoBookingFoundException;
	public List<BookingDetails> findBookingByEmail(String email_Id) throws NoBookingFoundException;
	
}
