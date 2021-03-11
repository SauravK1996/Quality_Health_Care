package com.aq.qmc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aq.qmc.bean.AppointmentBean;
import com.aq.qmc.bean.DoctorBean;
import com.aq.qmc.bean.LeaveBean;
import com.aq.qmc.bean.PatientBean;
import com.aq.qmc.dao.AdministratorDao;

@Service
public class AdministratorService {
	@Autowired
	private AdministratorDao adao;
	
	public String addDoctor(DoctorBean doctorBean) {
		return adao.addDoctor(doctorBean);
	}
	
	public DoctorBean getDoctorById(String doctorid) {
		return adao.getDoctorById(doctorid);
	}
	public Boolean modifyDoctor(DoctorBean bean) {
		return adao.modifyDoctor(bean);
	}
	
	public ArrayList<DoctorBean> viewAllDoctors(){
		return adao.viewAllDoctors();
	}
	
	public int removeDoctor(String doctorId) {
		return adao.removeDoctor(doctorId);
	}
	
	public ArrayList<PatientBean> viewPatientByDate(Date appointmentDate){
		return adao.viewPatientByDate(appointmentDate);
	}
//	
//	// remains
//	public ArrayList<DoctorBean> suggestDoctors(String patientId, Date date){
//		return adao.suggestDoctors(patientId, date);
//	}

	public ArrayList<LeaveBean> doctorsLeaveList() {
		return adao.doctorsLeaveList();
	}

	public String updateLeave(String leaveid) {
		return adao.updateLeave(leaveid);
	}
	
	
	
	
}
