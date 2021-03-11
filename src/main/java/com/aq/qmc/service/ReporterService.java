package com.aq.qmc.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aq.qmc.bean.DoctorBean;
import com.aq.qmc.dao.ReporterDao;

@Service
public class ReporterService {
	
	@Autowired
	private ReporterDao rdao;

	public ArrayList<DoctorBean> viewAllAvailableDoctors(Date date){
		return rdao.viewAllAvailableDoctors(date);
	}
	
	public ArrayList<DoctorBean> intimateAdmin(){
		return rdao.intimateAdmin();
	}
}
