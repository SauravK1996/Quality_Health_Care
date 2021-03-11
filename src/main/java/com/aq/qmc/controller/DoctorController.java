package com.aq.qmc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aq.qmc.bean.AppointmentBean;
import com.aq.qmc.bean.CredentialsBean;
import com.aq.qmc.bean.LeaveBean;
import com.aq.qmc.service.DoctorService;

@Controller
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@GetMapping("/doctor")
	public ModelAndView doctor() {
		return new ModelAndView("Doctor");
	}
	
	@PostMapping("/doctor/action")
	public ModelAndView authorize(@RequestParam String reqid,HttpServletRequest request, Model m) {
		System.out.println(reqid);
		HttpSession session = request.getSession();
		CredentialsBean credentialsBean = (CredentialsBean) session.getAttribute("credentialsBean");
				
		switch(reqid) {
			case "DC001": return checkAppointment(credentialsBean.getUserid(), m);
			case "DC002": return new ModelAndView("ApplyForLeave");
			case "DC003": return checkLeaveStatus(credentialsBean.getUserid(),m);
			default: m.addAttribute("errorDoctorAction","Either you are not authorized to perform action or input is invalid.");
			return new ModelAndView("Doctor");
		}
	}
	
	@GetMapping("/doctor/checkAppointment")
	public ModelAndView checkAppointment(String doctorid, Model m) {
		ArrayList<AppointmentBean> checkAppointmentList = doctorService.checkAppointment(doctorid);
		m.addAttribute("checkAppointmentList", checkAppointmentList);		
		return new ModelAndView("AppointmentList");
	}
	
	@PostMapping("/doctor/applyForLeave")
	public ModelAndView applyForLeave(@ModelAttribute("leaveBean") LeaveBean leaveBean, Model m) {
		System.out.println(leaveBean);
		String isLeaveAdded = doctorService.applyForLeave(leaveBean);
		if(isLeaveAdded.equals("Success")) {
			m.addAttribute("leaveDetailsAdded", "Your leave application added successfully.");
			return new ModelAndView("Doctor");
		}else {
			m.addAttribute("errorAddingLeave", "Please enter details carefully. All details are mandatory.");
			return new ModelAndView("ApplyForLeave");
		}
	}
	
	@PostMapping("/doctor/checkLeaveStatus")
	public ModelAndView checkLeaveStatus(String doctorid, Model m) {
		ArrayList<LeaveBean> leavesList = doctorService.checkLeaveStatus(doctorid);
		m.addAttribute("leavesList", leavesList);		
		return new ModelAndView("CheckLeaveStatus");
	}
	
	@GetMapping("/doctor/updateLeave")
	public ModelAndView getUpdateLeave(@RequestParam String leaveid, Model m) {
		LeaveBean leaveBean = doctorService.getLeaveById(leaveid);
		m.addAttribute("leaveBean", leaveBean);
		return new ModelAndView("UpdateLeave");
	}
	
	@PostMapping("/doctor/updateLeave")
	public ModelAndView postUpdateLeave(@ModelAttribute("leaveBean") LeaveBean leaveBean, Model m) {
		System.out.println(leaveBean);
		String isleaveUpdated = doctorService.updateLeave(leaveBean);
		if(isleaveUpdated.equals("Success")) {
			m.addAttribute("leaveUpdated", "Your leave details is successfully updated");
			return new ModelAndView("Doctor");
		}else {
			m.addAttribute("leaveNotUpdated", "Your leave details is not updated. Please try again.");
			return new ModelAndView("Doctor");
		}
	}
	
	@GetMapping("/doctor/cancelLeave")
	public ModelAndView cancelLeave(@RequestParam String leaveid, Model m) {
		String isLeaveCancelled = doctorService.cancelLeave(leaveid);
		if(isLeaveCancelled.equals("Success")) {
			m.addAttribute("leaveCancelled","Your leave is successfully cancelled.");
		}else {
			m.addAttribute("leaveNotCancelled","Your leave is not cancelled.");
		}
		return new ModelAndView("Doctor");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
