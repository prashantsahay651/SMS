package com.sms.homework;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.HomeWork;

public interface HomeWorkDAO extends JpaRepository<HomeWork,Integer> {

	@Query(value = "SELECT * from home_work where date=?1", nativeQuery = true)
	HomeWork fetchByDate(String date);	

}
