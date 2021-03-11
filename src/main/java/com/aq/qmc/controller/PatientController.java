package com.aq.qmc.controller;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aq.qmc.bean.AppointmentBean;
import com.aq.qmc.bean.CredentialsBean;
import com.aq.qmc.bean.DoctorBean;
import com.aq.qmc.bean.PatientBean;
import com.aq.qmc.service.AdministratorService;
import com.aq.qmc.service.PatientService;

@Controller
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private AdministratorService administratorService;
	
	@GetMapping("/patient")
	public ModelAndView patient() {
		return new ModelAndView("Patient");
	}
	
	@PostMapping("/patient/action")
	public ModelAndView authorize(@RequestParam String reqid, Model m, HttpServletRequest request) {
		System.out.println(reqid);
		switch(reqid) {
			case "US001": return new ModelAndView("AddAilments");
			case "US002": HttpSession sessionObj = request.getSession();
						  Object obj = sessionObj.getAttribute("credentialsBean");
						  CredentialsBean credBean = (CredentialsBean)obj;
					      return viewAilmentDetails(credBean.getUserid(), m);
			case "US003": return new ModelAndView("SelectSpecialization");
			case "US004": return requestforAppointment(m);
			case "US005": return selectDoctorAndDateForFixedAppointment(m); 
						 
			default: m.addAttribute("errorPatientAction","Either you are not authorized to perform action or input is invalid.");
				return new ModelAndView("Patient");
		}
	}
	
	@GetMapping("/patient/getAddAilments")
	public ModelAndView addAilments() {
		return new ModelAndView("AddAilments");
	}
	
	@PostMapping("/patient/postAddAilment")
	public ModelAndView addAilmentDetails(@ModelAttribute("patientBean") PatientBean patientBean, Model m) {
		System.out.println(patientBean);
		String addAilments = patientService.addAilmentDetails(patientBean);
		System.out.println(addAilments);
		m.addAttribute("addAilments", "Your ailment details are successfully added.");
		return new ModelAndView("Patient");
	}
	
	@GetMapping("/patient/getUpdateAilmentDetails")
	public ModelAndView getModifyAilment(@RequestParam String patientid, Model m) {
		PatientBean pbean = patientService.getAilmentById(patientid);
		m.addAttribute("pbean", pbean);
		return new ModelAndView("UpdateAilmentDetail");
	}
	
	
	@PostMapping("/patient/postUpdateAilmentDetails")
	public ModelAndView modifyAilmentDetails(@ModelAttribute("patientBean")PatientBean patientBean, Model m) {
		System.out.println("patient bean update : "+patientBean);
		boolean isAilmentDetailsUpdated = patientService.modifyAilmentDetails(patientBean);
		System.out.println("isAilmentDetailsUpdated : "+isAilmentDetailsUpdated);
		if(isAilmentDetailsUpdated) {
			m.addAttribute("modifyAilments", "Your ailment details updated successfully.");
		}else {
			m.addAttribute("errorModifyAilments", "Your ailment details are not updated. Please try again later.");
		}
		return new ModelAndView("Patient");
	}
	
	@GetMapping("/patient/getAllAilmentDetails")
	public ModelAndView  viewAilmentDetails(@RequestParam String userid, Model m){
		System.out.println("Userid from controller : "+userid);
		ArrayList<PatientBean> viewAllAilmentDetails = patientService.viewAilmentDetails(userid);
		m.addAttribute("viewAllAilmentDetails", viewAllAilmentDetails);
		return new ModelAndView("AllAilmentsDetails");
	}
	
	@GetMapping("/patient/selectSpecialization")
	public ModelAndView selectSpecialization() {
		return new ModelAndView("SelectSpecialization");
	}

	@GetMapping("/patient/viewDocBySpec")
	public ModelAndView viewListOfDoctors(@RequestParam String specialization,Model m){
		if(specialization.equals("--select--")) {
			m.addAttribute("errorSelect","Please select a specialization");
			return new ModelAndView("SelectSpecialization"); 
		}else {
			ArrayList<DoctorBean> allDoctorsBySpec = patientService.viewListOfDoctors(specialization);
			m.addAttribute("allDoctorsBySpec", allDoctorsBySpec);
			return new ModelAndView("ViewDocBySpec"); 
		}
		
	}
	
	@GetMapping("/patient/requestforAppointment")
	public ModelAndView requestforAppointment(Model m) {
		ArrayList<DoctorBean> allDoctorList = administratorService.viewAllDoctors();
		System.out.println("allDoctorList : "+allDoctorList.size());
		m.addAttribute("allDoctorList", allDoctorList);
		return new ModelAndView("BookAppointment");
	}
	
	@PostMapping("/patient/requestforAppointment")
	public ModelAndView requestforAppointment(@ModelAttribute("appointmentBean") AppointmentBean appointmentBean, Model m) {
		String reqForAppointment = patientService.requestforAppointment(appointmentBean);
		if(reqForAppointment.equalsIgnoreCase("Success")) {
			m.addAttribute("reqForAppointment", reqForAppointment);
			return new ModelAndView("Patient");
		}else {
			m.addAttribute("errorInRequesForAppointment", "No doctor is available at your selected date. Please use another date.");
			return new ModelAndView("Patient");
		}
	}
	
	@GetMapping("/patient/selectDoctorAndDateForFixedAppointment")
	public ModelAndView selectDoctorAndDateForFixedAppointment(Model m) {
		ArrayList<DoctorBean> allDoctorsFixedList = administratorService.viewAllDoctors();
		System.out.println("allDoctorsFixedList : "+allDoctorsFixedList.size());
		m.addAttribute("allDoctorsFixedList", allDoctorsFixedList);
		return new ModelAndView("SelectDateAndDoctorForFixedAppointment");
	}
	
	 @PostMapping("/patient/viewAllListOfDoctors") 
	 public ModelAndView viewAllListOfDoctors(@RequestParam String doctorId, @DateTimeFormat(pattern="yyyy-MM-dd") Date selectDate, Model m){
		 System.out.println(doctorId);
		 System.out.println(selectDate);
		 ArrayList<DoctorBean> viewAllListOfFixedDoctors = patientService.viewAllListOfDoctors(doctorId, selectDate);
		 m.addAttribute("viewAllListOfFixedDoctors", viewAllListOfFixedDoctors);
		 return new ModelAndView("ViewAllListOfDoctors");
		 
	 }
	
}
