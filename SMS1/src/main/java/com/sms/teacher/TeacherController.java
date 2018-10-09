package com.sms.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Login;
import com.sms.beans.Teacher;

@Controller
public class TeacherController {

	@Autowired 
	private TeacherServiceImpl teacherServiceImpl;
	private int schoolId,flag;
	private Teacher teacher;
	
	@PostMapping("/WebAddTeacher")
	public RedirectView editStudent(Teacher teacher,HttpSession session,Login login) {
		schoolId = (int) session.getAttribute("schoolId");
		teacher.setLogin(login);
		flag=teacherServiceImpl.addTeacher(teacher,schoolId);
		if(flag==0) {
			session.setAttribute("message","Teacher Email Id: "+login.getEmailId()+" Already Exits");
			return new RedirectView("addteacher");
		}
		session.setAttribute("message","Teacher Added Sucesfully ");
		return new RedirectView("addteacher");	
	}
	
	
	@PostMapping("/WebSearchTeacher")
	public RedirectView searchTeacher(String teacherName,HttpSession session,RedirectAttributes attributes) {
		schoolId = (int) session.getAttribute("schoolId");
		List<Teacher> teachers=teacherServiceImpl.searchTeacher(teacherName,schoolId);
		if(teachers.size()>0) {
			attributes.addFlashAttribute("teachers",teachers);
			return new RedirectView("searchteacher");	
		}
		attributes.addFlashAttribute("message","No Teacher Found");
		return new RedirectView("searchteacher");	
	}
	
	@PostMapping("/WebEditTeacher")
	public RedirectView editTeacher(int actionId,int teacherId,RedirectAttributes attributes,Teacher teacher) {
		System.out.println(actionId);
		if(actionId==0) {
			teacher=teacherServiceImpl.getTeacherById(teacherId);
			attributes.addFlashAttribute("teacher",teacher);
			return new RedirectView("editteacher");	
		}
		if(actionId==1) {
			if(teacher.getTeacherId()==0) {
				attributes.addFlashAttribute("message","Something Went Wrong");
				return new RedirectView("/schoolhome");
			}
			teacher=teacherServiceImpl.editTeacher(teacher);
			attributes.addFlashAttribute("teacher",teacher);
			attributes.addFlashAttribute("message","Teacher Edited Sucessfully");
			return new RedirectView("editteacher");	
		}
		attributes.addFlashAttribute("message","Something Went Wrong");
		return new RedirectView("/schoolhome");	
	}
	
	@PostMapping("/WebViewTeacher")
	public RedirectView viewStudent(HttpServletRequest request,int teacherId,int actionId,RedirectAttributes attributes) {
		if(actionId==0) {
		teacher=teacherServiceImpl.getTeacherById(teacherId);
		attributes.addFlashAttribute("teacher",teacher);
		return new RedirectView("viewteacher");
		}
		return null;
	}
	
}
