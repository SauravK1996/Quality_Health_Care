package com.aq.qmc.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aq.qmc.bean.DoctorBean;
import com.aq.qmc.service.ReporterService;

@Controller
public class ReporterController {
	@Autowired
	private ReporterService reporterService;
	
	@GetMapping("/reporter")
	public ModelAndView reporter() {
		return new ModelAndView("Reporter");
	}
	
	@PostMapping("/reporter/action")
	public ModelAndView authorize(@RequestParam String reqid, Model m) {
		System.out.println(reqid);
		switch(reqid) {
			case "RE001": return new ModelAndView("SelectDateToCheckDoctorsAvailability");
			case "RE002": return intimateAdmin(m);
			default: m.addAttribute("errorAction","Either you are not authorized to perform action"
					+ " or input is invalid.");
				return new ModelAndView("Reporter");
		}
	}
	

	
	@PostMapping("/reporter/doctorsOnDate")
	public ModelAndView postDoctorsOnDate(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd")Date selectDate, Model m) {
		System.out.println("selectDate: "+selectDate);
		ArrayList<DoctorBean> availableDoctors = reporterService.viewAllAvailableDoctors(selectDate);
		m.addAttribute("availableDoctors", availableDoctors);
		return new ModelAndView("AvailableDoctors");
	}
	
	@GetMapping("/reporter/intimateAdmin")
	public ModelAndView intimateAdmin(Model m) {
		ArrayList<DoctorBean> doctorBeanList = reporterService.intimateAdmin();
		m.addAttribute("doctorBeanList", doctorBeanList);
		return new ModelAndView("IntimateAdmin");
	}
}
