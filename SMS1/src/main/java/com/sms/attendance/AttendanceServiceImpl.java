package com.sms.attendance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.Attendance;
import com.sms.beans.AttendanceDate;
import com.sms.beans.Student;
import com.sms.student.StudentDAO;

@Service
public class AttendanceServiceImpl {

	@Autowired
	private AttendanceDateDAO attendanceDateDAO;

	@Autowired
	private AttendanceDAO attendanceDAO;

	@Autowired
	private StudentDAO studentDao;
	

	/**
	 * Input day in YYYY-mm-dd format, List of Attendance - studentId and presence/absence
	 * @param day
	 * @param attendanceList
	 * @return
	 */
	public int saveAttendance(String day, List<Attendance> attendanceList) {
		int retVal = 0;
		Student s;
		AttendanceDate attendanceDate = attendanceDateDAO.checkAttendanceDate(day);
		try {
			if (null == attendanceDate) {
				Date parsedDate=new SimpleDateFormat("yyyy-MM-dd").parse(day);   
				attendanceDate = new AttendanceDate();
				attendanceDate.setDay(parsedDate);
				attendanceDate = attendanceDateDAO.save(attendanceDate);
			}
			for (Attendance a : attendanceList) {
				a.setDay(attendanceDate);
				s = studentDao.getStudentById(a.getStudent().getStudentId());
				a.setStudent(s);
				attendanceDAO.save(a);
			}
		}
		catch (Throwable t) {
			retVal = 1;
			t.printStackTrace();
		}
		return retVal;
	}
	
}
