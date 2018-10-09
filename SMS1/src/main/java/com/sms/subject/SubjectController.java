package com.sms.subject;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Subject;

@Controller
public class SubjectController {
	
	@Autowired
	private SubjectServiceImpl subjectServiceImpl;
	int schoolId,flag;
	
	@PostMapping("/WebAddSubject")
	public RedirectView addSubject(HttpSession session,Subject subject, RedirectAttributes attributes) {
		schoolId = (int) session.getAttribute("schoolId");
		flag = subjectServiceImpl.addSubject(schoolId,subject);
		if (flag == 0) {
			attributes.addFlashAttribute("message", "Subject Already Exits");
			return new RedirectView("/addsubject");
		}
		attributes.addFlashAttribute("message", "Subject Sucessfully Added");
		return new RedirectView("/addsubject");
	}

}
