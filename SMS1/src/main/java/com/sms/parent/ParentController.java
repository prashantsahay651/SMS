package com.sms.parent;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Parent;
import com.sms.beans.Student;
import com.sms.student.StudentServiceImpl;

@Controller
public class ParentController {
	
	@Autowired
	private ParentServiceImpl parentServiceImpl;
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	Student student;
	
	@PostMapping("/WebEditParent")
	public RedirectView editParent(Parent parent,int studentId,int actionId,HttpServletRequest request,RedirectAttributes attributes) {
		if(actionId==1) {
			parentServiceImpl.editParent(parent);
			student=studentServiceImpl.getStudentById(studentId);
			attributes.addFlashAttribute("editstudent",student);
			attributes.addFlashAttribute("message","Parent Edited Sucessfully");
			return new RedirectView("editStudent");
		}
		return null;
	}
	
	

}
