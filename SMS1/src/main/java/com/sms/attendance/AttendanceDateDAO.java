package com.sms.attendance;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sms.beans.AttendanceDate;

@Repository
public interface AttendanceDateDAO extends JpaRepository<AttendanceDate,Integer> {

	@Query(value = "SELECT * from attendanceDate where day=STR_TO_DATE(?1,\"%Y-%m-%d\")", nativeQuery = true)
	AttendanceDate checkAttendanceDate(String day);

}
