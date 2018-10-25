package com.sms.homework;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sms.beans.HomeWork;

@Service
public class HomeWorkServiceImpl {

	@Autowired
	private HomeWorkDAO homeWorkDAO;

	public int saveHomeWork(HomeWork homeWork) {
		int retVal = 0;
		HomeWork hm;
		try {
			hm = homeWorkDAO.save(homeWork);
		}
		catch (Throwable t) {
			retVal = 1;
			t.printStackTrace();
		}
		return retVal;
	}
	
	/**
	 * Fetch home work for 
	 * @param date
	 * @return
	 */
	public List<HomeWork> fetchHomeWorkForDate(String date) {
		return null;
	}
	
}
