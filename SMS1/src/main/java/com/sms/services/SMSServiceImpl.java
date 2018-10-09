package com.sms.services;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

@Service
public class SMSServiceImpl {
	
	private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	 private static SecureRandom random = new SecureRandom();
	
	public String generatePassword() {
		String result = "";
		  for (int i = 0; i < 10; i++) {
		        int index = random.nextInt(ALPHA.length());
		        result += ALPHA.charAt(index);
		    }
		return result;
	}

}
