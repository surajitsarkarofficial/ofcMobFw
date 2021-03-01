package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.beans.EmergencyContactDetails;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTAddEmergencyContactsService implements IMobileService<TravelNEXTAddEmergencyContactsService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTEmergencyContactsService emergencyContactService;

	/**
	 * This method will load the Add Emergency Contacts Page
	 * 
	 * @return TravelNEXTAddEmergencyContactsService
	 */
	@Override
	public TravelNEXTAddEmergencyContactsService loadPage() {
		travelNEXTPageProvider.getTravelNEXTAddEmergencyContactsPage();
		return this;
	}

	/**
	 * This method will navigate back to Emergency Contact Page
	 * 
	 * @return TravelNEXTEmergencyContactsService
	 */
	public TravelNEXTEmergencyContactsService navigateBackToEmergecnyContactPage() {
		travelNEXTPageProvider.getTravelNEXTAddEmergencyContactsPage().tapBackBtn();
		return emergencyContactService;
	}

	/**
	 * This method will fill Emergency Contact Form
	 * 
	 * @param emergencyContactData
	 * @return TravelNEXTAddEmergencyContactsService
	 */
	public TravelNEXTAddEmergencyContactsService fillEmergencyContactForm(
			EmergencyContactDetails emergencyContactData) {
		travelNEXTPageProvider.getTravelNEXTAddEmergencyContactsPage().enterFullName(emergencyContactData.getFullName())
				.enterRelationShip(emergencyContactData.getRelationship())
				.enterPhoneNo(emergencyContactData.getPhoneNo()).enterAddressField(emergencyContactData.getAddress());
		return this;
	}

	/**
	 * This method will tap add Emergency Contact
	 * 
	 * @param emergencyContactData
	 * @return TravelNEXTAddEmergencyContactsService
	 */
	public TravelNEXTAddEmergencyContactsService addEmergencyContact(EmergencyContactDetails emergencyContactData) {
		this.fillEmergencyContactForm(emergencyContactData);
		travelNEXTPageProvider.getTravelNEXTAddEmergencyContactsPage().tapAddButton();
		return this;
	}

}
