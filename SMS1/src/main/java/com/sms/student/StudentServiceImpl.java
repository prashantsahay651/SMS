package com.sms.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.Parent;
import com.sms.beans.School;
import com.sms.beans.Section;
import com.sms.beans.Student;
import com.sms.beans.StudentRegistration;
import com.sms.classsection.SectionDAO;
import com.sms.login.LoginDAOImpl;
import com.sms.login.LoginServiceImpl;
import com.sms.mail.MailService;
import com.sms.parent.ParentServiceImpl;
import com.sms.school.SchoolServiceImpl;
import com.sms.services.SMSServiceImpl;

@Service
public class StudentServiceImpl {

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private SchoolServiceImpl schoolServiceImpl;

	@Autowired
	private ParentServiceImpl parentServiceImpl;

	@Autowired
	private MailService mailService;

	@Autowired
	private SMSServiceImpl smsService;

	@Autowired
	private RegisterStudentDAO registerStudentDAO;

	@Autowired
	private SectionDAO sectionDAO;
	
	@Autowired
	private LoginServiceImpl loginServiceImpl;
	
	@Autowired
	private LoginDAOImpl loginDAOImpl;

	private School school;
	private Student Student;
	private Parent parent1;
	private String password;
	private Section section;
	private int flag;

	public List<Student> getAllStudent() {
		return studentDAO.findAll();
	}

	public List<Student> searchStudent(String studentName, int schoolId) {

		return studentDAO.searchStudent(studentName, schoolId);
	}

	public Student getStudentById(int studentId) {

		return studentDAO.getOne(studentId);
	}

	public void deleteStudent(int studentId) {
		studentDAO.deleteById(studentId);
	}

	public int addStudent(Student student, Parent parent, int schoolId, Boolean question) {
		school = schoolServiceImpl.getSchoolById(schoolId);
		flag = loginServiceImpl.checkEmailId(student.getLogin().getEmailId());
		if (flag < 0) {
			return 0;
		}
		if (question==null) {
			flag = loginServiceImpl.checkEmailId(parent.getLogin().getEmailId());
			if (flag < 0) {
				return 1;
			} else {
				password = smsService.generatePassword();
				student.getLogin().setPassword(password);
				password = smsService.generatePassword();
				parent.getLogin().setPassword(password);
				parent.getLogin().setUser("parent");
				loginDAOImpl.save(parent.getLogin());
				parent = parentServiceImpl.saveParent(parent);
				student.setParent(parent);
				student.setSchool(school);
				student.getLogin().setUser("student");
				loginDAOImpl.save(student.getLogin());
				student=studentDAO.save(student);
				mailService.sendNewRegistrationMail(student.getLogin().getEmailId(), student.getLogin().getPassword());
				mailService.sendNewRegistrationMail(parent.getLogin().getEmailId(), parent.getLogin().getPassword());
				return 3;
			}

		} else {
			flag = loginServiceImpl.checkEmailId(parent.getLogin().getEmailId());
			if (flag < 0) {
				return 2;
			} else {
				password = smsService.generatePassword();
				student.getLogin().setPassword(password);
				student.setParent(parent1);
				student.setParent(parent1);
				student.setSchool(school);
				student.getLogin().setUser("student");
				loginDAOImpl.save(student.getLogin());
				student=studentDAO.save(student);
				mailService.sendNewRegistrationMail(student.getLogin().getEmailId(), student.getLogin().getPassword());
				return 3;
			}

		}
	}

	public Student editStudent(Student student) {
		Student student1 = studentDAO.getOne(student.getStudentId());
		student1.setStudentName(student.getStudentName());
		student1.setMobileNumber(student.getMobileNumber());
		
		student1.setAlternateMobileNumber(student.getAlternateMobileNumber());
		student1.setAddressLine1(student.getAddressLine1());
		student1.setAddressLine2(student.getAddressLine2());
		student1.setCity(student.getCity());
		student1.setDistrict(student.getDistrict());
		student1.setState(student.getState());
		student1.setPinCode(student.getPinCode());
		return studentDAO.save(student1);

	}

	public int registerStudent(StudentRegistration studentRegistration) {
		System.out.println(studentRegistration.isQuestion());
		Student = studentDAO.checkEmailId(studentRegistration.getStudentEmailId());
		if (Student != null) {
			return 0;
		}
		if (studentRegistration.isQuestion()) {
			parent1 = parentServiceImpl.getParentByEmailId(studentRegistration.getFatherEmailId());
			if (parent1 == null) {
				return 1;
			}
		} else {
			parent1 = parentServiceImpl.getParentByEmailId(studentRegistration.getFatherEmailId());
			if (parent1 != null) {
				return 2;
			}
		}
		section = sectionDAO.getOne(studentRegistration.getSectionId());
		studentRegistration.setClassSection(section.getClass1().getClassName() + "/" + section.getSectionName());
		studentRegistration = registerStudentDAO.save(studentRegistration);
		return studentRegistration.getId();
	}

	public List<StudentRegistration> getstudentRegistrationList(int schoolId) {
		return registerStudentDAO.getAllRegistrationBySchoolId(schoolId);
	}

	public StudentRegistration getStudentRegistrationById(int id) {
		return registerStudentDAO.getOne(id);
	}

	public void acceptStudent(Student student, Parent parent, int schoolId, boolean question, int sectionId) {
		/*school = schoolServiceImpl.getSchoolById(schoolId);
		section = sectionDAO.getOne(sectionId);
		student.setSection(section);
		if (!question) {
			password = smsService.generatePassword();
			student.setPassword(password);
			password = smsService.generatePassword();
			parent.setPassword(password);
			parent = parentServiceImpl.saveParent(parent);
			student.setParent(parent);
			student.setSchool(school);
			studentDAO.save(student);
			mailService.sendNewRegistrationMail(student.getEmailId(), student.getPassword());
			mailService.sendNewRegistrationMail(parent.getEmailId(), parent.getPassword());
		} else {
			password = smsService.generatePassword();
			student.setPassword(password);
			student.setParent(parent1);
			student.setParent(parent1);
			student.setSchool(school);
			studentDAO.save(student);
			mailService.sendNewRegistrationMail(student.getEmailId(), student.getPassword());
		}
*/
	}

	public void deleteRegsiterStudent(int id) {
		registerStudentDAO.deleteById(id);
		
	}

	public List<com.sms.beans.Student> getStudentWithNoAllotatedSection(int schoolId) {
		
		return studentDAO.getStudentWithNoAllotatedSection(schoolId);
	}
}
