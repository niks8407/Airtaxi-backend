package com.lti.service;

import java.util.List;

import com.lti.entity.Flight;
import com.lti.exception.NoFlightFoundException;

public interface FlightService {
	
	public Flight addFlight(Flight flight);
	public List<Flight> findAllFlights();
	public Flight findFlightById(int flight_id) throws NoFlightFoundException;
	public Flight updateFlightDetails(int flight_id,Flight flight);
	public Flight deleteFlight(int flight_id) throws NoFlightFoundException;

}
