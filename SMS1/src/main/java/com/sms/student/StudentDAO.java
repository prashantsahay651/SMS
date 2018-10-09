package com.sms.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.Student;

public interface StudentDAO extends JpaRepository<Student,Integer> {

	@Query(value = "SELECT * from student where email_id=?1", nativeQuery = true)
	Student checkEmailId(String emailId);

	@Query(value="SELECT * from student where student_name like %?1%  and school_id=?2",nativeQuery = true)
	List<Student> searchStudent(String studentName,int schoolId);

	@Query(value="select * from student where section_id IS NULL and school_id=?1",nativeQuery = true)
	List<Student> getStudentWithNoAllotatedSection(int schoolId);

}
