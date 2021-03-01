package com.globant.qe.in.podsView.mobile.business_service;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Lazy;
	import org.springframework.stereotype.Component;

	import com.globant.qe.in.IMobileService;
import com.globant.qe.in.podsView.mobile.pages.PodsViewLoginPage;
import com.globant.qe.in.podsView.mobile.provider.PodsViewPageProvider;

	@Component
	@Lazy
	public class PodsViewLoginService implements IMobileService<PodsViewLoginService>{

		@Autowired
		PodsViewPageProvider podsViewPageProvider;

		private static PodsViewLoginPage loginPage;
		
		/**
		 * This method will load the PodsView Login Page
		 * @return PodsViewService
		 */
		@Override
		public PodsViewLoginService loadPage() {
			loginPage = podsViewPageProvider.getPodsViewLoginPage();
			return this;
		}

		/**
		 * This method will tap on Sign In button
		 * @return GlobantPodsLoginService
		 */
		public PodsViewLoginService signIn() {
			loginPage.signIn();
			return this;

		}
		
	
}
