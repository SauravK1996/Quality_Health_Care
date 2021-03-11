package com.aq.qmc.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aq.qmc.bean.CredentialsBean;
import com.aq.qmc.bean.ProfileBean;
@Repository
public class UserUtility {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	 public String changePassword(String userid, String password) {
		 
		 try {
			int isPasswordUpdated = jdbcTemplate.update("update ec_tbl_user_credentials set password='"+password+"' where userid='"+userid+"'");
			
			if(isPasswordUpdated>0)
				return "Success";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "Fail";
		}
		 return "Fail";
	 }
	 
	 public String register(ProfileBean profileBean) {
		 
			try {
				String newUserid = profileBean.getFirstname().substring(0,2);
				String formatedDate = null;
				Calendar cal = Calendar.getInstance();
				cal.setTime(profileBean.getDateOfBirth());
				formatedDate = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +cal.get(Calendar.YEAR);
				System.out.println("formatedDate : " + formatedDate);
				
				System.out.println(newUserid);
				int isRegistered = jdbcTemplate.update("insert into ec_tbl_user_profile values"
					+ "(concat('"+newUserid+"',QMC_SEQ_USERID.nextval),'"+profileBean.getFirstname()+"',"
					+ "'"+profileBean.getLastname()+"',to_date('"+formatedDate+"','dd/mm/yyyy'),"
					+ "'"+profileBean.getGender()+"','"+profileBean.getStreet()+"',"
					+ "'"+profileBean.getLocation()+"','"+profileBean.getCity()+"',"
					+ "'"+profileBean.getState()+"','"+profileBean.getPincode()+"',"
					+ "'"+profileBean.getMobileno()+"','"+profileBean.getEmailid()+"',QMC_SEQ_USERID.currval)");
				
				System.out.println("isRegistered: "+isRegistered);

				int userRegistered = jdbcTemplate.update("insert into ec_tbl_user_credentials values"
					+ "(concat('"+newUserid+"',QMC_SEQ_USERID.currval),'"+profileBean.getPassword()+"','Patient',0)");
				System.out.println("userRegistered: "+userRegistered);
				
				List<String> str = jdbcTemplate.query("select userid from ec_tbl_user_profile where profileid = (select max(profileid) from ec_tbl_user_profile)", 
					new RowMapper() {
						@Override
						public String mapRow(ResultSet rs, int rowNum) throws SQLException {
							System.out.println(rs.getString("userid"));
							return rs.getString("userid");
						}
					});
				System.out.println("str : "+str.get(0));
				if(str.get(0)!=null)
					return str.get(0);
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
			return null;
	 }
	 
	 public String getPatientName(String userid) {
		 try {
			List<String> patientName = jdbcTemplate.query("select firstname from ec_tbl_user_profile where userid='"+userid+"'",new RowMapper<String>() {

				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					System.out.println("Patient name : "+ rs.getString("firstname"));
					return rs.getString("firstname");
				}
			});
			System.out.println("patientName : "+ patientName.get(0));
			if(patientName.get(0) != null)
				return patientName.get(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		 return null;
	 }

}
