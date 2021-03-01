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
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

@Component
@Profile({"iOS","default"})
public class IOSAppLauncher implements IAppLauncherInterface {

	@Autowired
	ConfigMobileParams configParams;

	AppiumDriver<MobileElement> mobileDriver;
	
	@Override
	public AppiumDriver<MobileElement> initiateDriver() {

		if(mobileDriver == null) {
			String seleniumUrl = configParams.getMobileSeleniumURL() != null && !configParams.getMobileSeleniumURL().equals("") ? configParams.getMobileSeleniumURL() + "/wd/hub" : "http://127.0.0.1:4723/wd/hub";

			DesiredCapabilities dcIOS = new DesiredCapabilities();
			dcIOS.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
			dcIOS.setCapability(MobileCapabilityType.PLATFORM_VERSION, configParams.getMobilePlatformVersion());
			dcIOS.setCapability(MobileCapabilityType.DEVICE_NAME, configParams.getMobileDeviceName());
			dcIOS.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "" + configParams.getSessionTimeout());
			dcIOS.setCapability("bundleId", configParams.getMobileApp());

			if (!configParams.getMobileBuildpath().equals("") && !configParams.getMobileBuildpath().equals(null)) {
				dcIOS.setCapability(MobileCapabilityType.APP, configParams.getMobileBuildpath());
			}
			dcIOS.setCapability(MobileCapabilityType.UDID,configParams.getMobileUdid());
			dcIOS.setCapability("xcodeSigningId", "iPhone Developer");
			dcIOS.setCapability("automationName", "XCUITest");
			dcIOS.setCapability("showXcodeLog", true);
			dcIOS.setCapability("newCommandTimeout", 600);
			dcIOS.setCapability(MobileCapabilityType.FULL_RESET, configParams.isMobileIsFullReset());
			if( !configParams.isMobileIsFullReset() ){
				dcIOS.setCapability(MobileCapabilityType.NO_RESET, false);
			}

			try {
				mobileDriver=new IOSDriver<>(new URL(seleniumUrl),dcIOS);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return mobileDriver;
	}

	

}
