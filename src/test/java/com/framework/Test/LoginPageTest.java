package com.framework.Test;

import java.io.IOException;
import java.util.Set;

import org.testng.annotations.Test;

import com.framework.commonfunctions.CommonOperations;
import com.framework.utilities.PropertyFileUtil;

public class LoginPageTest extends CommonOperations  {
	
	@Test(priority = 2)
	public static void LoginPageFieldsAvailablityTest() throws IOException {
		log.debug("Checking Login Page Fields");
		Set<String> keys =  PropertyFileUtil.getAllPropertyValues();
		for(String s : keys) {
			if(CommonOperations.checkForAvailabilityOfElement(s)) {
				System.out.println("Element " +s+ " is available" );
			} else {
				System.out.println("Element " +s+ " is not available");
			}
		}
	
	}
	

}
