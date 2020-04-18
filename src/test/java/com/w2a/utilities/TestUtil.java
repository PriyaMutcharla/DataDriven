package com.w2a.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.w2a.base.TestBase;

public class TestUtil extends TestBase {

	public static String screenshotPath;
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {

		// capturing screenshot
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		// to copy this file to particular location
		FileUtils.copyFile(scrfile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));
	}

	// creating a common data provider
	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {

		String sheetName = m.getName();
		System.out.println(sheetName);
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows - 1][1];
		//creating table for each row
		Hashtable<String,String> table = null;

		for (int rownum = 2; rownum <= rows; rownum++) {
			table = new Hashtable<String,String>();
			for (int colnum = 0; colnum < cols; colnum++) {

				table.put(excel.getCellData(sheetName, colnum, 1),excel.getCellData(sheetName, colnum, rownum));
				data[rownum - 2][0] = table;
			}

		}
//		if(data[1]!=null) {System.out.println(data[1]);
//			
//		}
		return data;

	}

	// creating method for test runner

	public static boolean isTestRunnable(String testName, ExcelReader excel) {

		String sheetName = "test_suite";
		int rows = excel.getRowCount(sheetName);
		for (int rnum = 2; rnum <= rows; rnum++) {
			String testCase = excel.getCellData(sheetName, "TCID", rnum);
			if (testCase.equalsIgnoreCase(testName)) {

				String runmode = excel.getCellData(sheetName, "runmode", rnum);
				if (runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;

			}
		}
		return false;

	}

}
