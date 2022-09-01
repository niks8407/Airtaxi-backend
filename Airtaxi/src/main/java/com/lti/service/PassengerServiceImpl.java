package com.lti.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.lti.dao.PassengerRepository;
import com.lti.entity.PassengerDetails;
@Service
public class PassengerServiceImpl implements PassengerService {
	
	
	@Autowired
	private PassengerRepository prepo;
	

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@Override
	public PassengerDetails addPassenger(PassengerDetails passenger) {

		prepo.save(passenger);
		return passenger;
	}

	@Override
	public List<PassengerDetails> showAllPassenger() {
		List<PassengerDetails> passengerList = prepo.findAll();
		return passengerList;
	}

	@Override
	public PassengerDetails removePassenger(int passenger_id) {
		Optional<PassengerDetails> passengerFind = prepo.findById(passenger_id);
		PassengerDetails passengerDetails = null;
		if (passengerFind.isPresent()) {
			passengerDetails = passengerFind.get();
			prepo.delete(passengerDetails);
			return passengerDetails;
		} else {
			return null;
	}
	}

}
