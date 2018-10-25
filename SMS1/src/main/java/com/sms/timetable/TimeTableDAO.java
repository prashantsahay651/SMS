package com.sms.timetable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.TimeTable;

public interface TimeTableDAO extends JpaRepository<TimeTable,Integer> {

	@Query(value = "SELECT * from time_table where time_table_id=?1", nativeQuery = true)
	TimeTable fetchById(int timeTableId);	

}
