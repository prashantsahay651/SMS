package com.sms.school;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Login;
import com.sms.beans.School;

@Controller
public class SchoolController {

	@Autowired
	private SchoolServiceImpl serviceImpl;


	private int flag;
	
	@PostMapping("/WebAddSchool")
	public RedirectView addSchool(School school,RedirectAttributes attributes,Login login) {
		
		login.setSchool(school);
		login.setUser("school");
		school.setLogin(login);
		flag=serviceImpl.addSchool(school);
		if(flag<0) {
			attributes.addFlashAttribute("message", "Email Id Already Exits");
			return new RedirectView("/addschool");
		}
		attributes.addFlashAttribute("message", "School Registered Sucessfully");
		return new RedirectView("/addschool");
	}

	
	@PostMapping("/WebEditSchool")
	public RedirectView editSchool(School school,RedirectAttributes attributes,int actionId,HttpSession session) {
		if(actionId==0) {
		school=serviceImpl.editSchool(school);
		session.setAttribute("school",school);
		attributes.addFlashAttribute("message", "School Edited Sucessfully");
		return new RedirectView("editschool");
		}
		return null;
		
		
	}

	@PostMapping("/WebSchoolLogin")
	public RedirectView schoolLogin(String emailId, String password, ServletRequest request, HttpSession session,
			RedirectAttributes attributes) {
		School school = serviceImpl.schoolLogin(emailId, password);
		if (school == null) {
			attributes.addFlashAttribute("message", "Invalid Email Id or Password");
			return new RedirectView("schoollogin");
		} else {
			session.setAttribute("schoolId", school.getSchoolId());
			return new RedirectView("schoolhome");
		}

	}

}
