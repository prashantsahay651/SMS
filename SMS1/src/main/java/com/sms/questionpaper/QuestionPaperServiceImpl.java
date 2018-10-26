package com.sms.questionpaper;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sms.beans.QuestionPaper;

@Service
public class QuestionPaperServiceImpl {

	@Autowired
	private QuestionPaperDAO questionPaperDAO;

	private String fileName;

	public QuestionPaper saveQuestionPaper(MultipartFile file, QuestionPaper questionPaper) {

		fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				return null;
			}
			questionPaper.setFileName(fileName);
			questionPaper.setFileType(file.getContentType());
			questionPaper.setData(file.getBytes());
			return questionPaperDAO.save(questionPaper);

		} catch (IOException ex) {
			return null;
		}

	}
	
	 public QuestionPaper getQuestionPaper(int id) {
	        return questionPaperDAO.getOne(id);
	                
	    }
	 
	 public ResponseEntity<byte[]> getFile(int id) {
			QuestionPaper questionPaper = questionPaperDAO.getOne(id);
				return ResponseEntity.ok()
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + questionPaper.getFileName() + "\"")
						.body(questionPaper.getData());
		}

}
