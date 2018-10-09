package com.sms.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.Login;

public interface LoginDAOImpl extends JpaRepository<Login,Integer>{

	@Query(value = "SELECT email_id from login where email_id=?1", nativeQuery = true)
	String checkEmailId(String emailId);

	@Query(value = "SELECT * from login where email_id=?1 and password=?2", nativeQuery = true)
	Login login(String emailId2, String password);
}
