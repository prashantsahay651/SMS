package com.sms.questionpaper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sms.beans.QuestionPaper;

@Controller
public class QuestionPaperController {
	
	@Autowired
	private QuestionPaperServiceImpl questionPaperServiceImpl;

	@PostMapping("/uploadFile")
	public String uploadQuestionPaper(@RequestParam("file") MultipartFile file,QuestionPaper questionPaper) {
		questionPaperServiceImpl.saveQuestionPaper(file, questionPaper);
		return null;
		
	}
}
