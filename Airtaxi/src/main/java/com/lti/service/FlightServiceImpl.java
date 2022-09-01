package com.lti.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.FlightRepository;
import com.lti.entity.Flight;
import com.lti.exception.NoFlightFoundException;

@Service("flightservice")
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository frepo;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Flight addFlight(Flight flight) {
		frepo.save(flight);
		return flight;
	}

	@Override
	public List<Flight> findAllFlights() {
		List<Flight> flist = frepo.findAll();
		return flist;
	}

	@Override
	public Flight findFlightById(int flight_id) throws NoFlightFoundException {
		Optional<Flight> findFlight = frepo.findById(flight_id);
		Flight flight = null;
		if(findFlight.isPresent()) {
			flight = findFlight.get();
		}else {
			throw new NoFlightFoundException("Flight Not Found");
		}
		return flight;
	}

	@Override
	@Transactional
	public Flight updateFlightDetails(int flight_id, Flight flight) {
		return frepo.save(flight);
	}

	@Override
	@Transactional
	public Flight deleteFlight(int flight_id) throws NoFlightFoundException {
		Optional<Flight> findFlight = frepo.findById(flight_id);
		Flight flight = null;
		if(findFlight.isPresent()) {
			flight = findFlight.get();
			frepo.delete(flight);
		}else {
			throw new NoFlightFoundException("Flight Not Found");
		}
		return flight;
	}

}
