package com.globant.qe.in;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

@Component
@Order(1)
@PropertySource({"classpath:applicationMobile.properties","classpath:application-Android.properties","classpath:application-iOS.properties"})
public class ConfigMobileParams {
	
	AppiumDriver<MobileElement> mobileDriver=null;

	@Value("${file.path}")
	private String filePath;

	@Value("${max.wait.time}")
	private int maxWaitTime;
	
	@Value("${min.wait.time}")
	private int minWaitTime;
	
	@Value("${session.timeout}")
	private int sessionTimeout;

	@Value("${screenshot.on.failure}")
	private boolean screenshotOnFailure;

	
	@Value("${mobile.buildPath}")
	private String mobileBuildpath;
	
	@Value("${mobile.seleniumUrl:http://127.0.0.1:4723/wd/hub}")
	private String mobileSeleniumURL;
	
	@Value("${mobile.platformName:iOS}")
	private String mobilePlatformName;
	
	@Value("${mobile.platformVersion:12.4}")
	private String mobilePlatformVersion;
	
	@Value("${mobile.deviceName:'iPhone X'}")
	private String mobileDeviceName;
	
	@Value("${mobile.isFullReset:false}")
	private boolean mobileIsFullReset;
	
	@Value("${mobile.isNoReset:false}")
	private boolean mobileIsNoReset;
	
	@Value("${mobile.startAppiumServer:false}")
	private boolean mobileStartAppiumServer;
	
	@Value("${mobile.udid}")
	private String mobileUdid;
	
	@Value("${mobile.app}")
	private String mobileApp;
	
	@Value("${mobile.appActivity}")
	private String mobileAppActivity;
	
	@Value("${reports.path:./Reports}")
	private String reportsPath;
	
	@Value("${screenshots.path:./Screenshots}")
	private String screenshotsPath;
	
	@Value("${mobile.execution.env:qa}")
	private String executionEnv;
	
	@Value("${spring.profiles.active}")
	private String activeProfile;
	
	@Value("${workprofile.userid}")
	private String workProfileId;
	
	public String getWorkProfileId() {
		return workProfileId;
	}
	
	@PostConstruct
    public void init(){
        //System.out.println("bean a is called");
       
    }
	
	public String getMobileBuildpath() {
		return mobileBuildpath;
	}

	public String getMobileSeleniumURL() {
		return mobileSeleniumURL;
	}

	public String getMobilePlatformName() {
		return mobilePlatformName;
	}

	public String getMobilePlatformVersion() {
		return mobilePlatformVersion;
	}

	public String getMobileDeviceName() {
		return mobileDeviceName;
	}

	public boolean isMobileIsFullReset() {
		return mobileIsFullReset;
	}

	public boolean isMobileStartAppiumServer() {
		return mobileStartAppiumServer;
	}

	
	public String getMobileUdid() {
		return mobileUdid;
	}

	public String getMobileApp() {
		return mobileApp;
	}

	public String getMobileAppActivity() {
		return mobileAppActivity;
	}

	public boolean isMobileIsNoReset() {
		return mobileIsNoReset;
	}

	public String getFilePath() {
		return filePath;
	}

	public int getMaxWaitTime() {
		return maxWaitTime;
	}
	public int getMinWaitTime() {
		return minWaitTime;
	}
	public int getSessionTimeout() {
		return sessionTimeout;
	}

	public boolean isScreenshotOnFailure() {
		return screenshotOnFailure;
	}
	public String getReportspath() {
		return reportsPath;
	}
	public String getScreenshotspath() {
		return screenshotsPath;
	}
	
	public String getEnvironment()
	{
		return executionEnv;
	}
	public String getExecutionPlatform() {
		return activeProfile;
	}

}
