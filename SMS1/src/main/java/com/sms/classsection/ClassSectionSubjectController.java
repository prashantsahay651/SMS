package com.sms.classsection;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Class;
import com.sms.beans.Section;
import com.sms.beans.Subject;
import com.sms.beans.Teacher;
import com.sms.subject.SubjectServiceImpl;

@Controller
public class ClassSectionSubjectController {

	@Autowired
	private ClassSectionSubjectServiceImpl classSectionServiceImpl;

	private int schoolId;
	private int flag;
	
	

	@PostMapping("/WebAddClass")
	public RedirectView addClass(HttpSession session, Class class1, RedirectAttributes attributes) {
		schoolId = (int) session.getAttribute("schoolId");
		flag = classSectionServiceImpl.addClass(schoolId, class1);
		if (flag == 0) {
			attributes.addFlashAttribute("message", "Class Already Exits");
			return new RedirectView("/addclass");
		}
		attributes.addFlashAttribute("message", "Class Sucessfully Added");
		return new RedirectView("/addclass");
	}
	
	@PostMapping("/WebAddSection")
	public RedirectView addSection(HttpSession session, Class class1, RedirectAttributes attributes,Section section) {
		schoolId = (int) session.getAttribute("schoolId");
		flag = classSectionServiceImpl.addSection(schoolId, class1,section);
		if (flag == 0) {
			attributes.addFlashAttribute("message", "Section Already Exits");
			return new RedirectView("/addsection");
		}
		attributes.addFlashAttribute("message", "Section Sucessfully Added");
		return new RedirectView("/addsection");
	}
	
	@PostMapping("/WebAddSubjectToSection")
	public RedirectView addSubjectToSection(HttpSession session,RedirectAttributes attributes,int sectionId,int subjectId,int teacherId) {
		
		schoolId = (int) session.getAttribute("schoolId");
		flag=classSectionServiceImpl.addSubjectToSection(sectionId,subjectId,teacherId);
		if (flag<0) {
			attributes.addFlashAttribute("message", "Subject Already Exits");
			return new RedirectView("/addsubjectteachettosection");
		}
		attributes.addFlashAttribute("message", "Subject Sucessfully Added");
		return new RedirectView("/addsubjectteachettosection");
		
	}
	
	@PostMapping("/WebAddClassTeacher")
	public RedirectView addClassTeacher(HttpSession session,RedirectAttributes attributes,int sectionId,int teacherId) {
		
		schoolId = (int) session.getAttribute("schoolId");
		flag=classSectionServiceImpl.addClassTeacher(sectionId,teacherId);
		if (flag<0) {
			attributes.addFlashAttribute("message", "Class Teacher Already Exits");
			return new RedirectView("/addclassteacher");
		}
		attributes.addFlashAttribute("message", "Class Teacher Sucessfully Added");
		return new RedirectView("/addclassteacher");
		
	}
	
	@PostMapping("/WebAddStudentToSection")
	public RedirectView addStudentToSection(HttpSession session,RedirectAttributes attributes,int sectionId,int studentId) {
		
		schoolId = (int) session.getAttribute("schoolId");
		flag=classSectionServiceImpl.addStudentToSection(sectionId,studentId);
		attributes.addFlashAttribute("message", "Student Sucessfully Added");
		return new RedirectView("/addclassteacher");
		
	}
	
	
}
