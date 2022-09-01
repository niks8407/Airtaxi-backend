package com.lti.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lti.entity.BookingDetails;

@Repository
public interface BookingRepository extends JpaRepository<BookingDetails, Integer> { 
	
	@Query(value = "Select b from BookingDetails b where b.email_Id = :email_Id")
	public List<BookingDetails> findBookingByEmail(String email_Id);

}
