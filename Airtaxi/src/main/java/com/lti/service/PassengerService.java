package com.lti.service;

import java.util.List;

import com.lti.entity.PassengerDetails;

public interface PassengerService {

	public PassengerDetails addPassenger(PassengerDetails passenger);
	public List<PassengerDetails> showAllPassenger();
	public PassengerDetails removePassenger(int passenger_id);
	
}
