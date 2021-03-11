package com.aq.qmc.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class LeaveBean {
	private String leaveid;
	private String doctorid;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date leaveFrom;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date leaveTo;
	
	private String reason;
	private int status;
	
	public String getLeaveid() {
		return leaveid;
	}
	public void setLeaveid(String leaveid) {
		this.leaveid = leaveid;
	}
	public String getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(String doctorid) {
		this.doctorid = doctorid;
	}
	public Date getLeaveFrom() {
		return leaveFrom;
	}
	public void setLeaveFrom(Date leaveFrom) {
		this.leaveFrom = leaveFrom;
	}
	public Date getLeaveTo() {
		return leaveTo;
	}
	public void setLeaveTo(Date leaveTo) {
		this.leaveTo = leaveTo;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LeaveBean [leaveid=" + leaveid + ", doctorid=" + doctorid + ", leaveFrom=" + leaveFrom + ", leaveTo="
				+ leaveTo + ", reason=" + reason + ", status=" + status + "]";
	}
}
