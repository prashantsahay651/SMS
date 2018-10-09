package com.sms.school;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sms.beans.School;

@Repository
public interface SchoolDAO extends JpaRepository<School, Integer> {
	
	 @Query(value = "SELECT * FROM school2 where email_id=?1 and password=?2", nativeQuery = true)
	 School schoolLogin(String emailId,String password);

	@Query(value = "SELECT email_id from school2 where email_id=?1", nativeQuery = true)
	String checkCheckEmailId(String emailId);
	
	

}
