package com.aq.qmc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aq.qmc.bean.DoctorBean;
import com.aq.qmc.bean.PatientBean;

@Repository
public class ReporterDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ArrayList<DoctorBean> viewAllAvailableDoctors(Date selectDate){
		String formatedDate = null;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(selectDate);
			String monthName = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
			formatedDate = cal.get(Calendar.DATE) + "/" + monthName + "/" +cal.get(Calendar.YEAR);
			System.out.println("formatedDate : " + formatedDate);
			
			ArrayList<DoctorBean> doctorsList = (ArrayList<DoctorBean>)jdbcTemplate.query("select * from ec_tbl_doctor where doctorid in "
					+ "(select doctorid from ec_tbl_appointments where"
					+ " ec_tbl_appointments.appointment_date not in ('"+formatedDate+"'))", 
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
			System.out.println("adoctorsList availability : "+doctorsList);
			if(doctorsList != null)
				return doctorsList;
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public ArrayList<DoctorBean> intimateAdmin(){
		String formatedDate = null;
		try {
			ArrayList<DoctorBean> doctorBeanList = (ArrayList<DoctorBean>)jdbcTemplate.query("select * from ec_tbl_doctor where doctorid "
					+ "in (select ec_tbl_appointments.DOCTORID from ec_tbl_appointments, ec_tbl_leave where "
					+ "ec_tbl_appointments.DOCTORID = ec_tbl_leave.DOCTORID  and ec_tbl_leave.status = 1 and "
					+ "ec_tbl_appointments.appointment_date between ec_tbl_leave.leave_from and ec_tbl_leave.leave_to)", 
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
			System.out.println("doctorBeanList : "+doctorBeanList);
			if(doctorBeanList != null)
				return doctorBeanList;
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
