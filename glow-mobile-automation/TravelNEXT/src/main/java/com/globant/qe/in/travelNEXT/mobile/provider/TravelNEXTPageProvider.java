package com.globant.qe.in.travelNEXT.mobile.provider;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTAboutAppPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTFeedbackPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTFeedbackSuccessPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTFrequentFlyerNumbersPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTHistoryPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTHomePage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTHotelLoyaltyProgramsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTItineraryPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTMoreInfoPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTPassengerPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTAddEmergencyContactsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTAddFrequentFlyerNumbersPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTAddHotelLoyaltyProgramsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTCommentsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTCostAllocationPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTCreateTripPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTEditEmergencyContactsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTEditFrequentFlyerNumbersPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTEditHotelLoyaltyProgramsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTEmergencyContactDetailsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTEmergencyContactsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTPersonalDetailsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTPassportDetailsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTSideBarPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTTravelPolicyPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTViewEmergencyContactsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTViewFrequentFlyerNumbersPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTViewHotelLoyaltyProgramsPage;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTWelcomePage;

@Component
@Lazy
public class TravelNEXTPageProvider {

	@Autowired
	TravelNEXTWelcomePage travelNEXTWelcomePage;

	@Autowired
	TravelNEXTHomePage travelNEXTHomePage;

	@Autowired
	TravelNEXTSideBarPage travelNEXTSideBarPage;

	@Autowired
	TravelNEXTPersonalDetailsPage travelNEXTPersonalDetailsPage;

	@Autowired
	TravelNEXTPassportDetailsPage travelNEXTPassportDetailsPage;

	@Autowired
	TravelNEXTEmergencyContactsPage travelNEXTEmergencyContactsPage;

	@Autowired
	TravelNEXTAddEmergencyContactsPage travelNEXTAddEmergencyContactsPage;

	@Autowired
	TravelNEXTFrequentFlyerNumbersPage travelNEXTFrequentFlyerNumbersPage;

	@Autowired
	TravelNEXTAddFrequentFlyerNumbersPage travelNEXTAddFrequentFlyerNumbersPage;

	@Autowired
	TravelNEXTEditFrequentFlyerNumbersPage travelNEXTEditFrequentFlyerNumbersPage;

	@Autowired
	TravelNEXTViewFrequentFlyerNumbersPage travelNEXTViewFrequentFlyerNumbersPage;

	@Autowired
	TravelNEXTHotelLoyaltyProgramsPage travelNEXTHotelLoyaltyProgramsPage;

	@Autowired
	TravelNEXTAddHotelLoyaltyProgramsPage travelNEXTAddHotelLoyaltyProgramsPage;
	
	@Autowired
	TravelNEXTViewHotelLoyaltyProgramsPage travelNEXTViewHotelLoyaltyProgramsPage;
	
	@Autowired
	TravelNEXTEditHotelLoyaltyProgramsPage travelNEXTEditHotelLoyaltyProgramsPage;
	
	@Autowired
	TravelNEXTFeedbackPage travelNEXTFeedbackPage;

	@Autowired
	TravelNEXTFeedbackSuccessPage travelNEXTFeedbackSuccessPage;

	@Autowired
	TravelNEXTAboutAppPage travelNEXTAboutAppPage;

	@Autowired
	TravelNEXTTravelPolicyPage travelNEXTTravelPolicy;

	@Autowired
	TravelNEXTEmergencyContactDetailsPage travelNEXTEmergencyContactDetailsPage;

	@Autowired
	TravelNEXTEditEmergencyContactsPage travelNEXTEditEmergencyContactsPage;

	@Autowired
	TravelNEXTViewEmergencyContactsPage travelNEXTViewEmergencyContactsPage;

	@Autowired
	TravelNEXTItineraryPage travelNEXTItineraryPage;
	
	@Autowired
	TravelNEXTHistoryPage travelNEXTHistoryPage;
	
	@Autowired
	TravelNEXTCommentsPage travelNEXTCommentsPage;
	
	@Autowired
	TravelNEXTMoreInfoPage travelNEXTMoreInfoPage;
	
	@Autowired
	TravelNEXTCreateTripPage travelNEXTCreateTripPage;
	
	@Autowired
	TravelNEXTCostAllocationPage travelNEXTCostAllocationPage;
	
	@Autowired
	TravelNEXTPassengerPage travelNEXTPassengerPage;
	
	/**
	 * This method will take to TravelNEXT Welcome Page
	 * 
	 * @return TravelNEXTWelcomePage
	 */
	public TravelNEXTWelcomePage getTravelNEXTWelcomePage() {
		travelNEXTWelcomePage.getPage();
		return travelNEXTWelcomePage;
	}

	/**
	 * This method will take to TravelNEXT Home Page
	 * 
	 * @return TravelNEXTHomePage
	 */
	public TravelNEXTHomePage getTravelNEXTHomePage() {
		travelNEXTHomePage.getPage();
		return travelNEXTHomePage;
	}

	/**
	 * This method will take to TravelNEXT SideBar Page
	 * 
	 * @return TravelNEXTSideBarPage
	 */
	public TravelNEXTSideBarPage getTravelNEXTSideBarPage() {
		travelNEXTSideBarPage.getPage();
		return travelNEXTSideBarPage;
	}

	/**
	 * This method will take to TravelNEXT Personal Details Page
	 * 
	 * @return TravelNEXTPersonalDetailsPage
	 */
	public TravelNEXTPersonalDetailsPage getTravelNEXTPersonalDetailsPage() {
		travelNEXTPersonalDetailsPage.getPage();
		return travelNEXTPersonalDetailsPage;
	}

	/**
	 * This method will take to TravelNEXT Passport Details Page
	 * 
	 * @return TravelNEXTPassportDetailsPage
	 */
	public TravelNEXTPassportDetailsPage getTravelNEXTPassportDetailsPage() {
		travelNEXTPassportDetailsPage.getPage();
		return travelNEXTPassportDetailsPage;
	}

	/**
	 * This method will take to TravelNEXT Emergency Contact Page
	 * 
	 * @return TravelNEXTEmergencyContactsPage
	 */
	public TravelNEXTEmergencyContactsPage getTravelNEXTEmergencyContactsPage() {
		travelNEXTEmergencyContactsPage.getPage();
		return travelNEXTEmergencyContactsPage;
	}

	/**
	 * This method will take to TravelNEXT Hotel Loyalty Programs Page
	 * 
	 * @return TravelNEXTHotelLoyaltyProgramsPage
	 */
	public TravelNEXTHotelLoyaltyProgramsPage getTravelNEXTHotelLoyaltyProgramsPage() {
		travelNEXTHotelLoyaltyProgramsPage.getPage();
		return travelNEXTHotelLoyaltyProgramsPage;
	}
	
	/**
	 * This method will take to TravelNEXT Add Hotel Loyalty Programs Page
	 * 
	 * @return TravelNEXTAddHotelLoyaltyProgramsPage
	 */
	public TravelNEXTAddHotelLoyaltyProgramsPage getTravelNEXTAddHotelLoyaltyProgramsPage() {
		travelNEXTAddHotelLoyaltyProgramsPage.getPage();
		return travelNEXTAddHotelLoyaltyProgramsPage;
	}
	
	/**
	 * This method will take to TravelNEXT View Hotel Loyalty Programs Page
	 * 
	 * @return TravelNEXTViewHotelLoyaltyProgramsPage
	 */
	public TravelNEXTViewHotelLoyaltyProgramsPage getTravelNEXTViewHotelLoyaltyProgramsPage() {
		travelNEXTViewHotelLoyaltyProgramsPage.getPage();
		return travelNEXTViewHotelLoyaltyProgramsPage;
	}
	
	/**
	 * This method will take to TravelNEXT Edit Hotel Loyalty Programs Page
	 * 
	 * @return TravelNEXTEditHotelLoyaltyProgramsPage
	 */
	public TravelNEXTEditHotelLoyaltyProgramsPage getTravelNEXTEditHotelLoyaltyProgramsPage() {
		travelNEXTEditHotelLoyaltyProgramsPage.getPage();
		return travelNEXTEditHotelLoyaltyProgramsPage;
	}

	/**
	 * This method will take to TravelNEXT Add Emergency Contacts Page
	 * 
	 * @return TravelNEXTAddEmergencyContactsPage
	 */
	public TravelNEXTAddEmergencyContactsPage getTravelNEXTAddEmergencyContactsPage() {
		travelNEXTAddEmergencyContactsPage.getPage();
		return travelNEXTAddEmergencyContactsPage;
	}

	/**
	 * This method will take to TravelNEXT Edit Emergency Contacts Page
	 * 
	 * @return TravelNEXTEditEmergencyContactsPage
	 */
	public TravelNEXTEditEmergencyContactsPage getTravelNEXTEditEmergencyContactsPage() {
		travelNEXTEditEmergencyContactsPage.getPage();
		return travelNEXTEditEmergencyContactsPage;
	}

	/**
	 * This method will take to TravelNEXT View Emergency Contacts Page
	 * 
	 * @return TravelNEXTViewEmergencyContactsPage
	 */
	public TravelNEXTViewEmergencyContactsPage getTravelNEXTViewEmergencyContactsPage() {
		travelNEXTViewEmergencyContactsPage.getPage();
		return travelNEXTViewEmergencyContactsPage;
	}

	/**
	 * This method will take to TravelNEXT Feedback Page
	 * 
	 * @return TravelNEXTFeedbackPage
	 */
	public TravelNEXTFeedbackPage getTravelNEXTFeedbackPage() {
		travelNEXTFeedbackPage.getPage();
		return travelNEXTFeedbackPage;
	}

	/**
	 * This method will take to TravelNEXT Feedback Success Page
	 * 
	 * @return TravelNEXTFeedbackSuccessPage
	 */
	public TravelNEXTFeedbackSuccessPage getTravelNEXTFeedbackSuccessPage() {
		travelNEXTFeedbackSuccessPage.getPage();
		return travelNEXTFeedbackSuccessPage;
	}

	/**
	 * This method will take to TravelNEXT About App Page
	 * 
	 * @return TravelNEXTAboutAppPage
	 */
	public TravelNEXTAboutAppPage getTravelNEXTAboutAppPage() {
		travelNEXTAboutAppPage.getPage();
		return travelNEXTAboutAppPage;
	}

	/**
	 * This method will take to TravelNEXT Travel Policy Page
	 * 
	 * @return TravelNEXTTravelPolicyPage
	 */
	public TravelNEXTTravelPolicyPage getTravelNEXTTravelPolicyPage() {
		travelNEXTTravelPolicy.getPage();
		return travelNEXTTravelPolicy;
	}

	/**
	 * This method will take to TravelNEXT Emergency Contact Details Page
	 * 
	 * @return TravelNEXTEmergencyContactDetailsPage
	 */
	public TravelNEXTEmergencyContactDetailsPage getTravelNEXTEmergencyContactDetailsPage() {
		travelNEXTEmergencyContactDetailsPage.getPage();
		return travelNEXTEmergencyContactDetailsPage;
	}

	/**
	 * This method will take to TravelNEXT Frequent Flyer Numbers Page
	 * 
	 * @return TravelNEXTFrequentFlyerNumbersPage
	 */
	public TravelNEXTFrequentFlyerNumbersPage getTravelNEXTFrequentFlyerNumbersPage() {
		travelNEXTFrequentFlyerNumbersPage.getPage();
		return travelNEXTFrequentFlyerNumbersPage;
	}

	/**
	 * This method will take to TravelNEXT Add frequent Flyer numbers Page
	 * 
	 * @return TravelNEXTAddFrequentFlyerNumbersPage
	 */
	public TravelNEXTAddFrequentFlyerNumbersPage getTravelNEXTAddFrequentFlyerNumbersPage() {
		travelNEXTAddFrequentFlyerNumbersPage.getPage();
		return travelNEXTAddFrequentFlyerNumbersPage;
	}

	/**
	 * This method will take to TravelNEXT edit frequent Flyer numbers Page
	 * 
	 * @return TravelNEXTEditFrequentFlyerNumbersPage
	 */
	public TravelNEXTEditFrequentFlyerNumbersPage getTravelNEXTEditFrequentFlyerNumbersPage() {
		travelNEXTEditFrequentFlyerNumbersPage.getPage();
		return travelNEXTEditFrequentFlyerNumbersPage;
	}

	/**
	 * This method will take to TravelNEXT View frequent Flyer numbers Page
	 * 
	 * @return TravelNEXTViewFrequentFlyerNumbersPage
	 */
	public TravelNEXTViewFrequentFlyerNumbersPage getTravelNEXTViewFrequentFlyerNumbersPage() {
		travelNEXTViewFrequentFlyerNumbersPage.getPage();
		return travelNEXTViewFrequentFlyerNumbersPage;
	}
	
	/**
	 * This method will take to Itinerary Page
	 * @return TravelNEXTItineraryPage
	 */
	public TravelNEXTItineraryPage getTravelNEXTItineraryPage()
	{
		travelNEXTItineraryPage.getPage();
		return travelNEXTItineraryPage;
	}

	/**
	 * This method will take to History Page
	 * @return TravelNEXTHistoryPage
	 */
	public TravelNEXTHistoryPage getTravelNEXTHistoryPage()
	{
		travelNEXTHistoryPage.getPage();
		return travelNEXTHistoryPage;
	}
	
	/**
	 * This method will take to Comments Page
	 * @return TravelNEXTCommentsPage
	 */
	public TravelNEXTCommentsPage getTravelNEXTCommentsPage() {
		travelNEXTCommentsPage.getPage();
		return travelNEXTCommentsPage;
	}
	
	/**
	 * This method will take to More Info Page
	 * @return TravelNEXTMoreInfoPage
	 */
	public TravelNEXTMoreInfoPage getTravelNEXTMoreInfoPage()
	{
		travelNEXTMoreInfoPage.getPage();
		return travelNEXTMoreInfoPage;
	}
	
	
	/**
	 * This method will take to create trip page
	 * @return TravelNEXTCreateTripPage
	 */
	public TravelNEXTCreateTripPage getTravelNEXTCreateTripPage()
	{
		travelNEXTCreateTripPage.getPage();
		return travelNEXTCreateTripPage;
	}
	
	/**
	 * This method will take to cost allocation page
	 * @return TravelNEXTCostAllocationPage
	 */
	public TravelNEXTCostAllocationPage getTravelNEXTCostAllocationPage()
	{
		travelNEXTCostAllocationPage.getPage();
		return travelNEXTCostAllocationPage;
	}
	
	/**
	 * This method will take to Passengers page
	 * @return TravelNEXTPassengerPage
	 */
	public TravelNEXTPassengerPage getTravelNEXTPassengerPage()
	{
		travelNEXTPassengerPage.getPage();
		return travelNEXTPassengerPage;
	}
	
}
