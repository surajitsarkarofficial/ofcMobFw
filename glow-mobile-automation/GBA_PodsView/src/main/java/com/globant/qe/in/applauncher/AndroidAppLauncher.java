package com.globant.qe.in.applauncher;

import java.net.MalformedURLException;
	import java.net.URL;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Profile;
	import org.springframework.stereotype.Component;
	import com.globant.qe.in.ConfigMobileParams;
	import com.globant.qe.in.mobile.applauncher.IAppLauncherInterface;

	import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.MobileElement;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.remote.MobileCapabilityType;
	import io.appium.java_client.remote.MobilePlatform;

	@Component
	@Profile("Android")
	public class AndroidAppLauncher  implements IAppLauncherInterface {

		@Autowired
		ConfigMobileParams configParams;	
		
		AppiumDriver<MobileElement> mobileDriver;
		
		@Override
		public AppiumDriver<MobileElement> initiateDriver() {
			if(mobileDriver ==null) {
			String seleniumUrl = configParams.getMobileSeleniumURL() != null && !configParams.getMobileSeleniumURL().equals("") ? configParams.getMobileSeleniumURL() + "/wd/hub" : "http://127.0.0.1:4723/wd/hub";
			DesiredCapabilities dcAndroid = new DesiredCapabilities();
	        dcAndroid.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	        dcAndroid.setCapability(MobileCapabilityType.PLATFORM_VERSION, configParams.getMobilePlatformVersion());
	        dcAndroid.setCapability(MobileCapabilityType.DEVICE_NAME, configParams.getMobileDeviceName());
	        dcAndroid.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, configParams.getSessionTimeout());
	        if (!configParams.getMobileBuildpath().equals("") && !configParams.getMobileBuildpath().equals(null)) {
	            dcAndroid.setCapability(MobileCapabilityType.APP, configParams.getMobileBuildpath());
	        }
	        
	        dcAndroid.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
	        dcAndroid.setCapability("appPackage", configParams.getMobileApp());
	        dcAndroid.setCapability("appActivity", configParams.getMobileAppActivity());
	        dcAndroid.setCapability(MobileCapabilityType.NO_RESET, configParams.isMobileIsNoReset());
	        dcAndroid.setCapability(MobileCapabilityType.FULL_RESET, configParams.isMobileIsFullReset());
	        String workProfileUserId = configParams.getWorkProfileId();
	        if(!workProfileUserId.equals("")) {
	        dcAndroid.setCapability("optionalIntentArguments", "--user "+workProfileUserId);
	        }
	        
	        try {
	        	mobileDriver=new AndroidDriver<>(new URL(seleniumUrl),dcAndroid);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			}
	        
		return mobileDriver;
	}
		

	

}
