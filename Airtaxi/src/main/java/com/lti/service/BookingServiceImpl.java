package com.lti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.BookingRepository;
import com.lti.entity.BookingDetails;
import com.lti.exception.NoBookingFoundException;

@Service("bookingservice")
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository brepo;
	


	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public BookingDetails addBooking(BookingDetails bookingDetails) {

		brepo.save(bookingDetails);
		return bookingDetails;
	}

	@Override
	public List<BookingDetails> showAllBooking() {

		List<BookingDetails> bookingList = brepo.findAll();
		return bookingList;

	}

	@Transactional
	@Override
	public BookingDetails editBooking(int booking_id, BookingDetails bookingDetails) {

		return brepo.save(bookingDetails);
	}

	@Transactional
	@Override
	public BookingDetails cancelBooking(int booking_id) throws NoBookingFoundException {
		Optional<BookingDetails> bookingFind = brepo.findById(booking_id);
		BookingDetails bookingDetails = null;
		if (bookingFind.isPresent()) {
			bookingDetails = bookingFind.get();
			brepo.delete(bookingDetails);
		} else {
			throw new NoBookingFoundException("Booking Not Found");
		}
		return bookingDetails;
	}

	@Override
	public BookingDetails findBookingById(int booking_id) throws NoBookingFoundException {
		Optional<BookingDetails> findBooking = brepo.findById(booking_id);
		BookingDetails bookingDetails = null;
		if (findBooking.isPresent()) {
			bookingDetails = findBooking.get();
		} else {
			throw new NoBookingFoundException("No Booking Found");
		}
		return bookingDetails;
	}


	@Override
	public List<BookingDetails> findBookingByEmail(String email_Id) throws NoBookingFoundException {
		Optional<List<BookingDetails>> findBooking = Optional.of(brepo.findBookingByEmail(email_Id));
		List<BookingDetails> bookingDetails = null;
		if (findBooking.isPresent()) {
			bookingDetails = findBooking.get();
		} else {
			throw new NoBookingFoundException("No Booking Found");
		}
		return bookingDetails;
}

}
