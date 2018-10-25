package com.sms.eventcalender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.EventCalender;

@Service
public class EventCalenderServiceImpl {

	@Autowired
	private EventCalenderDAO  eventCalenderDAO;
	
	public EventCalender addEventCalender(EventCalender eventCalender) {
		return eventCalenderDAO.save(eventCalender);
	}
	
	public void deleteEventCalender(int id) {
		eventCalenderDAO.deleteById(id);
	}
}
