package com.sms.eventcalender;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.EventCalender;
import com.sms.beans.School;
import com.sms.school.SchoolServiceImpl;

@Controller
public class EventCalenderController {

	@Autowired
	EventCalenderServiceImpl eventCalenderServiceImpl;

	@Autowired
	SchoolServiceImpl schoolServiceImpl;

	private int schoolId;

	private School school;

	@PostMapping("/WebAddEventCalender")
	public RedirectView addEventCalender(HttpSession session, RedirectAttributes attributes, EventCalender eventCalender) {

		schoolId = (int) session.getAttribute("schoolId");
		school = schoolServiceImpl.getSchoolById(schoolId);

		eventCalender.setSchool(school);
		eventCalender = eventCalenderServiceImpl.addEventCalender(eventCalender);
		if (eventCalender == null) {
			attributes.addFlashAttribute("message", "Something Went Wrong");
			return new RedirectView("addeventcalender");
		} else {
			attributes.addFlashAttribute("message", "Event Added Sucessfully");
			return new RedirectView("addeventcalender");
		}

	}
	
	@PostMapping("/WebDeleteEventCalender")
	public RedirectView deleteEventCalender(HttpSession session, RedirectAttributes attributes,int eventCalenderId) {
		try {
		 eventCalenderServiceImpl.deleteEventCalender(eventCalenderId);
		 attributes.addFlashAttribute("message", "Event Calender Deleted Sucessfully");
			return new RedirectView("vieweventcalender");
		}catch(Exception exception) {
			attributes.addFlashAttribute("message", "Something Went Wrong");
			return new RedirectView("vieweventcalender");
		}
	}

}
