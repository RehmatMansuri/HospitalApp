package com.hospitalapp.pojo;

public class Patient {
  private Integer patientId;
  private String pName;
  private Integer pAge;
  private String pGender;
  
  
	public Patient() {
		super();
			}


	public Patient(Integer patientId, String pName, Integer pAge, String pGender) {
		super();
		this.patientId = patientId;
		this.pName = pName;
		this.pAge = pAge;
		this.pGender = pGender;
	}


	public int getPatientId() {
		return patientId;
	}


	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}


	public String getpName() {
		return pName;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public int getpAge() {
		return pAge;
	}


	public void setpAge(int pAge) {
		this.pAge = pAge;
	}


	public String getpGender() {
		return pGender;
	}


	public void setpGender(String pGender) {
		this.pGender = pGender;
	}


	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", pName=" + pName + ", pAge=" + pAge + ", pGender=" + pGender + "]";
	}
	
}
