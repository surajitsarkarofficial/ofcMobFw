package com.globant.qe.in.travelNEXT.mobile.beans;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@PropertySource({ "classpath:personaldetails.properties","classpath:applicationMobile.properties"})
@Component
public class PersonalDeatils {
	
	@Value("${document.no}")
	private String documentNo;
	
	@Value("${gender}")
	private String gender;
	
	@Value("${date.of.birth}")
	private String dob;
	
	@Value("${nationality}")
	private String nationality;
	
	@Value("${phone.no}")
	private String phoneNo;
	
	@Value("${passport.no}")
	private String passportNo;
	
	@Value("${passport.exp.date}")
	private String passportExpDate;
	
	@Value("${passport.country}")
	private String country;
	
	@Value("${logged.in.user}")
	private String globerName;
	
	@Value("${logged.in.user.mailId}")
	private String globerMailId;
	
	@Value("${glober.feedback.rating}")
	private String globerRatings;
	
	@Value("${glober.feedback.comment}")
	private String globerComment;
	
	@PostConstruct
    public void init(){
               
    }
	
	public String getTravelAppGloberName() {
		return globerName;
	}
	
	public String getTravelAppGloberMailId() {
		return globerMailId;
	}
	
	public String getDocumentNo() {
		return documentNo;
	}

	public String getGender() {
		return gender;
	}
	
	public String getDOB() {
		return dob;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	
	public String getPassportNo() {
		return passportNo;
	}
	
	public String getPassportExpDate() {
		return passportExpDate;
	}
	
	public String getPassportCountry() {
		return country;
	}
	
	public String getGloberRatings() {
		return globerRatings;
	}
	
	public String getGloberComment() {
		return globerComment;
	}
}
