package com.sms.eventcalender;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.beans.EventCalender;

public interface EventCalenderDAO extends JpaRepository<EventCalender,Integer> {

}
