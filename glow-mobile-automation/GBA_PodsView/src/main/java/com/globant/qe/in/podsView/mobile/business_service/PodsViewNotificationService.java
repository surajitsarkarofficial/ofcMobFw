package com.globant.qe.in.podsView.mobile.business_service;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Lazy;
	import org.springframework.stereotype.Component;

	import com.globant.qe.in.IMobileService;
	import com.globant.qe.in.podsView.mobile.provider.PodsViewPageProvider;

	@Component
	@Lazy
	public class PodsViewNotificationService implements IMobileService<PodsViewNotificationService>{


		@Autowired
		PodsViewPageProvider podsViewPageProvider;


		/**
		 * This method will load the PodsView Notification Page
		 * @return PodsViewNotificationService
		 */
		@Override
		public PodsViewNotificationService loadPage() {
			podsViewPageProvider.getPodsViewNotificationPage();
			return this;
		}
	}