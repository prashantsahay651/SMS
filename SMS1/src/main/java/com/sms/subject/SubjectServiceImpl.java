package com.sms.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.School;
import com.sms.beans.Subject;
import com.sms.school.SchoolServiceImpl;



@Service
public class SubjectServiceImpl {
	
	@Autowired
	private SubjectDAOImpl subjectDAO;
	
	@Autowired
	private SchoolServiceImpl schoolServiceImpl;
	
	private String subjectName;
	private School school;
	
	public int addSubject(int schoolId, Subject subject) {
		System.out.println(subject.getSubjectName());
		subjectName = subjectDAO.checkSubjectName(subject.getSubjectName(),schoolId);
		System.out.println(subjectName);
		if (subjectName != null) {
			System.out.println("hello");
			return 0;
		}
		school = schoolServiceImpl.getSchoolById(schoolId);
		subject.setSchool(school);
		subject=subjectDAO.save(subject);
		return subject.getSubjectId();
	}

	public Subject getSubjectById(int subjectId) {
		// TODO Auto-generated method stub
		return subjectDAO.getOne(subjectId);
	}


}
