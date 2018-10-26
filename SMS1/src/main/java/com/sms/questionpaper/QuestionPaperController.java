package com.sms.questionpaper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Class;
import com.sms.beans.QuestionPaper;
import com.sms.beans.Section;
import com.sms.beans.Subject;
import com.sms.classsection.ClassSectionSubjectServiceImpl;
import com.sms.subject.SubjectServiceImpl;

@Controller
public class QuestionPaperController {
	
	@Autowired
	private QuestionPaperServiceImpl questionPaperServiceImpl;
	
	@Autowired
	private ClassSectionSubjectServiceImpl ClassSectionSubjectServiceImpl; 
	
	@Autowired
	private SubjectServiceImpl subjectServiceImpl;
	
	private Class class1;
	
	private Subject subject;
	
	

	@PostMapping("/WebAddQuestionPaper")
	public RedirectView uploadQuestionPaper(@RequestParam("file") MultipartFile file,QuestionPaper questionPaper,int classId,int subjectId,RedirectAttributes attributes) {
		class1=ClassSectionSubjectServiceImpl.getClassById(classId);
		subject=subjectServiceImpl.getSubjectById(subjectId);
		questionPaper.setClass1(class1);
		questionPaper.setSubject(subject);
		questionPaper=questionPaperServiceImpl.saveQuestionPaper(file, questionPaper);
		if (questionPaper == null) {
			attributes.addFlashAttribute("message", "Something Went Wrong");
			return new RedirectView("addquestionpaper");
		} else {
			attributes.addFlashAttribute("message", "Question Paper Added Sucessfully");
			return new RedirectView("addquestionpaper");
		}
		
	}
	
	
}
