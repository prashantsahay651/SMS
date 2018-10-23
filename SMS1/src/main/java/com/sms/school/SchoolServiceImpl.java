package com.sms.school;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.Login;
import com.sms.beans.News;
import com.sms.beans.School;
import com.sms.login.LoginDAOImpl;
import com.sms.login.LoginServiceImpl;
import com.sms.services.SMSServiceImpl;

@Service
public class SchoolServiceImpl {

	@Autowired
	private SchoolDAO schoolDAO;
	
	@Autowired
	private LoginServiceImpl loginServiceImpl;
	
	@Autowired
	private SMSServiceImpl smsServiceImpl;
	
	@Autowired
	private LoginDAOImpl loginDAOImpl;
	
	@Autowired
	private NewsDAO newsDAO;

	private School school2;
	
	private int flag;
	
	private String password;
	
	private String username;
	
	private News news;
	
	public School saveSchool(School school) {
		return schoolDAO.save(school);
	}
	
	public void deleteSchoolById(int schoolId) {
		schoolDAO.deleteById(schoolId);
	}
	
	public School schoolLogin(String emailId, String password) {
		
		return schoolDAO.schoolLogin(emailId, password);
	}

	public String checkCheckEmailId(String emailId) {
		return schoolDAO.checkCheckEmailId(emailId);
		
		
	}

	public School getSchoolById(int schoolId) {
		// TODO Auto-generated method stub
		return schoolDAO.getOne(schoolId);
	}

	public School editSchool(School school) {
		school2 = schoolDAO.getOne(school.getSchoolId());
		school2.setAlternateMobileNumber(school.getAlternateMobileNumber());
		school2.setAddressLine1(school.getAddressLine1());
		school2.setAddressLine2(school.getAddressLine2());
		school2.setCity(school.getCity());
		school2.setDistrict(school.getDistrict());
		school2.setState(school.getState());
		school2.setPinCode(school.getPinCode());
		return schoolDAO.save(school2);
		
	}

	public List<School> getAllSchool() {
		return schoolDAO.findAll();
	}

	public int addSchool(School school) {
		flag=loginServiceImpl.checkEmailId(school.getLogin().getEmailId());
		if(flag<0) {
			return flag;
		}
		flag=loginServiceImpl.checkMobileNumber(school.getLogin().getMobileNumber());
		if(flag<0)
			return flag;
		password=smsServiceImpl.generatePassword();
		username=smsServiceImpl.generateUsername(school.getSchoolName());
		school.getLogin().setPassword(password);
		school.getLogin().setUsername(username);
		loginDAOImpl.save(school.getLogin());
		schoolDAO.save(school);
		return 1;
	}

	public News addNews(News news, int schoolId) {
		news.setSchool(schoolDAO.getOne(schoolId));
		return newsDAO.save(news);
	}

	public void deleteNews(int newsId) {
		// TODO Auto-generated method stub
		 newsDAO.deleteById(newsId);
	}

	public News getNewsById(int newsId) {
		
		return newsDAO.getOne(newsId);
	}

	public void editNews(News news1) {
			news=newsDAO.getOne(news1.getNewsId());
			news.setTitle(news1.getTitle());
			news.setNewsBody(news1.getNewsBody());
			newsDAO.save(news);
	}
}
