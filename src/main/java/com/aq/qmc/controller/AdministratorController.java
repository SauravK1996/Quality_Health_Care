package com.aq.qmc.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aq.qmc.bean.DoctorBean;
import com.aq.qmc.bean.LeaveBean;
import com.aq.qmc.bean.PatientBean;
import com.aq.qmc.service.AdministratorService;

@Controller
public class AdministratorController {
	@Autowired
	private AdministratorService administratorService;

	@GetMapping("/admin")
	public ModelAndView admin() {
		return new ModelAndView("Admin");
	}
	
	@PostMapping("/admin/action")
	public ModelAndView authorize(@RequestParam String reqid, Model m) {
		System.out.println(reqid);
		switch(reqid) {
			case "AD001": return new ModelAndView("AddDoctor");
			case "AD002": return doctorsToDelete(m);
			case "AD003": return viewAllDoctors(m);
			case "AD004": return doctorsToModify(m);
			case "AD005": return new ModelAndView("SelectDateForFixedAppointmentDetails");
			case "AD006": return doctorsLeaveList(m);
			default: m.addAttribute("errorAdminAction","Either you are not authorized to perform action or input is invalid.");
			return new ModelAndView("Admin");
		}
	}
	
	@GetMapping("/admin/getAddDoctor")
	public ModelAndView getAddDoctor() {
		return new ModelAndView("AddDoctor");
	}
	
	@PostMapping("/admin/postAddDoctor")
	public ModelAndView postAddDoctor(@ModelAttribute("doctorBean") DoctorBean doctorBean, Model m) {
		System.out.println("doctorBean : "+doctorBean);
		if(doctorBean == null) {
			m.addAttribute("errorAddDoctor", "Please fill all fields correctly. All fields are mandatory.");
			return new ModelAndView("AddDoctor");
		}
		String addDoctor = administratorService.addDoctor(doctorBean);	
		if(addDoctor.equalsIgnoreCase("Success")) {
			m.addAttribute("addDoctor", "Doctor added successfully");
			return new ModelAndView("Admin");
		}else {
			m.addAttribute("errorAddDoctor", "There was an error in adding doctor. Please try again.");
			return new ModelAndView("AddDoctor");
		}
		
		
	}

	@GetMapping("/admin/viewAllDoctors")
	public ModelAndView viewAllDoctors(Model m) {
		ArrayList<DoctorBean> allDoctorList = administratorService.viewAllDoctors();
		System.out.println("allDoctorList : "+allDoctorList.size());
		m.addAttribute("allDoctorList", allDoctorList);
		return new ModelAndView("DoctorsList");
	}
	
	@GetMapping("/admin/doctorsToModify")
	public ModelAndView doctorsToModify(Model m) {
		ArrayList<DoctorBean> allDoctorList = administratorService.viewAllDoctors();
		System.out.println("allDoctorList : "+allDoctorList.size());
		m.addAttribute("allDoctorList", allDoctorList);
		return new ModelAndView("ModifyDoctor");
	}

	@GetMapping("/admin/doctorsToDelete")
	public ModelAndView doctorsToDelete(Model m) {
		ArrayList<DoctorBean> allDoctorList = administratorService.viewAllDoctors();
		System.out.println("allDoctorList : "+allDoctorList.size());
		m.addAttribute("allDoctorList", allDoctorList);
		return new ModelAndView("RemoveDoctor");
	}
	
	@GetMapping("/admin/deleteDoctor")
	public ModelAndView removeDoctor(@RequestParam String doctorid, Model m) {
		System.out.println("Is doctor deleted: "+administratorService.removeDoctor(doctorid));
		ArrayList<DoctorBean> allDoctorList = administratorService.viewAllDoctors();
		m.addAttribute("allDoctorList", allDoctorList);
		return new ModelAndView("RemoveDoctor");
	}
	
	@GetMapping("/admin/getUpdateDoctor")
	public ModelAndView getUpdateDoctor(@RequestParam String doctorid, Model m) {
		DoctorBean dBean = administratorService.getDoctorById(doctorid);
		
		if(dBean != null) {
			m.addAttribute("dBean", dBean);
			return new ModelAndView("UpdateDoctorDetails");
		}else {
			return null;
		}
	}
	
	@PostMapping("/admin/postUpdateDoctor")
	public ModelAndView postUpdateDoctor(@ModelAttribute("doctorBean") DoctorBean doctorBean, Model m) {
		System.out.println("Is Doctor updated : "+administratorService.modifyDoctor(doctorBean));
		ArrayList<DoctorBean> allDoctorList = administratorService.viewAllDoctors();
		m.addAttribute("allDoctorList", allDoctorList);
		return new ModelAndView("ModifyDoctor");
	}
	
	@PostMapping("/admin/patientListWithfixedAppointment")
	public ModelAndView patientListWithfixedAppointment(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd")Date selectDate, Model m) {
		System.out.println("selectDate: "+selectDate);
		ArrayList<PatientBean> patientList = administratorService.viewPatientByDate(selectDate);
		m.addAttribute("patientList", patientList);
		return new ModelAndView("PatientListForFixedAppintment");
	}
	
	@PostMapping("/admin/doctorsLeaveList")
	public ModelAndView doctorsLeaveList(Model m) {
		ArrayList<LeaveBean> leavesList = administratorService.doctorsLeaveList();
		m.addAttribute("leavesList", leavesList);		
		return new ModelAndView("UpdateLeaveList");
	}
	
	@GetMapping("/admin/updateLeave")
	public ModelAndView updateLeave(@RequestParam String leaveid, Model m) {
		String isLeaveUpdated = administratorService.updateLeave(leaveid);
		if(isLeaveUpdated.equals("Success")) {
			m.addAttribute("leaveUpdated", "Leave approved.");
		}else {
			m.addAttribute("leaveNotUpdated", "Leave not updated. Please try again.");
		}
		return new ModelAndView("Admin");
			
	}
}
