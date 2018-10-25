package com.sms.timetable;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Period;
import com.sms.beans.PeriodSubjectMapping;
import com.sms.beans.School;
import com.sms.beans.Section;
import com.sms.beans.Subject;
import com.sms.beans.TimeTable;

@Controller
public class TimeTableController {

	@Autowired
	private TimeTableServiceImpl serviceImpl;
	
	@PostMapping("/WebAddPeriod")
	public RedirectView addPeriod(School school, Period period,RedirectAttributes attributes) {
		Period p = serviceImpl.savePeriod(school.getSchoolId(), period);
		attributes.addFlashAttribute("message", "Period Added Sucessfully");
		return new RedirectView("/addperiod");
	}

	@PostMapping("/WebDeletePeriod")
	public RedirectView deletePeriod(Period period,RedirectAttributes attributes, HttpSession session) {
		serviceImpl.deletePeriodById(period.getPeriodId());
		
		attributes.addFlashAttribute("message", "Period Deleted Sucessfully");
		return new RedirectView("/deleteperiod");	
	}

	@PostMapping("/WebAddTimeTable")
	public RedirectView addTimeTable(Section section, TimeTable tt, ServletRequest request, HttpSession session,
			RedirectAttributes attributes) {
		TimeTable ttsaved = serviceImpl.saveTimeTable(section.getSectionId(), tt);
		if (ttsaved == null) {
			attributes.addFlashAttribute("message", "Failed to Add TimeTable");
			return new RedirectView("/timetable");
		} else {
			session.setAttribute("timeTableId", ttsaved.getTimeTableId());
			return new RedirectView("/addtimetable");
		}

	}
	
	@PostMapping("/WebAddPeriodSubjectMapping")
	public RedirectView schoolLogin(TimeTable timeTable, Period p, Subject s, ServletRequest request, HttpSession session,
			RedirectAttributes attributes) {
		PeriodSubjectMapping periodSubjectMapping = serviceImpl.savePeriodSubjectMapping(timeTable.getTimeTableId(), p.getPeriodId(), s.getSubjectId());
		if (periodSubjectMapping == null) {
			attributes.addFlashAttribute("message", "Failed to Add PeriodSubject Mapping");
			return new RedirectView("/periodsubject");
		} else {
			attributes.addFlashAttribute("message", "Added PeriodSubject Mapping");
			return new RedirectView("/addperiodsubjectmapping");
		}
	}

}
