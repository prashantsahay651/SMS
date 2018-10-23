package com.sms.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sms.beans.News;
import com.sms.beans.School;
import com.sms.beans.Student;
import com.sms.beans.StudentRegistration;
import com.sms.mail.MailClient;
import com.sms.school.SchoolServiceImpl;
import com.sms.services.SMSServiceImpl;
import com.sms.student.StudentServiceImpl;

@Controller
public class WebPageController {
	
	@Autowired
	private SchoolServiceImpl serviceImpl;
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@Autowired
	private SMSServiceImpl smsServiceImpl;
	
	@Autowired
	private MailClient client;
	

	private School school;
	
	private List<Student> students;
	
	private News news;
	
	

	
	@GetMapping("/")
	public String index() {
		return "/index";
	}
	
	@GetMapping("/addschool")
	public String addschool() {
		return "/addschool";
	}
	
	@GetMapping("/login")
	public String schoollogin() {
		return "/login";
	}
	
	@GetMapping("/schoolhome")
	public String schoolhome() {
		return "/schoolhome";
	}
	
	@GetMapping("/editschool")
	public String editschool(HttpSession session,HttpServletRequest request,RedirectAttributes attributes) {
		int schoolId=(int) session.getAttribute("schoolId");
		school=serviceImpl.getSchoolById(schoolId);
		session.setAttribute("school",school);
		return "editschool";
	}
	
	@GetMapping("/addstudent")
	public String addstudent() {
		return "/addstudent";
	}
	
	@GetMapping("/searchstudent")
	public String searchstudent() {
		return "/searchstudent";
	}
	
	@GetMapping("/editStudent")
	public String editStudent() {
		return "/editStudent";
	}
	
	
	@GetMapping("/viewstudent")
	public String viewstudent() {
		return "/viewstudent";
	}
	
	@GetMapping("/addteacher")
	public String addteacher() {
		return "/addteacher";
	}
	
	@GetMapping("/searchteacher")
	public String searchteacher() {
		return "/searchteacher";
	}
	
	@GetMapping("/editteacher")
	public String editteacher() {
		return "/editteacher";
	}
	
	@GetMapping("/viewteacher")
	public String viewteacher() {
		return "/viewteacher";
	}
	
	@GetMapping("/addclass")
	public String addclass() {
		return "/addclass";
	}
	
	@GetMapping("/addsection")
	public String addsection(HttpSession session,HttpServletRequest request) {
		int schoolId=(int) session.getAttribute("schoolId");
		school=serviceImpl.getSchoolById(schoolId);
		request.setAttribute("classes",school.getClasses());
		return "/addsection";
	}
	
	@GetMapping("/addsubject")
	public String addsubject() {
		return "/addsubject";
	}
	
	@GetMapping("/registerstudent")
	public String registerstudent(HttpServletRequest request) {
		request.setAttribute("schools",serviceImpl.getAllSchool());
		
		return "/registerstudent";
	}
	
	@GetMapping("/studentregisterrequestlist")
	public String studentregisterrequestlist(HttpSession session) {
		int schoolId=(int) session.getAttribute("schoolId");
		List<StudentRegistration> registrations=studentServiceImpl.getstudentRegistrationList(schoolId);
		for (StudentRegistration studentRegistration : registrations) {
			System.out.println(studentRegistration.getStudentName());
		}
		session.setAttribute("registrations",registrations);
		return "/studentregisterrequestlist";
	}
	
	@GetMapping("/addsubjectteachettosection")
	public String addsubjectteachettosection(HttpSession session,HttpServletRequest request) {
		int schoolId=(int) session.getAttribute("schoolId");
		school=serviceImpl.getSchoolById(schoolId);
		request.setAttribute("classes",school.getClasses());
		request.setAttribute("subjects",school.getSubjects());
		request.setAttribute("teachers",school.getTeachers());
		return "/addsubjectteachettosection";
	}
	
	
	@GetMapping("/addclassteacher")
	public String addclassteacher(HttpSession session,HttpServletRequest request) {
		int schoolId=(int) session.getAttribute("schoolId");
		school=serviceImpl.getSchoolById(schoolId);
		request.setAttribute("classes",school.getClasses());
		request.setAttribute("teachers",school.getTeachers());
		return "/addclassteacher";
	}
	
	@GetMapping("/addstudenttosection")
	public String addstudenttosection(HttpSession session,HttpServletRequest request) {
		int schoolId=(int) session.getAttribute("schoolId");
		school=serviceImpl.getSchoolById(schoolId);
		students=studentServiceImpl.getStudentWithNoAllotatedSection(schoolId);
		request.setAttribute("classes",school.getClasses());
		request.setAttribute("students",students);
		return "/addstudenttosection";
	}
	
	@GetMapping("/adminlogin")
	public String adminlogin() {
		return "/adminlogin";
	}
	@GetMapping("/adminhome")
	public String adminhome() {
		return "/adminhome";
	}
	
	@GetMapping("/addnews")
	public String addnews() {
		return "/addnews";
	}
	
	@GetMapping("/viewnews")
	public String viewNews(HttpSession session,HttpServletRequest request) {
		int schoolId=(int) session.getAttribute("schoolId");
		school=serviceImpl.getSchoolById(schoolId);
		System.out.println(school.getNews());
		request.setAttribute("news",school.getNews());
		return "/viewnews";
	}
	
	@GetMapping("/editnews")
	public String editNews() {
		return "/editnews";
	}
	
	@GetMapping("/sendmessage")
	public void sendmessage() {
		client.prepareAndSend("prashantsahay651@gmail.com","hello");
	}
	
	/*@GetMapping("/mailTemplate")
	public String mailTemplate() {
		return "mailTemplate.html";
	}*/
	
	
}
