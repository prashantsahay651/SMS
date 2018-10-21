package com.sms.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Proxy(lazy=false)
@Entity
@Table
public class Attendance {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int attendanceId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "date_id")
	private AttendanceDate day;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;
	private boolean presence;
	
	public int getAttendanceId() {
		return attendanceId;
	}
	public AttendanceDate getDay() {
		return day;
	}
	public void setDay(AttendanceDate day) {
		this.day = day;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public boolean isPresence() {
		return presence;
	}
	public void setPresence(boolean presence) {
		this.presence = presence;
	}
}
