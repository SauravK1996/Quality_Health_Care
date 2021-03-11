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
import com.aq.qmc.bean.LeaveBean;
import com.aq.qmc.bean.PatientBean;

@Repository
public class AdministratorDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String addDoctor(DoctorBean doctorBean) {
		String doctorDateOfBirth = null;
		String doctorDateOfJoining = null;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(doctorBean.getDateOfBirth());
			doctorDateOfBirth = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +cal.get(Calendar.YEAR);
			cal.setTime(doctorBean.getDateOfJoining());
			doctorDateOfJoining = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +cal.get(Calendar.YEAR);
			
			int isDoctorAdded = jdbcTemplate.update("insert into ec_tbl_doctor values(concat('D',QMC_SEQ_DOCTORID.nextval),"
					+ "'"+doctorBean.getDoctorName()+"',to_date('"+doctorDateOfBirth+"','dd/mm/yyyy'),"
					+ "to_date('"+doctorDateOfJoining+"','dd/mm/yyyy'),'"+doctorBean.getGender()+"',"
					+ "'"+doctorBean.getQualification()+"','"+doctorBean.getSpecialization()+"',"
					+ ""+doctorBean.getYearsOfExperience()+",'"+doctorBean.getStreet()+"','"+doctorBean.getLocation()+"',"
					+ "'"+doctorBean.getCity()+"','"+doctorBean.getState()+"','"+doctorBean.getPincode()+"',"
					+ "'"+doctorBean.getContactno()+"','"+doctorBean.getEmailid()+"')");
			
			int doctorRegistered = jdbcTemplate.update("insert into ec_tbl_user_credentials values"
					+ "(concat('D',QMC_SEQ_DOCTORID.currval),concat('D',QMC_SEQ_DOCTORID.currval),'Doctor',0)");
				System.out.println("doctorRegistered: "+doctorRegistered);
				
			System.out.println("isDoctorAdded : "+isDoctorAdded);
			if(isDoctorAdded>0)
				return "Success";
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return "Fail";	
		}
		
		return "Fail";	
	}
	@SuppressWarnings("deprecation")
	public DoctorBean getDoctorById(String doctorid) {
		try {
			return (DoctorBean) jdbcTemplate.queryForObject("select * from ec_tbl_doctor where doctorid=?", new Object[] {doctorid}, new RowMapper<DoctorBean>() {

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
				}});
			
		} catch (Exception e) {
			return null;
		}
	}
	public Boolean modifyDoctor(DoctorBean doctorBean) {
		String doctorDateOfBirth = null;
		String doctorDateOfJoining = null;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(doctorBean.getDateOfBirth());
			doctorDateOfBirth = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +cal.get(Calendar.YEAR);
			cal.setTime(doctorBean.getDateOfJoining());
			doctorDateOfJoining = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +cal.get(Calendar.YEAR);
			
			int isDoctorUpdated = jdbcTemplate.update("update ec_tbl_doctor set "
					+ "doctorname='"+doctorBean.getDoctorName()+"',dateofbirth=to_date('"+doctorDateOfBirth+"','dd/mm/yyyy'),"
					+ "dateofjoining=to_date('"+doctorDateOfJoining+"','dd/mm/yyyy'),gender='"+doctorBean.getGender()+"',"
					+ "qualification='"+doctorBean.getQualification()+"',specialization='"+doctorBean.getSpecialization()+"',"
					+ "yearsofexperience="+doctorBean.getYearsOfExperience()+",street='"+doctorBean.getStreet()+"',location='"+doctorBean.getLocation()+"',"
					+ "city='"+doctorBean.getCity()+"',state='"+doctorBean.getState()+"',pincode='"+doctorBean.getPincode()+"',"
					+ "contactnumber='"+doctorBean.getContactno()+"',emailid='"+doctorBean.getEmailid()+"' where doctorid='"+doctorBean.getDoctorId()+"'");
			if(isDoctorUpdated>0)
				return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<DoctorBean> viewAllDoctors(){
		ArrayList<DoctorBean> doctorBeanList = null;
		try {
			doctorBeanList = (ArrayList<DoctorBean>)jdbcTemplate.query("select * from ec_tbl_doctor", new RowMapper<DoctorBean>() {
				
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
			return doctorBeanList;
		} catch (Exception e) { 
			System.out.println("Error : "+e.getMessage());			
			return null;
		}
	}
	
	public int removeDoctor(String doctorId) {
		try {
			int isDoctorDeletedFromAppointment = jdbcTemplate.update("delete from ec_tbl_appointments where doctorid='"+doctorId+"'");
			int isDoctorDeletedFromSchedules = jdbcTemplate.update("delete from ec_tbl_leave where doctorid='"+doctorId+"'");
			int isDoctorDeletedFromLeave = jdbcTemplate.update("delete from ec_tbl_schedules where doctorid='"+doctorId+"'");
			int isDoctorDeleted = jdbcTemplate.update("delete from ec_tbl_doctor where doctorid='"+doctorId+"'");
			if(isDoctorDeleted>0)
				return isDoctorDeleted;
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public ArrayList<DoctorBean> suggestDoctors(String patientId, Date date){
		return new ArrayList<DoctorBean>();
	}
	
	public ArrayList<PatientBean> viewPatientByDate(Date appointmentDate){
		String formatedDate = null;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(appointmentDate);
			String monthName = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
			formatedDate = cal.get(Calendar.DATE) + "/" + monthName + "/" +cal.get(Calendar.YEAR);
			System.out.println("formatedDate : " + formatedDate);
			
			ArrayList<PatientBean> patientList = (ArrayList<PatientBean>)jdbcTemplate.query("select * from ec_tbl_patient where patientid in (select patientid from "
					+ "ec_tbl_appointments where appointment_date='"+formatedDate+"')", new RowMapper<PatientBean>() {

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
			if(patientList!=null)
				return patientList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public ArrayList<LeaveBean> doctorsLeaveList() {
		try {
			ArrayList<LeaveBean> leaveList = (ArrayList<LeaveBean>) jdbcTemplate.query("select * from ec_tbl_leave where status=0", new RowMapper<LeaveBean>() {

				@Override
				public LeaveBean mapRow(ResultSet rs, int rowNum) throws SQLException {
					LeaveBean leaveBean = new LeaveBean();
					leaveBean.setLeaveid(rs.getString("leaveid"));
					leaveBean.setDoctorid(rs.getString("doctorid"));
					leaveBean.setLeaveFrom(rs.getDate("leave_from"));
					leaveBean.setLeaveTo(rs.getDate("leave_to"));
					leaveBean.setReason(rs.getString("reason"));
					leaveBean.setStatus(rs.getInt("status"));
					return leaveBean;
				}
			});
			if(leaveList != null)
				return leaveList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}
	
	public String updateLeave(String leaveid) {
		try {
			int isLeaveApproved = jdbcTemplate.update("update ec_tbl_leave set status=1 where leaveid='"+leaveid+"'");
			if(isLeaveApproved>0)
				return "Success";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "Success";
		}
		return "Fail";
	}
}
