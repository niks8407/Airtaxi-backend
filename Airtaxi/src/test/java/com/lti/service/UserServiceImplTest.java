package com.lti.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.dao.UserDetailsRepository;
import com.lti.entity.UserDetails;

@SpringBootTest
class UserServiceImplTest {

	@Autowired
	private UserDetailsServices usero;
	
	@Autowired
	private UserDetailsRepository urepo;
	
	@Test
	void testAddUser() {
		UserDetails u1 = new UserDetails();
		u1.setEmail_Id("abc@lti.com");
		u1.setFirstName("Nikhil");
		UserDetails u2 = usero.createUser(u1);
		String a = u2.getFirstName();
		assertThat(a).isEqualTo("Nikhil");
	}
	

}
