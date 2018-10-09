package com.sms.classsection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.Section;

public interface SectionDAO extends JpaRepository<Section,Integer> {

	@Query(value = "SELECT section_name from section where section_name=?1 and class_id=?2", nativeQuery = true)
	String checkSectionName(String sectionName, int classId);

	

}
