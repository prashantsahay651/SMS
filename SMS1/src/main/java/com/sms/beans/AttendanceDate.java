package com.sms.beans;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Proxy(lazy=false)
@Entity
@Table
public class AttendanceDate {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dateId;
	private Date day;
	
	@OneToMany(mappedBy = "day", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Attendance> attendance;
	
	public int getDateId() {
		return dateId;
	}
	
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}

	public List<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}
}
