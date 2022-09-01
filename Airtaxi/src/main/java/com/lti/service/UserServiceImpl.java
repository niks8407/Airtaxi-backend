package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.lti.dao.UserDetailsRepository;
import com.lti.entity.Flight;
import com.lti.entity.UserDetails;
import com.lti.exception.UserServiceException;

@Service
public class UserServiceImpl implements UserDetailsServices {

	@Autowired
	private UserDetailsRepository uRepo;

	@Override
	@Transactional
	public UserDetails createUser(UserDetails user) {
		return uRepo.save(user);
	}

//	@Override
//	public UserDetails userLogin(String email, String password) {
//		try {
//			return uRepo.userLogin(email, password);
//		} catch (UserServiceException e) {
//
//			throw new UserServiceException("Incorrect email/password");
//		}
//	}

	@Override
	public List<UserDetails> findAllUsers() {
		List<UserDetails> ulist = uRepo.findAll();
		return ulist;
		}
	}
