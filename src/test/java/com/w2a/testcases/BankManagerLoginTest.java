package com.w2a.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;






public class BankManagerLoginTest extends TestBase {
	
	
	@Test
	public void bankManagerLoginTest() throws InterruptedException, IOException {
		
		
		verifyEquals("abc","xyz");
		Thread.sleep(3000);
		log.debug("Inside Login test");
		//driver.findElement(By.xpath(OR.getProperty("btnbnkmnglgn"))).click();
		//calling the click method from TestBase class
		click("btnbnkmnglgn_XPATH");
		//Thread.sleep(3000);
		//adding validations by using Assert
		Assert.assertTrue(isElementPresent(By.xpath((OR.getProperty("addcustbtn_XPATH")))));
		log.debug("Login successfully executed");
		//Assert.fail("Login was failed");
		
	}

}
