package com.sms.classsection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClassDAO extends JpaRepository<com.sms.beans.Class,Integer> {

	@Query(value = "SELECT class_name from class where class_name=?1 and school_id=?2", nativeQuery = true)
	String checkClassName(String className, int schoolId);
	
	

}
