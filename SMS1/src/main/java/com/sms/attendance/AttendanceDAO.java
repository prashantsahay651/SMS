package com.sms.attendance;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.Attendance;

public interface AttendanceDAO extends JpaRepository<Attendance,Integer> {

	@Query(value = "SELECT * from attendance where day=?1 and student_id=?2", nativeQuery = true)
	Attendance checkStudentAttendance(Date day, int studentId);	

}
