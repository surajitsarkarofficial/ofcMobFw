package com.globant.qe.in.travelNEXT.mobile.provider;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTAboutAppService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTAboutDetailsService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTFeedbackService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTFeedbackSuccessService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTFrequentFlyerNumbersService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTHomeService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTPassengerService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTAddEmergencyContactsService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTAddFrequentFlyerNumbersService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTCostAllocationService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTCreateTripService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTEditEmergencyContactsService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTEmergencyContactDetailsService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTEmergencyContactsService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTPassportDetailsService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTPersonalDetailsService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTSideBarService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTWelcomeService;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTPassengerPage;

@Service
public class TravelNEXTServiceProvider {

	@Autowired
	TravelNEXTWelcomeService travelNEXTWelcomeService;

	@Autowired
	TravelNEXTHomeService travelNEXTHomeService;

	@Autowired
	TravelNEXTSideBarService travelNEXTSideBarServices;

	@Autowired
	TravelNEXTPersonalDetailsService travelNEXTPersonalDetailsService;

	@Autowired
	TravelNEXTPassportDetailsService travelNEXTPassportDetailsService;

	@Autowired
	TravelNEXTEmergencyContactsService travelNEXTEmergencyContactsService;

	@Autowired
	TravelNEXTFrequentFlyerNumbersService travelNEXTFrequentFlyerNumbersService;

	@Autowired
	TravelNEXTAddFrequentFlyerNumbersService travelNEXTAddFrequentFlyerNumbersService;

	@Autowired
	TravelNEXTAddEmergencyContactsService travelNEXTAddEmergencyContactsService;

	@Autowired
	TravelNEXTEditEmergencyContactsService travelNEXTEditEmergencyContactsService;

	@Autowired
	TravelNEXTFeedbackService travelNEXTFeedbackService;

	@Autowired
	TravelNEXTFeedbackSuccessService travelNEXTFeedbackSuccessService;

	@Autowired
	TravelNEXTAboutAppService travelNEXTAboutAppService;

	@Autowired
	TravelNEXTEmergencyContactDetailsService travelNEXTEmergencyContactDetailsService;

	@Autowired
	TravelNEXTAboutDetailsService travelNEXTAboutDetailsService;
	
	@Autowired
	TravelNEXTCreateTripService travelNEXTCreateTripService;
	
	@Autowired
	TravelNEXTCostAllocationService travelNEXTCostAllocationService;

	@Autowired
	TravelNEXTPassengerService travelNEXTPassengerService;
	/**
	 * This method will take to Welcome Service
	 * 
	 * @return TravelNEXTWelcomeService
	 */
	public TravelNEXTWelcomeService getTravelNEXTWelcomeService() {
		return travelNEXTWelcomeService;
	}

	/**
	 * This method will take to Home Service
	 * 
	 * @return TravelNEXTHomeService
	 */
	public TravelNEXTHomeService getTravelNEXTHomeService() {
		return travelNEXTHomeService;
	}

	/**
	 * This method will take to SideBar Service
	 * 
	 * @return TravelNEXTSideBarService
	 */
	public TravelNEXTSideBarService getTravelNEXTSideBarService() {
		return travelNEXTSideBarServices;
	}

	/**
	 * This method will take to Personal Details Service
	 * 
	 * @return TravelNEXTPersonalDetailsService
	 */
	public TravelNEXTPersonalDetailsService getTravelNEXTPersonalDetailsService() {
		return travelNEXTPersonalDetailsService;
	}

	/**
	 * This method will take to Passport Details Service
	 * 
	 * @return TravelNEXTPassportDetailsService
	 */
	public TravelNEXTPassportDetailsService getTravelNEXTPassportDetailsServices() {
		return travelNEXTPassportDetailsService;
	}

	/**
	 * This method will take to Emergency Contacts Service
	 * 
	 * @return TravelNEXTEmergencyContactsService
	 */
	public TravelNEXTEmergencyContactsService getTravelNEXTEmergencyContactsService() {
		return travelNEXTEmergencyContactsService;
	}

	/**
	 * This method will take to Add Emergency Contacts Service
	 * 
	 * @return TravelNEXTAddEmergencyContactsService
	 */
	public TravelNEXTAddEmergencyContactsService getTravelNEXTAddEmergencyContactsService() {
		return travelNEXTAddEmergencyContactsService;
	}

	/**
	 * This method will take to Edit Emergency Contacts Service
	 * 
	 * @return TravelNEXTEditEmergencyContactsService
	 */
	public TravelNEXTEditEmergencyContactsService getTravelNEXTEditEmergencyContactsService() {
		return travelNEXTEditEmergencyContactsService;
	}

	/**
	 * This method will take to Add Frequent Flyer Numbers Service
	 * 
	 * @return TravelNEXTAddFrequentFlyerNumbersService
	 */
	public TravelNEXTAddFrequentFlyerNumbersService getTravelNEXTAddFrequentFlyerNumbersService() {
		return travelNEXTAddFrequentFlyerNumbersService;
	}

	/**
	 * This method will take to Frequent Flyer Numbers Service
	 * 
	 * @return TravelNEXTFrequentFlyerNumbersService
	 */
	public TravelNEXTFrequentFlyerNumbersService getTravelNEXTFrequentFlyerNumbersService() {
		return travelNEXTFrequentFlyerNumbersService;
	}

	/**
	 * This method will take to Feedback Service
	 * 
	 * @return TravelNEXTFeedbackService
	 */
	public TravelNEXTFeedbackService getTravelNEXTFeedbackService() {
		return travelNEXTFeedbackService;
	}

	/**
	 * This method will take to FeedbackSuccess Service
	 * 
	 * @return TravelNEXTFeedbackSuccessService
	 */
	public TravelNEXTFeedbackSuccessService getTravelNEXTFeedbackSuccessService() {
		return travelNEXTFeedbackSuccessService;
	}

	/**
	 * This method will take to About App Service
	 * 
	 * @return TravelNEXTAboutAppService
	 */
	public TravelNEXTAboutAppService getTravelNEXTAboutAppService() {
		return travelNEXTAboutAppService;
	}

	/**
	 * This method will take to Emergency Contact Details Service
	 * 
	 * @return TravelNEXTEmergencyContactDetailsService
	 */
	public TravelNEXTEmergencyContactDetailsService getTravelNEXTEmergencyContactDetailsService() {
		return travelNEXTEmergencyContactDetailsService;
	}

	/**
	 * This method will take to About TraveNEXT Details Service
	 * 
	 * @return TravelNEXTAboutDetailsService
	 */
	public TravelNEXTAboutDetailsService getTravelNEXTAboutDetailsService() {
		return travelNEXTAboutDetailsService;
	}

	/**
	 * This method will take to Create trip service page
	 * 
	 * @return TravelNEXTCreateTripService
	 */
	public TravelNEXTCreateTripService getTravelNEXTCreateTripService() {
		return travelNEXTCreateTripService;
	}
	
	/**
	 * This method will take to Cost Allocation service page
	 * 
	 * @return TravelNEXTCostAllocationService
	 */
	public TravelNEXTCostAllocationService getTravelNEXTCostAllocationService() {
		return travelNEXTCostAllocationService;
	}
	
	/**
	 * This method will take to Passengers page
	 * 
	 * @return TravelNEXTPassengerService
	 */
	public TravelNEXTPassengerService getTravelNEXTPassengerService() {
		return travelNEXTPassengerService;
	}
}
