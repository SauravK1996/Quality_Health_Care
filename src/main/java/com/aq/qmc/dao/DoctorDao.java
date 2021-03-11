package com.aq.qmc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.aq.qmc.bean.AppointmentBean;
import com.aq.qmc.bean.LeaveBean;

@Repository
public class DoctorDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ArrayList<AppointmentBean> checkAppointment(String doctorid){
		try {
			ArrayList<AppointmentBean> appointmentList = (ArrayList<AppointmentBean>) jdbcTemplate.query("select * from ec_tbl_appointments where doctorid='"+doctorid+"'", new RowMapper<AppointmentBean>() {

				@Override
				public AppointmentBean mapRow(ResultSet rs, int rowNum) throws SQLException {
					AppointmentBean appBean = new AppointmentBean();
					appBean.setAppointmentId(rs.getString("appointmentid"));
					appBean.setDoctorId(rs.getString("doctorid"));
					appBean.setPatientId(rs.getString("patientid"));
					appBean.setAppointmentDate(rs.getDate("appointment_date"));
					appBean.setAppointmentTime(rs.getString("appointment_time"));
					return appBean;
				}
			});
			if(appointmentList != null) 
				return appointmentList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}
	
	public String applyForLeave(LeaveBean leaveBean) {
		String leaveFrom = null;
		String leaveTo = null;
		try {
			Calendar cal = Calendar.getInstance();
			Calendar cal2 = Calendar.getInstance();
			cal.setTime(leaveBean.getLeaveFrom());
			leaveFrom = cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" +cal.get(Calendar.YEAR);
			
			cal2.setTime(leaveBean.getLeaveTo());
			leaveTo = cal2.get(Calendar.DATE) + "/" + (cal2.get(Calendar.MONTH) + 1) + "/" +cal2.get(Calendar.YEAR);
						
			int isLeaveAdded = jdbcTemplate.update("insert into ec_tbl_leave values(QMC_SEQ_LEAVEID.nextval,"
					+ "'"+leaveBean.getDoctorid()+"',to_date('"+leaveFrom+"','dd/MM/yyyy'),"
					+ "to_date('"+leaveTo+"','dd/MM/yyyy'),'"+leaveBean.getReason()+"',0)");
			if(isLeaveAdded>0) 
				return "Success";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "Fail";
		}
		return "Fail";
	}
	
	public ArrayList<LeaveBean> checkLeaveStatus(String doctorid){
		try {
			ArrayList<LeaveBean> leaveBeanList = (ArrayList<LeaveBean>)jdbcTemplate.query("select * from ec_tbl_leave"
					+ " where doctorid='"+doctorid+"'", new RowMapper<LeaveBean>() {

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
			if(leaveBeanList != null)
				return leaveBeanList;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		return null;
	}

	public String cancelLeave(String leaveid) {
		try {
			int isLeaveCancelled = jdbcTemplate.update("delete from ec_tbl_leave where leaveid='"+leaveid+"'");
			if(isLeaveCancelled>0)
				return "Success";
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return "Fail";
		}
		return "Fail";
	}

	public LeaveBean getLeaveById(String leaveid) {
		try {
			LeaveBean leaveBean = (LeaveBean) jdbcTemplate.queryForObject("select * from ec_tbl_leave where leaveid=?",new Object[] {leaveid},new RowMapper<LeaveBean>() {
				
				@Override
				public LeaveBean mapRow(ResultSet rs, int rowNum) throws SQLException {
					LeaveBean lBean = new LeaveBean();
					lBean.setLeaveid(rs.getString("leaveid"));
					lBean.setDoctorid(rs.getString("doctorid"));
					lBean.setLeaveFrom(rs.getDate("leave_from"));
					lBean.setLeaveTo(rs.getDate("leave_to"));
					lBean.setReason(rs.getString("reason"));
					lBean.setStatus(rs.getInt("status"));
					return lBean;
				}
				
			});
			System.out.println("leaveBean from dao : "+leaveBean);
			if(leaveBean != null)
				return leaveBean;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		} 
		return null;
}

	public String updateLeave(LeaveBean leaveBean) {
		String leaveFrom = null;
		String leaveTo = null;
		try {
			Calendar cal = Calendar.getInstance();
			String leaveFromMonth = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
			
			cal.setTime(leaveBean.getLeaveFrom());
			leaveFrom = cal.get(Calendar.DATE) + "/" + leaveFromMonth + "/" +cal.get(Calendar.YEAR);

			Calendar cal2 = Calendar.getInstance();
			String leaveToMonth = cal2.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH );
			
			cal2.setTime(leaveBean.getLeaveTo());
			leaveTo = cal2.get(Calendar.DATE) + "/" + leaveToMonth + "/" +cal2.get(Calendar.YEAR);
						
			int isLeaveAdded = jdbcTemplate.update("update ec_tbl_leave set leave_from='"+leaveFrom+"', leave_to='"+leaveTo+"', reason='"+leaveBean.getReason()+"' where leaveid='"+leaveBean.getLeaveid()+"' and doctorid='"+leaveBean.getDoctorid()+"'");
			if(isLeaveAdded>0) 
				return "Success";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "Fail";
		}
		return "Fail";
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
