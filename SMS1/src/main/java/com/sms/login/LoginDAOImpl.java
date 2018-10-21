package com.sms.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.Login;

public interface LoginDAOImpl extends JpaRepository<Login,Integer>{

	@Query(value = "SELECT email_id from login where email_id=?1", nativeQuery = true)
	String checkEmailId(String emailId);
	
	

	@Query(value = "SELECT * from login where email_id=?1 and password=?2", nativeQuery = true)
	Login emailLogin(String username, String password);
	
	@Query(value = "SELECT * from login where mobile_number=?1 and password=?2", nativeQuery = true)
	Login mobileNumberLogin(String username, String password);
	
	@Query(value = "SELECT * from login where username=?1 and password=?2", nativeQuery = true)
	Login usernameLogin(String username, String password);

	
}
