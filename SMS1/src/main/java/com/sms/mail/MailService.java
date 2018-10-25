package com.sms.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendNewRegistrationMail(String emailId,String password) {
		
		/*SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setTo(emailId);
		mailMessage.setSubject("Registration Sucessfully");
		mailMessage.setText("<h1>You have Sucessfully Registered With Email ID="+emailId+" and password "+password+"</h1>");
		javaMailSender.send(mailMessage);*/
		
		
		try {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper;
			helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
			String htmlMsg = "<div style=\"background-color:#e0ebeb;padding:30px;width:50%;margin-left:25%;\">\r\n" + 
					"<div style=\"background-color:white;padding:15px;\">\r\n" + 
					"<h1 style=\"text-align:center;\">School Management System</h1>\r\n" + 
					"\r\n" + 
					"<h3>Hi,Prashant !</h3>\r\n" + 
					"<p><strong>This is Confirmation For Your Registration</strong></p>\r\n" + 
					"\r\n" + 
					"<p><strong>Your Login Details Are As Follow</strong></p>\r\n" + 
					"\r\n" + 
					"<div style=\"line-height:5px;margin-left:15px;\">\r\n" + 
					"<p><span style=\"color:#669999;font-weight:bold;\">Email Id:-</span> Prashantsahay651@gmail.com</p>\r\n" + 
					"<p><span style=\"color:#669999;font-weight:bold;\">Mobile Number:-</span> 8987102890</p>\r\n" + 
					"<p><span style=\"color:#669999;font-weight:bold;\">Username:-</span> PS00001</p>\r\n" + 
					"<p><span style=\"color:#669999;font-weight:bold;\">Password:-</span> hello6723g</p>\r\n" + 
					"</div>\r\n" + 
					"\r\n" + 
					"<p style=\"text-align:center;color:red;\">Please Don't Share Password With Anyone</p>\r\n" + 
					"\r\n" + 
					"<div style=\"margin-left:35%;\"><a href=\"\"><button style=\"background-color:#669999;border: none;color:white; padding: 8px 16px;font-size: 16px;font-weight:bold;border-radius:4px;\">Click Here To Login</button></a></div>\r\n" + 
					"\r\n" + 
					"<p><strong>Thanks And Regards</strong></p>\r\n" + 
					"<p>Prashant Kumar Sahay</p>\r\n" + 
					"</div>\r\n" + 
					"</div>\r\n" + 
					"";
			helper.setText(htmlMsg, true);
			helper.setTo(emailId);
			helper.setSubject("This is the test message for testing gmail smtp server using spring mail");
			javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}