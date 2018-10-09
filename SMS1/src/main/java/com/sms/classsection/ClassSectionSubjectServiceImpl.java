package com.sms.classsection;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.Class;
import com.sms.beans.School;
import com.sms.beans.Section;
import com.sms.beans.Student;
import com.sms.beans.Subject;
import com.sms.beans.Teacher;
import com.sms.school.SchoolServiceImpl;
import com.sms.student.StudentServiceImpl;
import com.sms.subject.SubjectServiceImpl;
import com.sms.teacher.TeacherServiceImpl;

@Service
public class ClassSectionSubjectServiceImpl {

	@Autowired
	private SchoolServiceImpl schoolServiceImpl;
	private String className;
	private String sectionName;
	private String subjectName;

	private School school;
	@Autowired
	private ClassDAO classDAO;

	@Autowired
	private SectionDAO sectionDAO;

	@Autowired
	private SubjectServiceImpl subjectServiceImpl;

	@Autowired
	private TeacherServiceImpl teacherServiceImpl;
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;

	private Section section;
	private Subject subject;
	private Teacher teacher;
	private Student student;

	public int addClass(int schoolId, Class class1) {
		className = classDAO.checkClassName(class1.getClassName(), schoolId);
		if (className != null) {
			return 0;
		}
		school = schoolServiceImpl.getSchoolById(schoolId);
		class1.setSchool(school);
		class1 = classDAO.save(class1);
		return class1.getClassId();
	}

	public int addSection(int schoolId, Class class1, Section section) {
		sectionName = sectionDAO.checkSectionName(section.getSectionName(), class1.getClassId());
		if (sectionName != null) {
			return 0;
		}
		class1 = classDAO.getOne(class1.getClassId());
		section.setClass1(class1);
		section = sectionDAO.save(section);
		return section.getSectionId();
	}

	public Class getClassById(int user_id) {
		// TODO Auto-generated method stub
		return classDAO.getOne(user_id);
	}

	public Section getSectionById(int sectionId) {
		return sectionDAO.getOne(sectionId);
	}

	public int addSubjectToSection(int sectionId, int subjectId, int teacherId) {
		section = sectionDAO.getOne(sectionId);
		subject = subjectServiceImpl.getSubjectById(subjectId);
		if (section.getSubjects().containsKey(subject)) {
			return -1;
		}
		teacher = teacherServiceImpl.getTeacherById(teacherId);
		section.getSubjects().put(subject, teacher);
		sectionDAO.save(section);
		return section.getSectionId();
	}

	public int addClassTeacher(int sectionId, int teacherId) {
		section = sectionDAO.getOne(sectionId);
		if (section.getClassTeacherId() != 0) {
			return -1;
		}
		teacher = teacherServiceImpl.getTeacherById(teacherId);
		teacher.setClassTeacher(true);
		teacherServiceImpl.save(teacher);
		section.setClassTeacherId(teacherId);
		sectionDAO.save(section);
		return section.getSectionId();
	}

	public int addStudentToSection(int sectionId, int studentId) {
		section = sectionDAO.getOne(sectionId);
		student=studentServiceImpl.getStudentById(studentId);
		section.getStudents().add(student);
		section=sectionDAO.save(section);
		return section.getSectionId();
	}

}
