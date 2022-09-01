package com.lti.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.dao.FlightRepository;
import com.lti.entity.BookingDetails;
import com.lti.entity.Flight;

@SpringBootTest
class FlightServiceImplTest {

	@Autowired
	private FlightService fser;
	
	@Autowired
	private FlightRepository frepo;
	
	@Test
	void testAddFlight() {
		Flight f1 = new Flight();
		f1.setFlight_id(101);
		f1.setCapacity(50);
		f1.setBusinessPrice(12000);
		Flight f2 = fser.addFlight(f1);
		int a =f2.getCapacity();
		assertThat(a).isEqualTo(50);
	}
	
	@Test
	void testUpdateFlight() {
		
		Flight f1 = new Flight();
		f1.setFlight_id(101);
		f1.setCapacity(50);
		f1.setBusinessPrice(12000);
		Flight f2 = fser.addFlight(f1);
		if(f2.getBusinessPrice()==12000) {
			f2.setBusinessPrice(15000);
		}
		double a =f2.getBusinessPrice();
		assertThat(a).isEqualTo(15000);
		
	}
	
	@Test
	void testGetFlight() {
		
		Flight f1 = new Flight();
		f1.setFlight_id(101);
		f1.setCapacity(50);
		f1.setBusinessPrice(12000);
		Flight f2 = fser.addFlight(f1);
		f2.setFlight_id(102);
		f2.setCapacity(80);
		f2 = fser.addFlight(f2);
		assertTrue(fser.findAllFlights().size()>1);
		
	}


}

