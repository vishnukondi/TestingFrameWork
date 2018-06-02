package com.framework.commonfunctions;



import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.utilities.PropertyFileUtil;

public class CommonOperations extends PropertyFileUtil {
	
	
static WebDriver driver;

@BeforeTest
public static WebDriver openBrowser() throws IOException {
	log.debug("Opening Browser");
	if(PropertyFileUtil.getConfigValue("Browser").equalsIgnoreCase("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\TestingFrameWork\\TestingFrameWork\\Drivers\\chromedriver.exe");
		driver =  new ChromeDriver();
		driver.manage().window().maximize();
	} else {
		System.out.println("Please set the Chrome Browser as Default Testing Browser ");
	}
	return driver;
	
}

@Test(priority = 1)
public static void openApplication() throws IOException {
	log.debug("Opening Application");
	driver.get(PropertyFileUtil.getConfigValue("URL"));
}


public static void typeAction(String locatorValue, String testData) throws IOException {
	
	driver.findElement(By.xpath(PropertyFileUtil.getPropertyValue(locatorValue))).sendKeys(testData);
	
}

public static boolean checkForAvailabilityOfElement(String locatorValue) throws IOException {
	
	boolean available = false;
	try {
	if(driver.findElement(By.xpath(PropertyFileUtil.getPropertyValue(locatorValue))).isDisplayed()) {
		available = true;
	} 
	} catch(InvalidSelectorException e) {
		System.out.println("It is not an Element Key");
	}
	
	catch(NoSuchElementException e) {
		System.out.println("Please re-check the Element locator : " +locatorValue);
		captureScreenShot(driver);
	}
	return available;
}

public static void waitForElement(String locatorValue) throws IOException {
	
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PropertyFileUtil.getPropertyValue(locatorValue))));
}

public static void captureScreenShot(WebDriver driver) throws IOException {
	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("D:/Testing/TestingFrameWork/TestingFrameWork/CapturedScreenShots/" +new Date().getTime()+".PNG"));
}


}
