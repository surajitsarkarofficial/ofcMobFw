package com.globant.qe.in.mobile.OSUtils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globant.qe.in.ConfigMobileParams;
import com.globant.qe.in.mobile.pagebase.AbstractMobileBasePage;

import io.appium.java_client.MobileDriver;

@SuppressWarnings("rawtypes")
@Component
public class CommonUtilities {

	@Autowired
	ConfigMobileParams config;

	private MobileDriver mobileDriver;
	@Autowired
	public CommonUtilities(AbstractMobileBasePage abstractMobileBasePage){
		this.mobileDriver = abstractMobileBasePage.getMobileDriver();
	}
	/**
	 * This method will capture the Screenshot
	 * @param fileName
	 * @return String
	 * @throws IOException
	 */
	public String captureScreenshot(String fileName) throws IOException
	{
		File src = ((TakesScreenshot)mobileDriver).getScreenshotAs(OutputType.FILE);
		File dest = new File(config.getScreenshotspath()+"/"+fileName+".png");
		String screenShotPath = dest.getAbsolutePath();
		FileUtils.copyFile(src, dest);
		return screenShotPath;

	}
	/**
	 * This method will return the current date and time based on specified format
	 * @param format
	 * @return String
	 */
	public static String getCurrentDateAndTime(String format)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(format);  
		Date date = new Date();  
		String formattedDate=formatter.format(date);  
		return formattedDate;
	}
	/***
	 * This method will convert milis to hh mm ss ms
	 * @param millis
	 * @return String
	 */
	public static String  convertMiliSecondsToHourMinSecMilliSec(long millis){
	    String hms = String.format("%02dh:%02dm:%02ds:%02dms", TimeUnit.MILLISECONDS.toHours(millis),
	            TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
	            TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)),
	            TimeUnit.MILLISECONDS.toMillis(millis) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(millis)));
	    return hms;
	}
	/**
	 * This method will resize the image based on percentage
	 * @param inputImagePath
	 * @param outputImagePath
	 * @param percent
	 * @throws IOException
	 */
	public static void resize(String inputImagePath,
            String outputImagePath, double percent) throws IOException
	{
		File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
        int scaledWidth = (int) (inputImage.getWidth() * percent);
        int scaledHeight = (int) (inputImage.getHeight() * percent);
        resize(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
	}
	/**
	 * This method will resize the image based on height and width
	 * @param inputImagePath
	 * @param outputImagePath
	 * @param scaledWidth
	 * @param scaledHeight
	 * @throws IOException
	 */
	public static void resize(String inputImagePath,
            String outputImagePath, int scaledWidth, int scaledHeight) throws IOException
	{
		// reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
 
        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());
 
        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
 
        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);
 
        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
	}
	/**
	 * This method will return random String of specified character length
	 * @param stringLength
	 * @return String
	 */
	public String gererateRandomString(int stringLength) {
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    Random random = new Random();
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(stringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	 
	    return generatedString;
	}
	
	/**
	 * This method will generate random loyalty number with given limit
	 * 
	 * @param length
	 * @return String
	 */
	public static String generateRandomNumber(int length) {

		int m = (int) Math.pow(10, length - 1);
		int x = m + new Random().nextInt(9 * m);

		String randomNumber = String.valueOf(x);

		return randomNumber;
	}

	
	/**
	 * This method will return a random PhoneNumber
	 * @return String
	 */
	public static String generateRandomPhoneNumber()
	{
		Random rand = new Random();
        int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

        String phoneNumber = df3.format(num1) +df3.format(num2)+ df4.format(num3);
        return phoneNumber;
	}
}
