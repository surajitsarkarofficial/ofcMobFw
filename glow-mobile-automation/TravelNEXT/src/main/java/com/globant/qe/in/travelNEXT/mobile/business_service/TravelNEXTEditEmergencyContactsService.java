package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.beans.EmergencyContactDetails;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTEditEmergencyContactsService implements IMobileService<TravelNEXTEditEmergencyContactsService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTViewEmergencyContactsService viewEmergencyContactService;

	/**
	 * This method will load the Edit Emergency Contacts Page
	 * 
	 * @return TravelNEXTEditEmergencyContactsService
	 */
	@Override
	public TravelNEXTEditEmergencyContactsService loadPage() {
		travelNEXTPageProvider.getTravelNEXTEditEmergencyContactsPage();
		return this;
	}

	/**
	 * This method will navigate back to view Emergency Contact Page
	 * 
	 * @return TravelNEXTViewEmergencyContactsServices
	 */
	public TravelNEXTViewEmergencyContactsService navigateBackToViewEmergecnyContactPage() {
		travelNEXTPageProvider.getTravelNEXTEditEmergencyContactsPage().tapBackBtn();
		return viewEmergencyContactService;
	}

	/**
	 * This method will fill Emergency Contact Form
	 * 
	 * @param emergencyContactData
	 * @return TravelNEXTEditEmergencyContactsService
	 */
	public TravelNEXTEditEmergencyContactsService fillEmergencyContactForm(
			EmergencyContactDetails emergencyContactData) {
		travelNEXTPageProvider.getTravelNEXTEditEmergencyContactsPage()
				.enterFullName(emergencyContactData.getFullName())
				.enterRelationShip(emergencyContactData.getRelationship())
				.enterPhoneNo(emergencyContactData.getPhoneNo()).enterAddressField(emergencyContactData.getAddress());
		return this;
	}

}
