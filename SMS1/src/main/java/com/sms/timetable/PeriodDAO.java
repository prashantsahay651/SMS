package com.sms.timetable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.Period;

public interface PeriodDAO extends JpaRepository<Period,Integer> {

	@Query(value = "SELECT * from period where periodId=?1", nativeQuery = true)
	Period fetchPeriod(int periodId);	
}
