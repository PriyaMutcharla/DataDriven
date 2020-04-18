package com.w2a.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class AddCustomerTest extends TestBase {
	
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void addCustomerTest(Hashtable<String,String>data) throws InterruptedException{
		//driver.findElement(By.xpath(OR.getProperty("addcustbtn"))).click();
		//calling click method from TestBase class
		
		if(!data.get("runmode").equals("Y")) {
			throw new SkipException("Skipping the test as the runmode is NO");
			
		}
		click("addcustbtn_XPATH");
		/*driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys(firstName);
		driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys(lastName);
		driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys(postCode);
	   driver.findElement(By.xpath(OR.getProperty("addbtn_XPATH"))).click();
	   */
	    //calling type method
	    type("firstname_XPATH",data.get("firstName"));
	    type("lastname_XPATH",data.get("lastName"));
	    type("postcode_XPATH",data.get("postCode"));
	    click("addbtn_XPATH");
	    Thread.sleep(3000);
		
		//handling alerts
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
		//Thread.sleep(3000);
		alert.accept();
		Thread.sleep(3000);
		//Assert.fail("Adding customer was failed");
		
	}
	/*@DataProvider(added a common data provider method in TestUtil class
	public Object[][] getData(){
			
		String sheetName="AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows-1][cols];
		
		for(int rownum = 2; rownum<=rows;rownum++) {
			for(int colnum=0;colnum<cols;colnum++) {
				
				data[rownum -2][colnum]=excel.getCellData(sheetName, colnum, rownum);
			}
		}
		return data;
		
		
	}*/

}
