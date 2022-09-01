package com.lti.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lti.entity.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
	
//	@Query(value = " select count(u.profile_id) from UserDetails u where u.email_Id =: email")
//	int isUserPresent(String email);
//	
//	@Query(value = "Select u from UserDetails u where u.email_Id = :email and u.password = :password")
//	public UserDetails userLogin(String email,String password);
}
