package com.lti.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.entity.PassengerDetails;


@Repository
public interface PassengerRepository extends JpaRepository<PassengerDetails, Integer> {

}
