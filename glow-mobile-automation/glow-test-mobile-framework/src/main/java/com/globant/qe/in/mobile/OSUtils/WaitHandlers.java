package com.globant.qe.in.mobile.OSUtils;

import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.aventstack.extentreports.Status;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.ExpectedCondition;
@SuppressWarnings("rawtypes")
@Component
public class WaitHandlers {

	private MobileDriver mobileDriver;
	@Autowired
	public WaitHandlers(AbstractMobileBasePage abstractMobileBasePage){
		this.mobileDriver = abstractMobileBasePage.getMobileDriver();
	}
	
	@Autowired
	AbstractMobileBasePage abstractMobileBasePage;
	/**
	 * This method will wait for the visibility of the specified element.
	 * @param element
	 * @param elementName
	 * @param pageName
	 * @param timeOutInSeconds
	 */
	public void WaitForElementToBeVissible(MobileElement element, String elementName, String pageName, int timeOutInSeconds)
	{
		try {
			WebDriverWait wait = new WebDriverWait(mobileDriver, timeOutInSeconds) ;
			wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e)
		{
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' element of '%s' was not vissible even after %d seconds",elementName,pageName,timeOutInSeconds));
			throw e;
		}
	}
	
	
	/**
	 * This method will wait for the specified element to be present.
	 * 
	 * @param element
	 * @param elementName
	 * @param pageName
	 * @param timeOutInSeconds
	 */
	public void WaitForElementToBePresent(By element, String elementName, String pageName, int timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(mobileDriver, timeOutInSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
		} catch (Exception e) {
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' element of '%s' was not present even after %d seconds",
					elementName, pageName, timeOutInSeconds));
			throw e;
		}
	}
	
	/**
	 * This method will wait for either of the element to be vissible
	 * @param element1
	 * @param element2
	 * @param elementName1
	 * @param elementName2
	 * @param pageName
	 * @param timeOutInSeconds
	 */
	public void WaitForEitherElementToBeVissible(MobileElement element1,MobileElement element2,String elementName1, String elementName2, String pageName, int timeOutInSeconds)
	{
		WebDriverWait wait =new WebDriverWait(mobileDriver, timeOutInSeconds);
		try {
			 wait.until(ExpectedConditions.visibilityOf(element1));
		}catch(Exception e)
		{
			try {
			wait.until(ExpectedConditions.visibilityOf(element2));
			}catch(Exception e1)
			{
				AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' element and '%s' element of '%s' was not vissible even after %d seconds",elementName1,elementName2,pageName,timeOutInSeconds));
				throw e;
			}
		}
	}
	/**
	 * This method will wait for Text to be present in the element
	 * @param element
	 * @param expectedText
	 * @param elementName
	 * @param pageName
	 * @param timeOutInSeconds
	 */
	public void waitForTextToBePresent(MobileElement element, String expectedText, String elementName, String pageName, int timeOutInSeconds)
	{
		try {
			WebDriverWait wait = new WebDriverWait(mobileDriver, timeOutInSeconds) ;
			wait.until(ExpectedConditions.textToBePresentInElement(element,expectedText));
		}catch(Exception e)
		{
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' text was not present in '%s' element of '%s' even after %d seconds",expectedText,elementName,pageName,timeOutInSeconds));
			throw e;
		}
	}
	/**
	 * This method will wait for the text to be present in the element value.
	 * @param element
	 * @param expectedText
	 * @param elementName
	 * @param pageName
	 * @param timeOutInSeconds
	 */
	public void waitForTextToBePresentInValue(MobileElement element, String expectedText, String elementName, String pageName, int timeOutInSeconds)
	{
		try {
			WebDriverWait wait = new WebDriverWait(mobileDriver, timeOutInSeconds) ;
			wait.until(ExpectedConditions.textToBePresentInElementValue(element,expectedText));
		}catch(Exception e)
		{
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' text was not present in value for '%s' element of '%s' even after %d seconds",expectedText,elementName,pageName,timeOutInSeconds));
			throw e;
		}
	}
	/**
	 * This method will for element to disappear.
	 * @param element
	 * @param elementName
	 * @param pageName
	 * @param timeOutInSeconds
	 */
	public void WaitForElementToDisappear(MobileElement element, String elementName, String pageName, int timeOutInSeconds)
	{
		boolean isElementDispalyed = true;
		long startTime = new Date().getTime();
		long currentTime;
		
		do {
			 currentTime = new Date().getTime();
				try {
				isElementDispalyed=element.isDisplayed();
				}catch(Exception e)
				{
					isElementDispalyed=false;
				}
				if(isElementDispalyed)
				{
					waitForTimeToLapse(200);
				}
				
			
		}while(isElementDispalyed &&((currentTime-startTime)/1000 <=timeOutInSeconds));
		
	}
	/**
	 * This method wiat for time to lapse
	 * @param millis
	 */
	public void waitForTimeToLapse(long millis)
	{
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method will wait for element to be clickable
	 * @param element
	 * @param elementName
	 * @param pageName
	 * @param timeOutInSeconds
	 */
	public void WaitForElementToBeClickable(MobileElement element, String elementName, String pageName, int timeOutInSeconds)
	{
		try {
			WebDriverWait wait = new WebDriverWait(mobileDriver, timeOutInSeconds) ;
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Exception e)
		{
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' element of '%s' was not clickable even after %d seconds",elementName,pageName,timeOutInSeconds));
			throw e;
		}
	}
	/**
	 * This method will wait for element to be selected
	 * @param element
	 * @param elementName
	 * @param pageName
	 * @param timeOutInSeconds
	 */
	public void WaitForElementToBeSelected(MobileElement element, String elementName, String pageName, int timeOutInSeconds)
	{
		try {
			WebDriverWait wait = new WebDriverWait(mobileDriver, timeOutInSeconds) ;
			wait.until(ExpectedConditions.elementToBeSelected(element));
		}catch(Exception e)
		{
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' element of '%s' was not selected even after %d seconds",elementName,pageName,timeOutInSeconds));
			throw e;
		}
	}
	/**
	 * This method will wait for specified Page title 
	 * @param title
	 * @param pageName
	 * @param timeOutInSeconds
	 */
	public void WaitForPageTitle(String title, String pageName, int timeOutInSeconds)
	{
		try {
			WebDriverWait wait = new WebDriverWait(mobileDriver, timeOutInSeconds) ;
			wait.until(ExpectedConditions.titleIs(title));
		}catch(Exception e)
		{
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("The title of the '%s' was equal to '%s' even after %d seconds",pageName,title,timeOutInSeconds));
			throw e;
		}
	}
	/**
	 * This method will wait for Page title to contain specified text
	 * @param title
	 * @param pageName
	 * @param timeOutInSeconds
	 */
	public void WaitForPageTitleToContain(String title, String pageName, int timeOutInSeconds)
	{
		try {
			WebDriverWait wait = new WebDriverWait(mobileDriver, timeOutInSeconds) ;
			wait.until(ExpectedConditions.titleContains(title));
		}catch(Exception e)
		{
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("The title of the '%s' does not contains '%s' even after %d seconds",pageName,title,timeOutInSeconds));
			throw e;
		}
	}
	/**
	 * This method will wait for Alert to be present
	 * @param pageName
	 * @param timeOutInSeconds
	 */
	public void waitForAlert(String alertName,String pageName, int timeOutInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(mobileDriver, timeOutInSeconds) ;
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * This method will wait for alert with specified text
	 * @param alertText
	 * @param pageName
	 * @param timeOutInSeconds
	 * @return Alert
	 * @throws InterruptedException
	 */
	public Alert waitForAlertWithText(String alertText,String pageName, int timeOutInSeconds) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(mobileDriver, timeOutInSeconds) ;
		Alert alert=null;
		wait.until(ExpectedConditions.alertIsPresent());
		alert=mobileDriver.switchTo().alert();
		if(alert.getText().contains(alertText))			
		{
			return alert;
		}else {
			alert=mobileDriver.switchTo().alert();
			if(alert.getText().contains(alertText))			
			{
				return alert;
			}else {
				AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("The alert with text '%s' was not found on '%s' even after %d seconds",alertText,pageName,timeOutInSeconds));
				throw new NoAlertPresentException();
			}
		}		
		
	}
	/**
	 * Expected Condition to check if element is enabled.
	 * @param element
	 * @return
	 */
	private ExpectedCondition<Boolean> elementToBeEnabled(MobileElement element) {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return element.isDisplayed();
			}
		};
	}
	/**
	 * This method will wait for element to be enabled.
	 * @param element
	 * @param elementName
	 * @param pageName
	 * @param timeOutInSeconds
	 */
	public void waitForElementToBeEnabled(MobileElement element, String elementName, String pageName, int timeOutInSeconds)
	{
		try {
			WebDriverWait wait = new WebDriverWait(mobileDriver, timeOutInSeconds) ;
			wait.until(elementToBeEnabled(element));
		}catch(Exception e)
		{
			AbstractMobileBasePage.getLogger().log(Status.INFO, String.format("'%s' element of '%s' was not enabled even after %d seconds",elementName,pageName,timeOutInSeconds));
			throw e;
		}
	}
	
	/**
	 * This method will wait for Toast Message to disappear
	 * @param toastMessage
	 * @param timeOutInSeconds
	 */
	public void WaitForToastMessageToDisappear(String toastMessage, int timeOutInSeconds)
	{
		boolean isElementDispalyed = true;
		long startTime = new Date().getTime();
		long currentTime;
		
		do {
			 currentTime = new Date().getTime();
				try {
				isElementDispalyed=abstractMobileBasePage.isToastMessageDisplayed(toastMessage);
				}catch(Exception e)
				{
					isElementDispalyed=false;
				}
				if(isElementDispalyed)
				{
					waitForTimeToLapse(200);
				}
				
			
		}while(isElementDispalyed &&((currentTime-startTime)/1000 <=timeOutInSeconds));
		
	}

}


