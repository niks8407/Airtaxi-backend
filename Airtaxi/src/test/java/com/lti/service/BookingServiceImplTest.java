package com.lti.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.dao.BookingRepository;
import com.lti.entity.BookingDetails;
import com.lti.exception.NoBookingFoundException;

@SpringBootTest
class BookingServiceImplTest {
	
	@Autowired
	private BookingRepository brepo;
	
	@Autowired
	private BookingService bser;
	

	@Test
	void testAddBooking() {
		BookingDetails b1 = new BookingDetails();
		b1.setBooking_id(2);
		b1.setAmount("5000");
		b1.setDepartureTime("12:05");
		BookingDetails b2 = bser.addBooking(b1);
		String a = b2.getDepartureTime();
		assertThat(a).isEqualTo("12:05");
	}
	
	@Test
	void testUpdateBooking() {
		BookingDetails b1 = new BookingDetails();
		b1.setBooking_id(2);
		b1.setAmount("5000");
		b1.setDepartureTime("12:05");
		BookingDetails b2 = bser.addBooking(b1);
		if(b2.getDepartureTime()=="12:05") {
			b2.setDepartureTime("02:05");
		}
		b2 = bser.editBooking(2, b2);
		String a = b2.getDepartureTime();
		assertThat(a).isEqualTo("02:05");
		
	}
	
	@Test
	void testGetBooking() {
		
		BookingDetails b1 = new BookingDetails();
		b1.setBooking_id(2);
		b1.setAmount("5000");
		b1.setDepartureTime("12:05");
		BookingDetails b2 = bser.addBooking(b1);
		b2.setBooking_id(3);
		b2.setAmount("8000");
		b2.setDepartureTime("04:05");
		b2 = bser.addBooking(b2);
		assertTrue(bser.showAllBooking().size()>1);
		
	}


}
