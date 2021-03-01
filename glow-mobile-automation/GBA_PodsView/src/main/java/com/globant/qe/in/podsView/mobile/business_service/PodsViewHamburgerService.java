package com.globant.qe.in.podsView.mobile.business_service;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Lazy;
	import org.springframework.stereotype.Component;

	import com.globant.qe.in.IMobileService;
	import com.globant.qe.in.podsView.mobile.provider.PodsViewPageProvider;

	@Component
	@Lazy
	public class PodsViewHamburgerService implements IMobileService<PodsViewHamburgerService>{


		@Autowired
		PodsViewPageProvider podsViewPageProvider;


		/**
		 * This method will load the PodsView Hamburger Menu 
		 * @return GlobantPodsHamburgerService
		 */
		@Override
		public PodsViewHamburgerService loadPage() {
			podsViewPageProvider.getPodsViewHamburger();
			return this;
		}
		
		
		/**
		 * This method will tap on LogOut button
		 * @return GlobantPodsHamburgerService
		 */
		public PodsViewHamburgerService tapLogOut() {
			podsViewPageProvider.getPodsViewHamburger().tapLogOut();
			return this;
		}
	}