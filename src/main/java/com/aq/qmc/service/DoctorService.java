package com.aq.qmc.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aq.qmc.bean.AppointmentBean;
import com.aq.qmc.bean.LeaveBean;
import com.aq.qmc.dao.DoctorDao;

@Service
public class DoctorService {
	@Autowired
	private DoctorDao doctorDao;
	
	public ArrayList<AppointmentBean> checkAppointment(String doctorid){
		return doctorDao.checkAppointment(doctorid);
	}
	
	public String applyForLeave(LeaveBean leaveBean) {
		return doctorDao.applyForLeave(leaveBean);
	}
	
	public ArrayList<LeaveBean> checkLeaveStatus(String doctorid) {
		return doctorDao.checkLeaveStatus(doctorid);
	}

	public String cancelLeave(String leaveid) {
		return doctorDao.cancelLeave(leaveid) ;
	}

	public LeaveBean getLeaveById(String leaveid) {
		return doctorDao.getLeaveById(leaveid);
	}

	public String updateLeave(LeaveBean leaveBean) {
		return doctorDao.updateLeave(leaveBean);
	}
}
