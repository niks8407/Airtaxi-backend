package com.lti.service;

import java.util.List;
import com.lti.entity.UserDetails;

public interface UserDetailsServices {
	public UserDetails createUser(UserDetails user);
	//public UserDetails userLogin(String email,String password);
	public List<UserDetails> findAllUsers();
}