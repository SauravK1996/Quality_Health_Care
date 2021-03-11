package com.aq.qmc.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class PatientBean {
	private String patientId;
	private String userId;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date appointmentDate;
	private String ailmentType;
	private String ailmentDetails;
	private String diagnosisHistory;
	
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAilmentType() {
		return ailmentType;
	}
	public void setAilmentType(String ailmentType) {
		this.ailmentType = ailmentType;
	}
	public String getAilmentDetails() {
		return ailmentDetails;
	}
	public void setAilmentDetails(String ailmentDetails) {
		this.ailmentDetails = ailmentDetails;
	}
	public String getDiagnosisHistory() {
		return diagnosisHistory;
	}
	public void setDiagnosisHistory(String diagnosisHistory) {
		this.diagnosisHistory = diagnosisHistory;
	}
	@Override
	public String toString() {
		return "PatientBean [patientId=" + patientId + ", userId=" + userId + ", appointmentDate=" + appointmentDate
				+ ", ailmentType=" + ailmentType + ", ailmentDetails=" + ailmentDetails + ", diagnosisHistory="
				+ diagnosisHistory + "]";
	}
	
}
