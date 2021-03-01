package com.globant.qe.in.podsView.mobile.business_service;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Lazy;
	import org.springframework.stereotype.Component;

	import com.globant.qe.in.IMobileService;
	import com.globant.qe.in.podsView.mobile.provider.PodsViewPageProvider;

	@Component
	@Lazy
	public class PodsViewContactService implements IMobileService<PodsViewContactService>{


		@Autowired
		PodsViewPageProvider podsViewPageProvider;


		/**
		 * This method will load the PodsView Contacts Page
		 * @return PodsViewContactService
		 */
		@Override
		public PodsViewContactService loadPage() {
			podsViewPageProvider.getPodsViewContactPage();
			return this;
		}
		
		/**
		 * This method will tap on Back button
		 * @return PodsViewContactService
		 */
		public PodsViewContactService tapBackButton() {
			podsViewPageProvider.getPodsViewContactPage().tapOnBackButton();
			return this;
		}
		
		
		/**
		 * This method will tap on Home button
		 * @return PodsViewContactService
		 */
		public PodsViewContactService tapOnHome() {
			podsViewPageProvider.getPodsViewContactPage().tapOnHome();
			return this;
		}
		
		
		/**
		 * This method will tap on Search button
		 * @return PodsViewContactService
		 */
		public PodsViewContactService tapOnSearchIcon() {
			podsViewPageProvider.getPodsViewContactPage().tapOnSearchIcon();
			return this;
		}
		
		/**
		 * This method will tap on Contact
		 * @return PodsViewContactService
		 */
		public PodsViewContactService tapOnContact() {
			podsViewPageProvider.getPodsViewContactPage().tapOnContact();
			return this;
		}
	}