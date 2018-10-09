package com.sms.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.Login;

@Service
public class LoginServiceImpl {

	@Autowired
	private LoginDAOImpl loginDAOImpl;

	private Login login;
	
	private String emailId;

	public int checkEmailId(String emailId) {

		emailId = loginDAOImpl.checkEmailId(emailId);
		if (emailId != null) {
			return -1;
		}
		return 0;
	}

	public Login login(String emailId2, String password) {
		
		return loginDAOImpl.login(emailId2,password);
	}

	public Login saveLogin(Login login2) {
		// TODO Auto-generated method stub
		return loginDAOImpl.save(login2);
	}
}
