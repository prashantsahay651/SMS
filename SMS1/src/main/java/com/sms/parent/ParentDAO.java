package com.sms.parent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.Parent;

public interface ParentDAO extends JpaRepository<Parent, Integer>{

	@Query(value = "SELECT * from parent where email_id=?1", nativeQuery = true)
	Parent getParentByEmailId(String emailId);

}
