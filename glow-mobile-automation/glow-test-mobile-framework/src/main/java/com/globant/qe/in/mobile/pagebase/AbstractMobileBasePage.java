package com.globant.qe.in.mobile.pagebase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.globant.qe.in.ConfigMobileParams;
import com.globant.qe.in.mobile.OSUtils.CommonUtilities;
import com.globant.qe.in.mobile.OSUtils.WaitHandlers;
import com.globant.qe.in.mobile.applauncher.IAppLauncherInterface;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractMobileBasePage {

	protected AppiumDriver<MobileElement> mobileDriver;

	protected WebDriverWait wait;

	public int timeOut;
	IAppLauncherInterface iAppLauncherInterface;

	static ExtentReports extent;

	public static long startTime;

	public static ExtentTest suiteLogger, testLogger, classLogger, methodLogger;;

	public static String executionEnv;
	public static String executionPlatform;

	@Autowired

	public WaitHandlers waitHandler;

	@Autowired
	ConfigMobileParams configMobileParams;

	@Autowired
	public AbstractMobileBasePage(IAppLauncherInterface iAppLauncherInterface, ConfigMobileParams configMobileParams) {
		startTime = new Date().getTime();
		executionEnv = configMobileParams.getEnvironment().toUpperCase();
		executionPlatform = configMobileParams.getExecutionPlatform();
		this.iAppLauncherInterface = iAppLauncherInterface;
		this.configMobileParams = configMobileParams;
		String reportName = "Report_TravelNext_" + executionPlatform + "_" + executionEnv + "_"
				+ CommonUtilities.getCurrentDateAndTime("ddMMMyy_hh_mm") + ".html";
		extent = initiateReport(reportName);

		mobileDriver = iAppLauncherInterface.initiateDriver();
		timeOut = configMobileParams.getMinWaitTime();
		wait = new WebDriverWait(mobileDriver, timeOut);
		PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
	}

	@Autowired
	public AppiumDriver<MobileElement> getMobileDriver() {
		return mobileDriver;
	}

	@Autowired
	public static ExtentReports getReporter() {
		return extent;
	}

	@Autowired
	public long getExecutionStartTime() {
		return startTime;
	}

	@Autowired
	public String getExecutionEnvironment() {
		return executionEnv;
	}

	@Autowired
	public String getExecutionProfile() {
		return executionPlatform;
	}

	@Autowired
	public static ExtentTest getLogger() {

		if (methodLogger == null) {
			if (classLogger == null) {
				if (testLogger == null) {
					return suiteLogger;
				} else {
					return testLogger;
				}

			} else {
				return classLogger;
			}

		} else {
			return methodLogger;
		}

	}

	@Autowired
	public static void setMethodLogger(ExtentTest test) {
		methodLogger = test;
	}

	@Autowired
	public static void setClassLogger(ExtentTest test) {
		classLogger = test;
	}

	@Autowired
	public static void setTestLogger(ExtentTest test) {
		testLogger = test;
	}

	@Autowired
	public static void setSuiteLogger(ExtentTest test) {
		suiteLogger = test;
	}

	@Autowired
	public static ExtentTest getMethodLogger() {
		return methodLogger;
	}

	@Autowired
	public static ExtentTest getClassLogger() {
		return classLogger;
	}

	@Autowired
	public static ExtentTest getTestLogger() {
		return testLogger;
	}

	@Autowired
	public static ExtentTest getSuiteLogger() {
		return suiteLogger;
	}

	private ExtentReports initiateReport(String reportName) {
		if (extent == null) {
			ExtentHtmlReporter html = new ExtentHtmlReporter(configMobileParams.getReportspath() + "/" + reportName);
			extent = new ExtentReports();
			extent.attachReporter(html);
			extent.setSystemInfo("Platform", executionPlatform);
			extent.setSystemInfo("Environment", configMobileParams.getEnvironment().toUpperCase());
			extent.setSystemInfo("Platform Version", configMobileParams.getMobilePlatformVersion());
			extent.setSystemInfo("Device name ", configMobileParams.getMobileDeviceName());
			extent.setSystemInfo("UDID ", configMobileParams.getMobileUdid());

			html.config().setDocumentTitle("iOS - TravelNEXT Automation");
			html.config().setReportName("iOS - TravelNEXT Automation Report");
			html.config().enableTimeline(false);
			html.config().setTheme(Theme.DARK);

		}
		return extent;

	}

	/**
	 * This method will enter the specified text.
	 * 
	 * @param element
	 * @param text
	 * @param clear
	 * @param elementName
	 * @param pageName
	 */
	public void enterText(MobileElement element, String text, boolean clear, String elementName, String pageName) {
		waitHandler.waitForElementToBeEnabled(element, elementName, pageName, timeOut);
		try {
			tap(element, elementName, pageName);
			if (clear) {
				element.clear();

			}
			element.sendKeys(text);
			AbstractMobileBasePage.getLogger().log(Status.INFO, String
					.format("Successfully entered '%s' text on '%s' element of '%s'", text, elementName, pageName));
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("Unable to enter text on '%s' element of '%s'", elementName, pageName));
			throw e;
		}
	}

	/**
	 * This method will click on the element
	 * 
	 * @param element
	 * @param elementName
	 * @param pageName
	 */
	public void tap(MobileElement element, String elementName, String pageName) {
		waitHandler.WaitForElementToBeVissible(element, elementName, pageName, timeOut);
		waitHandler.WaitForElementToBeClickable(element, elementName, pageName, timeOut);
		try {
			element.click();
			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("Successfully tapped on '%s' element of '%s'", elementName, pageName));
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("Unable to tap on '%s' element of '%s'", elementName, pageName));
			throw e;
		}
	}

	/**
	 * this method will long press on mobile element
	 * 
	 * @param element
	 * @param elementName
	 * @param pageName
	 */
	@SuppressWarnings("rawtypes")
	public void longPress(MobileElement element, String elementName, String pageName) {
		waitHandler.WaitForElementToBeVissible(element, elementName, pageName, timeOut);
		waitHandler.WaitForElementToBeClickable(element, elementName, pageName, timeOut);
		try {
			new TouchAction(mobileDriver).longPress(element(element)).waitAction(waitOptions(ofSeconds(2))).release()
					.perform();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * This method will fetch the text of the specified element
	 * 
	 * @param element
	 * @param elementName
	 * @param pageName
	 * @return
	 */
	public String getElementText(MobileElement element, String elementName, String pageName) {
		waitHandler.WaitForElementToBeVissible(element, elementName, pageName, timeOut);
		try {
			String text = element.getText();
			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("Successfully fetched the text of '%s' element on '%s'", elementName, pageName));
			return text;

		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("Unable to fetch the text of '%s' element on '%s'", elementName, pageName));
			throw e;
		}
	}

	/**
	 * This method will return the text present in the text field.
	 * 
	 * @param element
	 * @param elementName
	 * @param pageName
	 * @return
	 */
	public String getTextFromTextBox(MobileElement element, String elementName, String pageName) {
		waitHandler.WaitForElementToBeVissible(element, elementName, pageName, timeOut);
		try {
			String text = element.getAttribute("value");
			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("Successfully fetched the text from textbox - '%s' on '%s'", elementName, pageName));
			return text;
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("Unable to fetch the text from textbox - '%s' on '%s'", elementName, pageName));
			throw e;
		}
	}

	/**
	 * This method will return whether the element is enabled.
	 * 
	 * @param element
	 * @param elementName
	 * @param pageName
	 * @return
	 */
	public boolean isElementEnabled(MobileElement element, String elementName, String pageName) {
		try {
			boolean isEnabled = element.isEnabled();
			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("'%s' element on '%s' is enabled.", elementName, pageName));
			return isEnabled;
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("'%s' element on '%s' is not enabled.", elementName, pageName));
			return false;
		}
	}

	/**
	 * This method will return whether the element is displayed
	 * 
	 * @param element
	 * @param elementName
	 * @param pageName
	 * @return
	 */
	public boolean isElementDisplayed(MobileElement element, String elementName, String pageName) {
		try {
			boolean isDisplayed = element.isDisplayed();
			if (isDisplayed) {
				AbstractMobileBasePage.getLogger().log(Status.INFO,
						String.format("'%s' element is displayed on '%s'", elementName, pageName));
			} else {
				AbstractMobileBasePage.getLogger().log(Status.INFO,
						String.format("'%s' element is not displayed on '%s'", elementName, pageName));
			}
			return isDisplayed;
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("'%s' element is not displayed on '%s'", elementName, pageName));
			return false;
		}
	}

	/**
	 * This method will return whether the element is selected.
	 * 
	 * @param element
	 * @param elementName
	 * @param pageName
	 * @return
	 */
	public boolean isElementSelected(MobileElement element, String elementName, String pageName) {
		try {

			boolean isSelected = element.isSelected();
			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("'%s' element on '%s' is selected.", elementName, pageName));
			return isSelected;
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("'%s' element on '%s' is not selected.", elementName, pageName));
			return false;
		}
	}

	/**
	 * This method will return whether the element is disappeared.
	 * 
	 * @param element
	 * @param elementName
	 * @param pageName
	 * @param timeOut
	 * @return
	 */
	public boolean isElementDisappeared(MobileElement element, String elementName, String pageName, int timeOut) {
		boolean flag = true;
		try {
			waitHandler.WaitForElementToDisappear(element, elementName, pageName, timeOut);
			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("'%s' element on '%s' is not visible.", elementName, pageName));
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * This method will return the value of the specified attribute
	 * 
	 * @param element
	 * @param elementName
	 * @param pageName
	 * @param attributeName
	 * @return
	 */
	public String getAttributeValue(MobileElement element, String elementName, String pageName, String attributeName) {
		try {
			waitHandler.WaitForElementToBeVissible(element, elementName, pageName, timeOut);
			String value = element.getAttribute(attributeName);
			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("Value for attribute '%s' of '%s' element on '%s' is fetched succesfully.",
							attributeName, elementName, pageName));
			return value;
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("Unable to fetch Value for attribute '%s' of '%s' element on '%s'.", attributeName,
							elementName, pageName));
			throw e;
		}
	}

	/**
	 * 
	 * Swipe by elements
	 * 
	 **/
	@SuppressWarnings("rawtypes")
	public void swipeByElements(MobileElement startElement, MobileElement endElements) {
		int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
		int startY = startElement.getLocation().getY() + (startElement.getSize().getWidth() / 2);

		int endX = endElements.getLocation().getX() + (endElements.getSize().getWidth() / 2);
		int endy = endElements.getLocation().getY() + (endElements.getSize().getWidth() / 2);

		new TouchAction(mobileDriver).press(point(startX, startY)).waitAction(waitOptions(ofMillis(1000)))
				.moveTo(point(endX, endy)).release().perform();
	}

	/**
	 * Horizontal Swipe by percentages
	 */
	@SuppressWarnings("rawtypes")
	public void swipeHorizontalByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
		Dimension size = mobileDriver.manage().window().getSize();
		int anchor = (int) (size.height * anchorPercentage);
		int startPoint = (int) (size.width * startPercentage);
		int endPoint = (int) (size.width * endPercentage);

		new TouchAction(mobileDriver).press(point(startPoint, anchor)).waitAction(waitOptions(ofMillis(1000)))
				.moveTo(point(endPoint, anchor)).release().perform();
	}

	/**
	 * Vertical Swipe by percentages
	 */
	@SuppressWarnings("rawtypes")
	public void swipeVerticalByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
		Dimension size = mobileDriver.manage().window().getSize();
		int anchor = (int) (size.width * anchorPercentage);
		int startPoint = (int) (size.height * startPercentage);
		int endPoint = (int) (size.height * endPercentage);

		new TouchAction(mobileDriver).press(point(startPoint, anchor)).waitAction(waitOptions(ofMillis(1000)))
				.moveTo(point(endPoint, anchor)).release().perform();
	}

	/**
	 * Tap to an element for 250 milliseconds
	 **/
	@SuppressWarnings("rawtypes")
	public void tapByElement(MobileElement mobileElement, String elementName, String pageName) {
		try {
		waitHandler.WaitForElementToBeClickable(mobileElement, elementName, pageName, timeOut);
		new TouchAction(mobileDriver).tap(tapOptions().withTapsCount(1).withElement(element(mobileElement)))
				.waitAction(waitOptions(Duration.ofMillis(250))).perform();
		} 
		catch (Exception e) {
		AbstractMobileBasePage.getLogger().log(Status.INFO,
				String.format("'%s' element on '%s' is not clickable.", elementName, pageName));
		throw e;
		}	
	}

	/**
	 * Multitouch action by using an android element
	 **/
	@SuppressWarnings("rawtypes")
	public void multiTouchByElement(MobileElement mobileElement) {
		TouchAction press = new TouchAction(mobileDriver).press(element(mobileElement))
				.waitAction(waitOptions(ofSeconds(1))).release();

		new MultiTouchAction(mobileDriver).add(press).perform();
	}

	/**
	 * Tap by coordinates
	 **/
	@SuppressWarnings("rawtypes")
	public void tapByCoordinates(int x, int y) {
		new TouchAction(mobileDriver).tap(point(x, y)).waitAction(waitOptions(Duration.ofMillis(250))).perform();
	}

	/**
	 * Press by element
	 **/
	@SuppressWarnings("rawtypes")
	public void pressByElement(MobileElement mobileElement, long seconds) {
		new TouchAction(mobileDriver).press(element(mobileElement)).waitAction(waitOptions(ofSeconds(seconds)))
				.release().perform();
	}

	/**
	 * Press by coordinates
	 **/
	@SuppressWarnings("rawtypes")
	public void pressByCoordinates(int x, int y, long seconds) {
		new TouchAction(mobileDriver).press(point(x, y)).waitAction(waitOptions(ofSeconds(seconds))).release()
				.perform();
	}

	/**
	 * slide by percentage On Ios slider values can be string representations of
	 * numbers between 0 and 1 WebElement slider =
	 * driver.findElement(By.xpath("//window[1]/slider[1]")); e.g., "0.1" is 10%,
	 * "1.0" is 100%
	 **/
	public void sliderInIos(MobileElement mobileElement, String percentage) {
		mobileElement.sendKeys(percentage);
	}

	/**
	 * This method will handle the alert
	 * 
	 * @param alertName
	 * @param pageName
	 * @param isAccept
	 * @param timeOutInSeconds
	 */
	public void handleAlertWithText(String alertText, String pageName, boolean isAccept, int timeOutInSeconds) {
		Alert alert = null;
		try {
			alert = waitHandler.waitForAlertWithText(alertText, pageName, timeOutInSeconds);
			if (isAccept) {
				alert.accept();
				AbstractMobileBasePage.getLogger().log(Status.INFO,
						String.format("Alert with text '%s' was found and accepted on '%s'.", alertText, pageName));
			} else {
				alert.dismiss();
				AbstractMobileBasePage.getLogger().log(Status.INFO,
						String.format("Alert with text '%s' was found and dismissed on '%s'.", alertText, pageName));
			}

		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.INFO,
					String.format("No alert was present on '%s'.", pageName));

		}

	}

	/**
	 * This method will Scroll up or down based on parameter
	 * 
	 * @param direction - Up , Down
	 */
	@SuppressWarnings("rawtypes")
	public void scroll(String direction) {
		Dimension size = mobileDriver.manage().window().getSize();
		int anchor = (int) (size.width * 0.5);
		int startPoint;
		int endPoint;

		if (direction.toUpperCase().equals("UP")) {
			startPoint = (int) (size.height * 0.5);
			endPoint = (int) (size.height * 0.1);

		} else {
			startPoint = (int) (size.height * 0.4);
			endPoint = (int) (size.height * 0.8);
		}
		new TouchAction(mobileDriver).press(PointOption.point(anchor, startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(anchor, endPoint)).release().perform();
	}

	/**
	 * This method will return if the expected toast message is displayed.
	 * 
	 * @param message
	 * @return
	 */
	public boolean isToastMessageDisplayed(String message) {
		boolean isDisplayed = false;
		int count = 0;
		do {
			if (mobileDriver.getPageSource().contains(message)) {
				isDisplayed = true;
				break;
			}
			waitHandler.waitForTimeToLapse(50);
			count++;

		} while (count < 30);
		return isDisplayed;
	}

	@SuppressWarnings("rawtypes")
	public void slide() {

		Dimension size = mobileDriver.manage().window().getSize();
		int anchor = (int) (size.height /2);
		int startPoint;
		int endPoint;
		startPoint = (int) (size.width * 0.7);
		endPoint = (int) (size.width * 0.2);
		new TouchAction(mobileDriver).press(point(startPoint, anchor)).waitAction(waitOptions(ofMillis(1000)))
		.moveTo(point(endPoint, anchor)).perform();
	}


}
