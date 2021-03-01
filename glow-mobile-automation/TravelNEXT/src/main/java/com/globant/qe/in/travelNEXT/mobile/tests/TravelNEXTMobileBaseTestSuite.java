package com.globant.qe.in.travelNEXT.mobile.tests;

import java.io.File; 
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.globant.qe.in.ConfigMobileParams;
import com.globant.qe.in.TestRunner;
import com.globant.qe.in.mobile.OSUtils.CommonUtilities;
import com.globant.qe.in.mobile.OSUtils.WaitHandlers;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTHomeService;
import com.globant.qe.in.travelNEXT.mobile.business_service.TravelNEXTWelcomeService;
import com.globant.qe.in.travelNEXT.mobile.listeners.MobilePDFReportGenerator;
import com.globant.qe.in.travelNEXT.mobile.pages.TravelNEXTWelcomePage;
import com.globant.qe.in.travelNEXT.mobile.provider.TravelNEXTServiceProvider;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Image;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

@SpringBootTest(classes = TestRunner.class)
@Listeners({ MobilePDFReportGenerator.class })
public class TravelNEXTMobileBaseTestSuite extends AbstractTestNGSpringContextTests {

	@Autowired
	protected ConfigMobileParams configMobileParams;

	@Autowired
	TravelNEXTServiceProvider mobileServiceProvider;

	@Autowired
	TravelNEXTWelcomeService travelNextWelcomeService;

	@Autowired
	TravelNEXTWelcomePage travelNextWelcomePage;

	@Autowired
	TravelNEXTHomeService travelNextHomeService;

	@Autowired
	protected WaitHandlers waitHandler;

	public static AppiumDriver<MobileElement> mobileDriver;

	ExtentReports extent;
	
	@Autowired
	protected CommonUtilities utils;

	protected SoftAssert softAssert = new SoftAssert();

	public static String executionEnvironment;

	public static String exePlatform;

	public static List<HashMap<String, Object>> failedTestScreenShotPaths = new LinkedList<HashMap<String, Object>>();

	@BeforeSuite
	public void springTestContextPrepareTestInstance(ITestContext context) throws Exception {
		super.springTestContextPrepareTestInstance();
		extent = AbstractMobileBasePage.getReporter();
		String suiteName = context.getSuite().getName();
		AbstractMobileBasePage.setSuiteLogger(extent.createTest(suiteName));
		executionEnvironment = AbstractMobileBasePage.executionEnv;
		exePlatform = AbstractMobileBasePage.executionPlatform;
		mobileDriver = travelNextWelcomePage.getMobileDriver();
		AbstractMobileBasePage.getLogger().log(Status.INFO, "Before Suite started.");
		try {

			travelNextWelcomeService = mobileServiceProvider.getTravelNEXTWelcomeService().loadPage();
			travelNextWelcomeService.selectGoogleSignInButton();

			AbstractMobileBasePage.getLogger().log(Status.INFO, "Google SignIn Successful.");
		} catch (Exception e) {
			if (mobileDriver instanceof AndroidDriver) {
				mobileDriver.terminateApp(configMobileParams.getMobileAppActivity());
				AbstractMobileBasePage.getLogger().log(Status.INFO, "App Terminated.");
				mobileDriver.launchApp();
				AbstractMobileBasePage.getLogger().log(Status.INFO, "App Launched.");
			} else {
				mobileDriver.terminateApp(configMobileParams.getMobileApp());
				AbstractMobileBasePage.getLogger().log(Status.INFO, "App Terminated.");
				mobileDriver.launchApp();
				AbstractMobileBasePage.getLogger().log(Status.INFO, "App Launched.");
			}
			try {
				travelNextHomeService = mobileServiceProvider.getTravelNEXTHomeService().loadPage();
				AbstractMobileBasePage.getLogger().log(Status.INFO, "Google SignIn Successful.");

			} catch (Exception e1) {
				travelNextWelcomeService = mobileServiceProvider.getTravelNEXTWelcomeService().loadPage();
				travelNextWelcomeService.selectGoogleSignInButton();
				AbstractMobileBasePage.getLogger().log(Status.INFO, "Google SignIn Successful.");
			}
		}
		AbstractMobileBasePage.getLogger().log(Status.INFO, "Before Suite completed.");
	}

	@BeforeTest
	public void beforeTest(ITestContext context) {
		String testName = context.getName();
		ExtentTest test = AbstractMobileBasePage.getSuiteLogger().createNode(testName);
		AbstractMobileBasePage.setTestLogger(test);

	}

	@AfterTest
	public void afterTest() {
		AbstractMobileBasePage.setTestLogger(null);
	}

	@BeforeClass
	public void beforeClass(ITestContext context) {
		String[] className = this.getClass().getName().split("\\.");
		int len = className.length;
		String testName = className[len - 1];
		ExtentTest test = AbstractMobileBasePage.getTestLogger().createNode(testName);
		AbstractMobileBasePage.setClassLogger(test);
	}

	@AfterClass
	public void afterClass() {
		AbstractMobileBasePage.setClassLogger(null);
	}

	@BeforeMethod
	public void launchTravelNextApp(Method method) throws Exception {
		ExtentTest test = AbstractMobileBasePage.getClassLogger().createNode(method.getName());
		AbstractMobileBasePage.setMethodLogger(test);
		try {
			travelNextHomeService = mobileServiceProvider.getTravelNEXTHomeService().loadPage();
		} catch (Exception e) {
			if (mobileDriver instanceof AndroidDriver) {
				mobileDriver.terminateApp(configMobileParams.getMobileAppActivity());
				AbstractMobileBasePage.getLogger().log(Status.INFO, "App Terminated.");
				mobileDriver.launchApp();
				AbstractMobileBasePage.getLogger().log(Status.INFO, "App Launched.");
			} else {
				mobileDriver.terminateApp(configMobileParams.getMobileApp());
				AbstractMobileBasePage.getLogger().log(Status.INFO, "App Terminated.");
				mobileDriver.launchApp();
				AbstractMobileBasePage.getLogger().log(Status.INFO, "App Launched.");
			}
			try {
				travelNextHomeService = mobileServiceProvider.getTravelNEXTHomeService().loadPage();
				AbstractMobileBasePage.getLogger().log(Status.INFO, "Google SignIn Successful.");

			} catch (Exception e1) {
				travelNextWelcomeService = mobileServiceProvider.getTravelNEXTWelcomeService().loadPage();
				travelNextWelcomeService.selectGoogleSignInButton();
				AbstractMobileBasePage.getLogger().log(Status.INFO, "Google SignIn Successful.");
			}
		}

		AbstractMobileBasePage.getLogger().log(Status.INFO, "Before Method completed.");

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) throws IOException {
		AbstractMobileBasePage.getLogger().log(Status.INFO, "After Method started.");
		if (result.getStatus() == ITestResult.FAILURE) {
			String fileName = result.getName() + "_" + CommonUtilities.getCurrentDateAndTime("ddMMyyhhmmss");
			AbstractMobileBasePage.getLogger().fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(utils.captureScreenshot(fileName)).build());
			prepareFailedScreenshotList(result, fileName);
		} else if (result.getStatus() == ITestResult.SKIP)
			AbstractMobileBasePage.getLogger().skip(result.getThrowable());
		else
			AbstractMobileBasePage.getLogger().pass(result.getName() + " Test passed");

		AbstractMobileBasePage.getLogger().log(Status.INFO, "After Method completed.");
		AbstractMobileBasePage.setMethodLogger(null);
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		extent.setSystemInfo("Total Execution Time ", getTotalExecutionTime());
		extent.flush();
	}

	public String getTotalExecutionTime() {
		long startTime = travelNextWelcomePage.getExecutionStartTime();
		long endTime = new Date().getTime();
		long millis = endTime - startTime;
		String hms = String.format("%02dh:%02dm:%02ds", TimeUnit.MILLISECONDS.toHours(millis),
				TimeUnit.MILLISECONDS.toMinutes(millis)
						- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
				TimeUnit.MILLISECONDS.toSeconds(millis)
						- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
		return hms;
	}

	public void prepareFailedScreenshotList(ITestResult result, String fileName) {
		HashMap<String, Object> testDetails = new HashMap<>();
		testDetails.put("TestName", result.getTestContext().getName());

		Image image = null;
		String[] cPaths = result.getTestClass().getName().toString().split("\\.");
		int len = cPaths.length;
		String className = cPaths[len - 1];
		testDetails.put("ClassName", className);
		testDetails.put("MethodName", result.getMethod().getMethodName());
		testDetails.put("Image", image);
		File screenshot;
		try {
			screenshot = ((TakesScreenshot) mobileDriver).getScreenshotAs(OutputType.FILE);
		} catch (Exception e) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			screenshot = ((TakesScreenshot) mobileDriver).getScreenshotAs(OutputType.FILE);
		}
		String fName = "Screenshots/" + result.getName() + "_" + CommonUtilities.getCurrentDateAndTime("ddMMyyhhmmss")
				+ ".png";

		try {
			FileUtils.copyFile(screenshot, new File(fName));
			CommonUtilities.resize(fName, fName, 0.4);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			image = Image.getInstance(fName);
		} catch (BadElementException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		testDetails.put("Image", image);

		failedTestScreenShotPaths.add(testDetails);
	}
}
