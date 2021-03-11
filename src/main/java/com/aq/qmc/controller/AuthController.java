package com.aq.qmc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aq.qmc.bean.CredentialsBean;
import com.aq.qmc.bean.ProfileBean;
import com.aq.qmc.util.AuthenticationUtility;
import com.aq.qmc.util.UserUtility;

@Controller
public class AuthController {
	
	@Autowired
	private AuthenticationUtility authenticationUtility;
	
	@Autowired
	private UserUtility userUtility;
	

	@GetMapping("/")
	public ModelAndView login() {
		return new ModelAndView("Login");
	}
	
	@GetMapping("/auth/login")
	public ModelAndView loginIfRegisered() {
		return new ModelAndView("Login");
	}
	
	@PostMapping("/auth/login")
	public ModelAndView login(@ModelAttribute("credentialsBean") CredentialsBean credentialsBean, HttpServletRequest request) {
		
		boolean isAuthenticated = authenticationUtility.authenticate(credentialsBean);
		System.out.println("isAuthenticated : "+isAuthenticated);
		if(isAuthenticated) {
			System.out.println("isAuthenticated : "+isAuthenticated);
			authenticationUtility.changeLoginStatus(credentialsBean, 1);
			
			HttpSession session = request.getSession();
			session.setAttribute("credentialsBean", credentialsBean);
			
			if(credentialsBean.getUserType().equals("Patient")) {
				String patientName = userUtility.getPatientName(credentialsBean.getUserid());
				System.out.println("patientName : "+patientName);
				if(patientName != null) {
					session.setAttribute("patientName", patientName);
				}
			}
			
			switch(credentialsBean.getUserType()) {
			case "Patient":
				return new ModelAndView("Patient");	

			case "Reporter":
				return new ModelAndView("Reporter");	

			case "Admin":
				return new ModelAndView("Admin");
			case "Doctor":
				return new ModelAndView("Doctor");
			}
			
		}else {
			System.out.println("isAuthenticated : "+isAuthenticated);
			request.setAttribute("errorLogin", "Either username, password or usertype is invalid");
			return new ModelAndView("Login");
		}
		return null;		
	}
	
	@GetMapping("/auth/logout")
	public ModelAndView logout(@RequestParam String userid, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session != null) {
			CredentialsBean credentialsBean = authenticationUtility.getCredentialDataByUserid(userid);
			if(credentialsBean != null) {
				authenticationUtility.changeLoginStatus(credentialsBean, 0);
			}
			session.invalidate();			
			return new ModelAndView("Login");
		}else {
			return new ModelAndView("Login");
		}
		
	}
	
	
	@GetMapping("/auth/register")
	public ModelAndView register() {
		System.out.println("Welcome to auth/register");
		return new ModelAndView("Register");
	}
	
	@PostMapping("/auth/register")
	public ModelAndView register(@ModelAttribute("profileBean") ProfileBean profileBean, Model m) {
		System.out.println(profileBean);
		String userid = userUtility.register(profileBean);
		if(userid == null) {
			m.addAttribute("errorRgisterUser", "Fill the form with all correct details. All fields are mandatory.");
			return new ModelAndView("Register");
		}
		m.addAttribute("userid", userid);
		return new ModelAndView("Login");
	}

	@GetMapping("/auth/resetPassword")
	public ModelAndView resetPassword() {
		return new ModelAndView("ResetPassword");
	}

	@PostMapping("/auth/resetPassword")
	public ModelAndView updatePassword(@RequestParam String userid, String newpwd, String cnfnewpwd, Model m) {
		if(newpwd.equals(cnfnewpwd)) {
			String isPasswordUpdated = userUtility.changePassword(userid, newpwd);
			if(isPasswordUpdated.equals("Success")) {
				m.addAttribute("passwordUpdated", "Your password is successfully updated");
				return new ModelAndView("Login"); 
			}else {
				m.addAttribute("passwordNotUpdated", "Your password is not successfully updated");
				return new ModelAndView("ResetPassword"); 
			}
			
		}else {
			m.addAttribute("pwdCnfPwdNotsame", "Your password and confirm password must be same.");
			return new ModelAndView("ResetPassword");  
		}
		
	}
	
	
}
