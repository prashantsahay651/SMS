package com.sms.login;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Login;

@Controller
public class LoginController {

	@Autowired
	private LoginServiceImpl loginSericeImpl;
	
	private Login login;
	
	@PostMapping("/WebLogin")
	public RedirectView schoolLogin(String username, String password, ServletRequest request, HttpSession session,
			RedirectAttributes attributes) {
		 login = loginSericeImpl.login(username, password);
		if (login == null) {
			attributes.addFlashAttribute("message", "Invalid Email Id or Password");
			return new RedirectView("login");
		} else {
			if(login.getUser().equals("school")) {
			session.setAttribute("schoolId", login.getSchool().getSchoolId());
			return new RedirectView("schoolhome");
			}
		}
		return new RedirectView("login");

	}
	
	@PostMapping("/WebAdminlLogin")
	public RedirectView adminLogin(String emailId, String password, ServletRequest request,
			RedirectAttributes attributes) {
		System.out.println("in web admin login");
		if (!(emailId.equals("prashantsahay651@gmail.com") && password.equals("prashant"))) {
			attributes.addFlashAttribute("message", "Invalid Email Id or Password");
			return new RedirectView("adminlogin");
		} else {
			return new RedirectView("schoolhome");
		}

	}

}
