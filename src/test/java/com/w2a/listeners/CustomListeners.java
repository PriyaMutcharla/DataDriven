package com.w2a.listeners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener {
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult arg0) {
		// to add a link in html report
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		//calling captureScreenshot() method from TestUtil
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL, arg0.getName().toUpperCase()+" Failed with exception : "+arg0.getThrowable());//getThrowable will catch the exception
		//to add a screenshot to the extent report failure test case
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		Reporter.log("Click to see Screenshot");
		// to add a link
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">screenshot</a>");
		// to add a thumb nail
		Reporter.log("<br>");
		Reporter.log("<br>");//adding a new line
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" height=200 width=200></img></a>");
		report.endTest(test);
		report.flush();
	}

	public void onTestSkipped(ITestResult arg0) {
		test.log(LogStatus.SKIP, arg0.getName().toUpperCase()+" Skipping the test as the runmode is NO");
		report.endTest(test);
		report.flush();

	}

	public void onTestStart(ITestResult arg0) {
		//telling the test to start
		test = report.startTest(arg0.getName().toUpperCase());
	}

	public void onTestSuccess(ITestResult arg0) {
		test.log(LogStatus.PASS, arg0.getName().toUpperCase()+" PASS");
		report.endTest(test);
		report.flush();

	}

	public void onFinish(ISuite arg0) {

	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub

	}

}
