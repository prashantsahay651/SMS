package com.sms.school;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Login;
import com.sms.beans.News;
import com.sms.beans.School;

@Controller
public class SchoolController {

	@Autowired
	private SchoolServiceImpl serviceImpl;

	private int flag;

	private int schoolId;
	
	private News news;

	@PostMapping("/WebAddSchool")
	public RedirectView addSchool(School school, RedirectAttributes attributes, Login login) {

		login.setSchool(school);
		login.setUser("school");
		school.setLogin(login);
		flag = serviceImpl.addSchool(school);
		if (flag < 0) {
			attributes.addFlashAttribute("message", "Email Id Already Exits");
			return new RedirectView("/addschool");
		}
		attributes.addFlashAttribute("message", "School Registered Sucessfully");
		return new RedirectView("/addschool");
	}

	@PostMapping("/WebEditSchool")
	public RedirectView editSchool(School school, RedirectAttributes attributes, int actionId, HttpSession session) {
		if (actionId == 0) {
			school = serviceImpl.editSchool(school);
			session.setAttribute("school", school);
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
			return new RedirectView("adminlogin");
		} else {
			session.setAttribute("schoolId", school.getSchoolId());
			return new RedirectView("adminhome");
		}

	}

	@PostMapping("/WebAddNews")
	public RedirectView AddNews(News news, ServletRequest request, HttpSession session, RedirectAttributes attributes) {
		System.out.println("in news controller");
		schoolId = (int) session.getAttribute("schoolId");
		news=serviceImpl.addNews(news,schoolId);
		if (news == null) {
			attributes.addFlashAttribute("message", "Something Went Wrong");
			return new RedirectView("addnews");
		} else {
			attributes.addFlashAttribute("message", "News Added Sucessfully");
			return new RedirectView("addnews");
		}

	}
	@PostMapping("/WebDeleteNews")
	public RedirectView deleteNews(int newsId, ServletRequest request, HttpSession session, RedirectAttributes attributes) {
		serviceImpl.deleteNews(newsId);
		
			attributes.addFlashAttribute("message", "News Deleted Sucessfully");
			return new RedirectView("viewnews");
		

	}
	
	@PostMapping("/WebEditNews")
	public RedirectView editNews(News news, ServletRequest request, HttpSession session, RedirectAttributes attributes,int newsId,int actionId) {
		if(actionId==1) {
		news=serviceImpl.getNewsById(newsId);
		session.setAttribute("news",news);
		return new RedirectView("editnews");
		}
			serviceImpl.editNews(news);
			attributes.addFlashAttribute("message", "News Edited Sucessfully");
			return new RedirectView("editnews");
		

	}
}
