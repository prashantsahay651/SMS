package com.sms.attendance;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Attendance;

@Controller
public class AttendanceController {

	@Autowired
	private AttendanceServiceImpl serviceImpl;
	private SimpleDateFormat sdf = new SimpleDateFormat("YYYY-mm-dd");
	
	@PostMapping("/WebSaveAttendance")
	public RedirectView addSchool(List<Attendance> studentAttendance,RedirectAttributes attributes ) {

		//date today to save attendance
		String day = sdf.format(new Date());
		serviceImpl.saveAttendance(day, studentAttendance);
		return new RedirectView("/saveattendance");
	}
}
