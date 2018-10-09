package com.sms.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Class;
import com.sms.beans.Login;
import com.sms.beans.Parent;
import com.sms.beans.School;
import com.sms.beans.Section;
import com.sms.beans.Student;
import com.sms.beans.StudentRegistration;
import com.sms.classsection.ClassSectionSubjectServiceImpl;
import com.sms.school.SchoolServiceImpl;

@Controller
public class StudentController {

	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@Autowired
	SchoolServiceImpl schoolServiceImpl;
	
	@Autowired
	private ClassSectionSubjectServiceImpl classSectionSubjectServiceImpl;
	
	
	private int flag;
	private Parent parent;
	private int schoolId;
	private Student student1; 
	private School school;
	private StudentRegistration studentRegistration;
	private Student student;

	@PostMapping("WebAddStudent")
	public RedirectView saveStudent(Student student,Login login, String fathersName, String parentMobileNumber, String parentEmailId,
			Boolean question, HttpSession session,RedirectAttributes attributes) {
			schoolId = (int) session.getAttribute("schoolId");
			parent=new Parent();
			student.setLogin(login);
			parent.setFathersName(fathersName);
			Login login2=new Login();
			login2.setEmailId(parentEmailId);
			parent.setLogin(login2);
			parent.setMobileNumber(parentMobileNumber);
			flag=studentServiceImpl.addStudent(student,parent,schoolId,question);
			if(flag==0) {
				attributes.addFlashAttribute("message","Student Email Id: "+login.getEmailId()+" already Exits");
				return new RedirectView("addstudent");
			}if(flag==1) {
				attributes.addFlashAttribute("message","Parent Email Id: "+parentEmailId+" Doesnot  Exits");
				return new RedirectView("addstudent");
			}
			if(flag==2) {
				attributes.addFlashAttribute("message","Parent Email Id: "+parentEmailId+" already Exits");
				return new RedirectView("addstudent");
			}if(flag==3) {
				attributes.addFlashAttribute("message","Student Added Sucessfully");
				return new RedirectView("addstudent");
			}
			attributes.addFlashAttribute("message","Something Went Wrong");
			return new RedirectView("addstudent");
	}
	

	@PostMapping("/WebSearchStudent")
	public RedirectView searchStudent(HttpSession session,HttpServletRequest request,String studentName,RedirectAttributes attributes) {
		int schoolId = (int) session.getAttribute("schoolId");
		List<Student> students = studentServiceImpl.searchStudent(studentName,schoolId);
			request.setAttribute("students",students);
			if(students.size()>0) {
				attributes.addFlashAttribute("students",students);
				return new RedirectView("searchstudent");	
			}
			attributes.addFlashAttribute("message","No Student Found");
			return new RedirectView("searchstudent");
			
	}
	
	@PostMapping("/WebEditStudent")
	public RedirectView editStudent(int actionId,int studentId,HttpSession session,Student student,RedirectAttributes attributes) {
		
		if(actionId==0) {
			student=studentServiceImpl.getStudentById(studentId);
			attributes.addFlashAttribute("editstudent",student);
			return new RedirectView("editStudent");
		}else {
			student=studentServiceImpl.editStudent(student);
			attributes.addFlashAttribute("editstudent",student);
			attributes.addFlashAttribute("message","Student Edited Sucessfully");
			return new RedirectView("editStudent");
			
		}

	}
	
	@PostMapping("/WebViewStudent")
	public RedirectView viewStudent(HttpServletRequest request,int studentId,int actionId,RedirectAttributes attributes) {
		if(actionId==0) {
		student1=studentServiceImpl.getStudentById(studentId);
		attributes.addFlashAttribute("editstudent",student1);
		return new RedirectView("viewstudent");
		}
		return null;
	}
	
	@GetMapping("/WebDeleteStudent")
	public void deleteStudent() {
		studentServiceImpl.deleteStudent(18);
	}
	
	@PostMapping("/WebGetClass")
	@ResponseBody
	public void getClassList(int user_id,ServletResponse response) {
		school=schoolServiceImpl.getSchoolById(user_id);
		PrintWriter out;
		try {
			out = response.getWriter();
			List<com.sms.beans.Class> classes=school.getClasses();
			out.print("<option disabled selected>--Select Class--</option>");
			for (Class class1 : classes) {
				out.print("<option value='"+class1.getClassId()+"'>");
				out.print(class1.getClassName());
				out.print("</option>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@PostMapping("/WebGetSection")
	@ResponseBody
	public void getSectionList(int user_id,ServletResponse response) {
		System.out.println(user_id);
		Class class1=classSectionSubjectServiceImpl.getClassById(user_id);
		PrintWriter out;
		try {
			out = response.getWriter();
			List<Section> sections=class1.getSections();
			out.print("<option disabled selected>--Select Class--</option>");
			for (Section section : sections) {
				out.print("<option value='"+section.getSectionId()+"'>");
				out.print(section.getSectionName());
				out.print("</option>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@PostMapping("/WebRegisterStudent")
	public RedirectView registerStudent(StudentRegistration studentRegistration,RedirectAttributes attributes) {
		flag=studentServiceImpl.registerStudent(studentRegistration);
		if(flag==0) {
			attributes.addFlashAttribute("message","Student Id Already Exits");
			return new RedirectView("registerstudent");
		}
		if(flag==1) {
			attributes.addFlashAttribute("message","Parent Id Doesn't Exits");
			return new RedirectView("registerstudent");
		}
		if(flag==2) {
			attributes.addFlashAttribute("message","Parent Id Already Exits");
			return new RedirectView("registerstudent");
		}
		attributes.addFlashAttribute("message","Student Registered Sucessfully");
		return new RedirectView("registerstudent");
		
	}
	
	@PostMapping("/WebAcceptStudentRequest")
	public RedirectView acceptStudent(int id,HttpSession session,RedirectAttributes attributes) {
		schoolId = (int) session.getAttribute("schoolId");
		studentRegistration=studentServiceImpl.getStudentRegistrationById(id);
		student=new Student();
		student.setStudentName(studentRegistration.getStudentName());
		student.getLogin().setEmailId(studentRegistration.getStudentEmailId());
		student.setMobileNumber(studentRegistration.getStudentMobileNumber());
		
		parent=new Parent();
		parent.setFathersName(studentRegistration.getFathersName());
		parent.setMobileNumber(studentRegistration.getFatherMobileNumber());
		parent.getLogin().setEmailId(studentRegistration.getFatherEmailId());
	
		
		studentServiceImpl.acceptStudent(student,parent,schoolId,studentRegistration.isQuestion(),studentRegistration.getSectionId());
		studentServiceImpl.deleteRegsiterStudent(studentRegistration.getId());
		attributes.addFlashAttribute("message","Student Approved Sucessfully");
		return  new RedirectView("studentregisterrequestlist");
		
	}
	
	@PostMapping("/WebDeleteStudentRequest")
	public RedirectView deleteStudentRequest(int id,HttpSession session,RedirectAttributes attributes) {
		studentServiceImpl.deleteRegsiterStudent(id);
		attributes.addFlashAttribute("message","Student Deleted Sucessfully");
		return  new RedirectView("studentregisterrequestlist");
		
	}
}

