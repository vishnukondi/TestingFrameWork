package com.framework.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.commonfunctions.CommonOperations;
import com.framework.utilities.ExcelFileUtil;
import com.framework.utilities.PropertyFileUtil;

public class LoginPageTest extends CommonOperations  {
	
	//@Test
	public static void LoginPageFieldsAvailablityTest() throws IOException {
		log.debug("Checking Login Page Fields");
		Set<String> keys =  PropertyFileUtil.getAllPropertyValues();
		for(String s : keys) {
			if(checkForAvailabilityOfElements(s)) {
				System.out.println("Element " +s+ " is available" );
			} else {
				System.out.println("Element " +s+ " is not available");
			}
		}
	
	}
	
	@Test(dataProvider="getLoginTestData")
	public static void LoginTest(String Username, String Password) throws IOException {
		log.debug("Logging into Amazon");
		clickAction("Account");
		typeAction("Email", Username);
		clickAction("continue");
		typeAction("Pass", Password);
		clickAction("Submit");
	}
	
	@Test(dataProvider="getLoginPageValidationTestData", dependsOnMethods="LoginTest")
	public static void loginPageValidation(String customername) throws IOException {
		String customerName = getElementText("customerName");
		assertEquals(customername, customerName);
		
	}
	
	public static void LogoutTest() {
		
	}
	
	@DataProvider
	public static Object[][] getLoginTestData(){
		Object data[][] = ExcelFileUtil.getData("AmazonLoginTest");
		return data;
	}
	
	@DataProvider
	public static Object[][] getLoginPageValidationTestData(){
		Object data[][] = ExcelFileUtil.getData("CustomerLoginValidation");
		return data;
	}
	

}
