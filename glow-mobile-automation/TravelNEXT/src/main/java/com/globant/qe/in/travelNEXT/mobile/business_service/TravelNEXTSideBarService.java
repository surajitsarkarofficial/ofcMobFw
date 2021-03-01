package com.globant.qe.in.travelNEXT.mobile.business_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.globant.qe.in.IMobileService;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTPageProvider;

@Component
@Lazy
public class TravelNEXTSideBarService implements IMobileService<TravelNEXTSideBarService> {

	@Autowired
	TravelNEXTPageProvider travelNEXTPageProvider;

	@Autowired
	TravelNEXTWelcomeService welcomeService;

	@Autowired
	TravelNEXTPersonalDetailsService personalDetailsService;

	@Autowired
	TravelNEXTPassportDetailsService passportDetailsService;

	@Autowired
	TravelNEXTFrequentFlyerNumbersService frequentFlyerNumbers;

	@Autowired
	TravelNEXTHotelLoyaltyProgramsService hotelLoyaltyPrograms;

	@Autowired
	TravelNEXTEmergencyContactsService emergencyContactsService;

	@Autowired
	TravelNEXTAboutDetailsService travelNextAbout;

	@Autowired
	TravelNEXTFeedbackService feedbackService;

	@Autowired
	TravelNEXTAboutAppService aboutService;

	/**
	 * This method will load the SideBar Service page
	 * 
	 * @return TravelNEXTSideBarService
	 */
	@Override
	public TravelNEXTSideBarService loadPage() {
		travelNEXTPageProvider.getTravelNEXTSideBarPage();
		return this;
	}

	/**
	 * This method will do Logout
	 * 
	 * @return TravelNEXTWelcomeService
	 */
	public TravelNEXTWelcomeService logout() {
		travelNEXTPageProvider.getTravelNEXTSideBarPage().tapSignOut();
		return welcomeService;
	}

	/**
	 * This method will take to Feedback page
	 * 
	 * @return TravelNEXTFeedbackService
	 */
	public TravelNEXTFeedbackService goToTravelNEXTFeedback() {
		travelNEXTPageProvider.getTravelNEXTSideBarPage().tapFeedback();
		return feedbackService;
	}

	/**
	 * This method will take to TravelNEXT About page
	 * 
	 * @return TravelNEXTAboutAppService
	 */
	public TravelNEXTAboutAppService goToTravelNEXTAbout() {
		travelNEXTPageProvider.getTravelNEXTSideBarPage().tapAboutTravelNEXT();
		return aboutService;
	}

	/**
	 * This method will take to Personal details page
	 * 
	 * @return TravelNEXTPersonalDetailsService
	 */
	public TravelNEXTPersonalDetailsService goToPersonalDetails() {
		travelNEXTPageProvider.getTravelNEXTSideBarPage().tapPersonal();
		return personalDetailsService;
	}

	/**
	 * This method will take to Passport details page
	 * 
	 * @return TravelNEXTPassportDetailsService
	 */
	public TravelNEXTPassportDetailsService goToPassportDetails() {
		travelNEXTPageProvider.getTravelNEXTSideBarPage().tapPassport();
		return passportDetailsService;
	}

	/**
	 * This method will take to Emergency Contacts page
	 * 
	 * @return TravelNEXTEmergencyContactsService
	 */
	public TravelNEXTEmergencyContactsService goToEmergencyContacts() {
		travelNEXTPageProvider.getTravelNEXTSideBarPage().tapEmergencyContacts();
		return emergencyContactsService;
	}

	/**
	 * This method will take to Frequent Flyer page
	 * 
	 * @return TravelNEXTFrequentFlyerNumbersService
	 */
	public TravelNEXTFrequentFlyerNumbersService goToFrequentFlyerNumbers() {
		travelNEXTPageProvider.getTravelNEXTSideBarPage().tapFrequentFlyerNumbers();
		return frequentFlyerNumbers;
	}

	/**
	 * This method will take to Hotel Loyalty Programs
	 * 
	 * @return TravelNEXTHotelLoyaltyProgramsService
	 */
	public TravelNEXTHotelLoyaltyProgramsService goToHotelLoyaltyPrograms() {
		travelNEXTPageProvider.getTravelNEXTSideBarPage().tapHotelLoyaltyPrograms();
		return hotelLoyaltyPrograms;
	}
}
