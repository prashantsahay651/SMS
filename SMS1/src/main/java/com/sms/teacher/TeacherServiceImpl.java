package com.sms.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.Login;
import com.sms.beans.School;
import com.sms.beans.Teacher;
import com.sms.login.LoginServiceImpl;
import com.sms.mail.MailService;
import com.sms.parent.ParentServiceImpl;
import com.sms.school.SchoolServiceImpl;
import com.sms.services.SMSServiceImpl;

@Service
public class TeacherServiceImpl {

	@Autowired
	private TeacherDAO teacherDAO;
	
	@Autowired
	private MailService mailService;

	@Autowired
	private SMSServiceImpl smsService;

	@Autowired
	private ParentServiceImpl parentServiceImpl;
	
	@Autowired
	private SchoolServiceImpl schoolServiceImpl;
	
	@Autowired
	private LoginServiceImpl loginServiceImpl;

	private String password;
	private School school;
	private Teacher teacher2;
	private List<Teacher> teachers; 
	private Login login;
	private int flag;
	private String username;

	public Teacher getTeacherByEmailId(String emailId, int schoolId) {

		return teacherDAO.getTeacherByEmailId(emailId, schoolId);
	}

	public int addTeacher(Teacher teacher, int schoolId) {
		flag = loginServiceImpl.checkEmailId(teacher.getLogin().getEmailId());
		if (flag < 0) {
			return flag;
		}
		flag = loginServiceImpl.checkMobileNumber(teacher.getLogin().getMobileNumber());
		if (flag < 0) {
			return flag;
		}
		
		
		password = smsService.generatePassword();
		username = smsService.generateUsername(teacher.getTeacherName());
		teacher.getLogin().setPassword(password);
		teacher.getLogin().setUsername(username);
		teacher.getLogin().setUser("teacher");
		
		
		
		school = schoolServiceImpl.getSchoolById(schoolId);
		teacher.setSchool(school);
		login=loginServiceImpl.saveLogin(teacher.getLogin());
		teacher2=teacherDAO.save(teacher);
		mailService.sendNewRegistrationMail(teacher.getLogin().getEmailId(),teacher.getLogin().getPassword());
		return teacher2.getTeacherId();

	}

	public List<Teacher> searchTeacher(String teacherName, int schoolId) {
		return teacherDAO.searchTeacher(teacherName,schoolId);
		 
	}

	public Teacher getTeacherById(int teacherId) {
		
		return teacherDAO.getOne(teacherId);
	}

	public Teacher editTeacher(Teacher teacher) {
		 	teacher2=teacherDAO.getOne(teacher.getTeacherId());
		 	teacher2.setTeacherName(teacher.getTeacherName());
			teacher2.setAddressLine1(teacher.getAddressLine1());
			teacher2.setAddressLine2(teacher.getAddressLine2());
			teacher2.setCity(teacher.getCity());
			teacher2.setDistrict(teacher.getDistrict());
			teacher2.setState(teacher.getState());
			teacher2.setPinCode(teacher.getPinCode());
			return teacherDAO.save(teacher2);	
	}

	public void save(Teacher teacher) {
		teacherDAO.save(teacher);
	}

}
