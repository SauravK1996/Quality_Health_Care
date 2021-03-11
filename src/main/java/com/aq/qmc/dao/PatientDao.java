package com.aq.qmc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aq.qmc.bean.AppointmentBean;
import com.aq.qmc.bean.DoctorBean;
import com.aq.qmc.bean.PatientBean;

@Repository
public class PatientDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String addAilmentDetails(PatientBean patientBean) {
		String formatedDate = null;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(patientBean.getAppointmentDate());
			formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +cal.get(Calendar.YEAR);
			System.out.println("formatedDate : " + formatedDate);
			
			int isAilmentsDetailsAdded = jdbcTemplate.update("insert into ec_tbl_patient values"
					+ "(concat('PA',QMC_SEQ_PATIENTID.nextval),'"+patientBean.getUserId()+"',"
					+"to_date('"+formatedDate+"','dd/mm/yyyy'),"
					+ "'"+patientBean.getAilmentType()+"','"+patientBean.getAilmentDetails()+"',"
					+ "'"+patientBean.getDiagnosisHistory()+"',QMC_SEQ_PATIENTID.currval)");
				
			System.out.println("isAilmentsDetailsAdded: "+isAilmentsDetailsAdded);
			
			if(isAilmentsDetailsAdded>0) {
				List<String> patientId = jdbcTemplate.query("select patientid from ec_tbl_patient where patientseqid = (select max(patientseqid) from ec_tbl_patient)", 
						new RowMapper() {
							@Override
							public String mapRow(ResultSet rs, int rowNum) throws SQLException {
								System.out.println(rs.getString("patientid"));
								return rs.getString("patientid");
							}
						});
					System.out.println("patientId : "+patientId.get(0));
				return "Success";
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return "Fail";
		}
		
		return "Fail";
		
	}
	
	public PatientBean getAilmentById(String patientid) {
		
		return (PatientBean) jdbcTemplate.queryForObject("select * from ec_tbl_patient where patientid=?", new Object[] {patientid}, new RowMapper<PatientBean>() {

			@Override
			public PatientBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				PatientBean  pb = new PatientBean();
				pb.setPatientId(rs.getString("patientid"));
				pb.setUserId(rs.getString("userid"));
				pb.setAppointmentDate(rs.getDate("appointment_date"));
				pb.setAilmentType(rs.getString("ailment_type"));
				pb.setAilmentDetails(rs.getString("ailment_details"));
				pb.setDiagnosisHistory(rs.getString("diagnosis_history"));
				
				return pb;
			}});
			
	}
	
	public boolean modifyAilmentDetails(PatientBean pb) {
		String formatedDate = null;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(pb.getAppointmentDate());
			formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +cal.get(Calendar.YEAR);
			System.out.println("formatedDate : " + formatedDate);
			int ailmentUpdated = jdbcTemplate.update("update ec_tbl_patient set ailment_type='"+pb.getAilmentType()+"', ailment_details='"+pb.getAilmentDetails()+"', diagnosis_history='"+pb.getDiagnosisHistory()+"', appointment_date=to_date('"+formatedDate+"','dd/mm/yyyy') where patientid='"+pb.getPatientId()+"'");
			if(ailmentUpdated>0) 
				return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public ArrayList<PatientBean> viewAilmentDetails(String userid){
		
		ArrayList<PatientBean> patientBeanList = (ArrayList<PatientBean>)jdbcTemplate.query("select * from ec_tbl_patient where userid='"+userid+"'", new RowMapper<PatientBean>() {

			@Override
			public PatientBean mapRow(ResultSet rs, int rowNum) throws SQLException {
				PatientBean  pb = new PatientBean();
				pb.setPatientId(rs.getString("patientid"));
				pb.setUserId(rs.getString("userid"));
				pb.setAppointmentDate(rs.getDate("appointment_date"));
				pb.setAilmentType(rs.getString("ailment_type"));
				pb.setAilmentDetails(rs.getString("ailment_details"));
				pb.setDiagnosisHistory(rs.getString("diagnosis_history"));
				
				return pb;
			}
			
		});
		
		return patientBeanList; 
	}
	
//	public ArrayList<DoctorBean> viewListOfDoctors(String specialization, Date date){
	public ArrayList<DoctorBean> viewListOfDoctors(String specialization){
		ArrayList<DoctorBean> doctorBeanList = null;
		try {
			doctorBeanList = (ArrayList<DoctorBean>)jdbcTemplate.query("select * from ec_tbl_doctor where specialization='"+specialization+"'", new RowMapper<DoctorBean>() {
				
				@Override
				public DoctorBean mapRow(ResultSet rs, int rowNum) throws SQLException {
					DoctorBean  db = new DoctorBean();
					db.setDoctorId(rs.getString("doctorid"));
					db.setDoctorName(rs.getString("doctorname"));
					db.setDateOfBirth(rs.getDate("dateofbirth"));
					db.setDateOfJoining(rs.getDate("dateofjoining"));
					db.setGender(rs.getString("gender"));
					db.setQualification(rs.getString("qualification"));
					db.setSpecialization(rs.getString("specialization"));
					db.setYearsOfExperience(rs.getInt("yearsofexperience"));
					db.setStreet(rs.getString("street"));
					db.setLocation(rs.getString("location"));
					db.setCity(rs.getString("city"));
					db.setState(rs.getString("state"));
					db.setPincode(rs.getString("pincode"));
					db.setContactno(rs.getString("contactnumber"));
					db.setEmailid(rs.getString("emailid"));
					return db;
				}
			});
			if(doctorBeanList != null)
				return doctorBeanList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}
	
	public String requestforAppointment(AppointmentBean appointmentBean) {
		String formatedDate = null;
		String formatedDate2 = null;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(appointmentBean.getAppointmentDate());
			String monthName = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
			formatedDate2 = cal.get(Calendar.DATE) + "/" + monthName + "/" +cal.get(Calendar.YEAR);
			formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +cal.get(Calendar.YEAR);
			
			System.out.println("formatedDate : " + formatedDate);
		
			int isAppointmentAdded = jdbcTemplate.update("insert into ec_tbl_appointments values(concat('AP',QMC_SEQ_APPOINTMENTID.nextval),"
				+ "'"+appointmentBean.getDoctorId()+"','"+appointmentBean.getPatientId()+"',"
				+ "to_date('"+formatedDate+"','dd/MM/yyyy'),'"+appointmentBean.getAppointmentTime()+"')");
			int isAppointmentUpdated = jdbcTemplate.update("update ec_tbl_patient set appointment_date='"+formatedDate2+"' where patientid='"+appointmentBean.getPatientId()+"'");
			if(isAppointmentAdded>0 && isAppointmentUpdated>0) {
				return "Success";
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "Fail";
	}
	
	public ArrayList<DoctorBean> viewAllListOfDoctors(String doctorid, Date selectDate){
		ArrayList<DoctorBean> doctorBeanList = null;
		String formatedDate = null;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(selectDate);
			String monthName = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
			formatedDate = cal.get(Calendar.DATE) + "/" + monthName + "/" +cal.get(Calendar.YEAR);
						
			System.out.println("formatedDate : " + formatedDate);
			
			doctorBeanList = (ArrayList<DoctorBean>)jdbcTemplate.query("select * from ec_tbl_doctor "
					+ "where doctorid in (select doctorid from ec_tbl_appointments "
					+ "where doctorid='"+doctorid+"' and "
					+ "ec_tbl_appointments.appointment_date = ('"+formatedDate+"'))", 
					new RowMapper<DoctorBean>() {
				
				@Override
				public DoctorBean mapRow(ResultSet rs, int rowNum) throws SQLException {
					DoctorBean  db = new DoctorBean();
					db.setDoctorId(rs.getString("doctorid"));
					db.setDoctorName(rs.getString("doctorname"));
					db.setDateOfBirth(rs.getDate("dateofbirth"));
					db.setDateOfJoining(rs.getDate("dateofjoining"));
					db.setGender(rs.getString("gender"));
					db.setQualification(rs.getString("qualification"));
					db.setSpecialization(rs.getString("specialization"));
					db.setYearsOfExperience(rs.getInt("yearsofexperience"));
					db.setStreet(rs.getString("street"));
					db.setLocation(rs.getString("location"));
					db.setCity(rs.getString("city"));
					db.setState(rs.getString("state"));
					db.setPincode(rs.getString("pincode"));
					db.setContactno(rs.getString("contactnumber"));
					db.setEmailid(rs.getString("emailid"));
					return db;
				}
			});
			System.out.println("doctorBeanList for fixed : "+doctorBeanList);
			if(doctorBeanList != null)
				return doctorBeanList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}
}
