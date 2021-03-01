package com.globant.qe.in.travelNEXT.mobile.beans;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@PropertySource({ "classpath:emergencyContactDetails.properties"})
@Component
public class EmergencyContactDetails {
	
	@Value("${emergency.contact.fullName}")
	private static String fullName;
	
	@Value("${emergency.contact.relationship}")
	private String relationship;
	
	@Value("${emergency.contact.phone.no}")
	private static String phoneNo;	
	
	@Value("${emergency.contact.address}")
	private String address;
	@PostConstruct
    public void init(){
               
    }
	public String getFullName() {
		return fullName;
	}
	public String getRelationship() {
		return relationship;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setFullName(String fName) {
		
		fullName=fName;
	}
	public void setPhoneNumber(String pNo) {
		
		phoneNo=pNo;
	}
	
	
}
