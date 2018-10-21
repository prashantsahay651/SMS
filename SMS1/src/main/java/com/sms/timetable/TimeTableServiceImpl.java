package com.sms.timetable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.Period;
import com.sms.beans.PeriodSubjectMapping;
import com.sms.beans.School;
import com.sms.beans.Section;
import com.sms.beans.Subject;
import com.sms.beans.TimeTable;
import com.sms.classsection.SectionDAO;
import com.sms.school.SchoolDAO;
import com.sms.subject.SubjectDAOImpl;

@Service
public class TimeTableServiceImpl {

	@Autowired
	private PeriodDAO periodDAO;
	
	@Autowired
	private TimeTableDAO timeTableDAO;
	
	@Autowired
	private PeriodSubjectMappingDAO periodSubjectMappingDAO;
	
	@Autowired
	private SubjectDAOImpl subjectDAO;
	
	@Autowired
	private SectionDAO sectionDAO;
	
	@Autowired
	private SchoolDAO schoolDAO;
	
	public Period savePeriod(int schoolId, Period period) {
		School school = schoolDAO.getOne(schoolId);
		period.setSchool(school);
		return periodDAO.save(period);
	}
	
	public void deletePeriodById(int periodId) {
		periodDAO.deleteById(periodId);
	}
	
	public Period getPeriodById(int periodId) {
		return periodDAO.fetchPeriod(periodId);
	}
	
	public TimeTable saveTimeTable(int sectionId, TimeTable timeTable) {
		TimeTable tt = timeTableDAO.save(timeTable);
		Section s = sectionDAO.getOne(sectionId);
		s.setTimeTable(tt);
		sectionDAO.save(s);
		return tt;
	}
	
	public PeriodSubjectMapping savePeriodSubjectMapping(int timeTableId, int periodId, int subjectId) {
		Period p;
		Subject s;
		TimeTable tt;
		PeriodSubjectMapping periodSubjectMapping =null;
		try {
			p = periodDAO.fetchPeriod(periodId);
			s = subjectDAO.fetchSubjectById(subjectId);
			tt = timeTableDAO.fetchById(timeTableId);
			periodSubjectMapping = new PeriodSubjectMapping();
			periodSubjectMapping.setPeriod(p);
			periodSubjectMapping.setSubject(s);
			periodSubjectMapping.setTimeTable(tt);
			
			periodSubjectMapping = periodSubjectMappingDAO.save(periodSubjectMapping);
		}
		catch (Throwable t) {
			t.printStackTrace();
		}
		return periodSubjectMapping;
	}

	public void deletePeriodSubjectMapping(int periodSubjectMappingId) {	
		periodSubjectMappingDAO.deleteById(periodSubjectMappingId);
	}
	
	public void deletePeriodSubjectMapping(int timeTableId, int periodId, int subjectId) {
		PeriodSubjectMapping periodSubjectMapping = periodSubjectMappingDAO.fetchPeriodSubjectMapping(timeTableId, periodId, subjectId);
		periodSubjectMappingDAO.deleteById(periodSubjectMapping.getPeriodSubjectMappingId());
	}
}
