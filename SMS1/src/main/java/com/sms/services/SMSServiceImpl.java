package com.sms.services;

import java.security.SecureRandom;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.login.LoginServiceImpl;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SMSServiceImpl {

	private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static SecureRandom random = new SecureRandom();

	@Autowired
	private LoginServiceImpl loginServiceImpl;

	private long count;

	public String generatePassword() {
		String result = "";
		for (int i = 0; i < 10; i++) {
			int index = random.nextInt(ALPHA.length());
			result += ALPHA.charAt(index);
		}
		return result;
	}

	public String generateUsername(String name) {
		count = loginServiceImpl.getLoginCount();
		String[] parts = name.split(" ");
		return parts[0].substring(0, 1) + parts[parts.length - 1].substring(0, 1) + String.format("%04d",count);
	}
	
	public void sendMessage() {
		Twilio.init("ACa3ab73494855e07339ba8a48c93ceecd", "f92e5f7ee49d9cbf8b4971f89b0ea2e5");
		Message message = Message.creator(
		    new PhoneNumber("+918987102890"),
		    new PhoneNumber("+17792132376"),
		    "Sample Twilio SMS using Java")
		.create();
		
		System.out.println(message.getSid());
		
		
	}

}
