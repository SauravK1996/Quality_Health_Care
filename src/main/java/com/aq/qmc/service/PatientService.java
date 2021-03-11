package com.aq.qmc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aq.qmc.bean.AppointmentBean;
import com.aq.qmc.bean.DoctorBean;
import com.aq.qmc.bean.PatientBean;
import com.aq.qmc.dao.PatientDao;

@Service
public class PatientService {

	@Autowired
	private PatientDao pdao;
	
	public String addAilmentDetails(PatientBean patientBean) {
		return pdao.addAilmentDetails(patientBean);
	}
	
	public PatientBean getAilmentById(String patientid) {
		return pdao.getAilmentById(patientid);
	}
	public boolean modifyAilmentDetails(PatientBean patientBean) {
		return pdao.modifyAilmentDetails(patientBean);
	}
	
	public ArrayList<PatientBean> viewAilmentDetails(String userid){
		return pdao.viewAilmentDetails(userid); 
	}

	public ArrayList<DoctorBean> viewListOfDoctors(String specialization){
		return pdao.viewListOfDoctors(specialization); 
	}
	
	public String requestforAppointment(AppointmentBean appointmentBean) {
		return pdao.requestforAppointment(appointmentBean);
	}
	
	public ArrayList<DoctorBean> viewAllListOfDoctors(String doctorid, Date selectDate){
		return pdao.viewAllListOfDoctors(doctorid, selectDate);
	}
}
