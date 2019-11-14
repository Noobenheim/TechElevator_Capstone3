package com.techelevator.npgeek.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {
	
	private Long surveyId;
	
	@NotBlank(message="Park Selection is Required")
	@Size(max=10, message="Park Code cannot be over 10 characters")
	private String parkCode;
	
	@NotBlank(message="Email Address is Required")
	@Email(message="Email must be a valid email address")
	@Size(max=100, message="Email Address cannot be over 100 characters")
	private String emailAddress;
	
	@NotBlank(message="State Selection is Required")
	@Size(max=30, message="State cannot be over 30 characters")
	private String state;
	
	@NotBlank(message="Activity Level is Required")
	@Size(max=100, message="Activity Level cannot be over 100 characters")
	private String activityLevel;
	
	public Long getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}

}
