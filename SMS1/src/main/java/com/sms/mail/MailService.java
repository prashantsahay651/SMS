package com.sms.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendNewRegistrationMail(String emailId,String password) {
		
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setTo(emailId);
		mailMessage.setSubject("Registration Sucessfully");
		mailMessage.setText("You have Sucessfully Registered With Email ID="+emailId+" and password "+password+"");
		javaMailSender.send(mailMessage);
		
	}

}
