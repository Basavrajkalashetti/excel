package excel.excel;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import junit.framework.Assert;

public class etentreport {

	ExtentSparkReporter htmlReporter;

	ExtentReports reports;

	ExtentTest test;
	@BeforeTest
	public void startReport()
	{

		htmlReporter=new ExtentSparkReporter("ExtentReportDemo.html");

		reports=new ExtentReports();

		reports.attachReporter(htmlReporter);


		reports.setSystemInfo("Machine", "testpc1");

		reports.setSystemInfo("OS", "window11");

		reports.setSystemInfo("user", "prachi");

		reports.setSystemInfo("Browser", "chrome");

		htmlReporter.config().setDocumentTitle("Extent Report Demo");

		htmlReporter.config().setReportName("Test Report");

		htmlReporter.config().setTheme("Theme.STANDARD");

		htmlReporter.config().setTimeStampFormat("EEEE,MMMM dd, yyyy,hh:mm a);

	}
	@Test
	public void LaunchBrowser()
	{
		test =reports.createTest("Launch browser and open url");

		Assert.assertTrue(true);
	}
	
	@Test
	public void verifyTitle()
	{
		test =reports.createTest("verify logo");

		Assert.assertTrue(false);
	}
	
	@Test
	public void VerifyEmail()
	{
		test =reports.createTest("verify email");

		throw new SkipException("skipping this test case with exception");
	}
	@Test
	public void username()
	{
		test =reports.createTest("verify email");

		throw new SkipException("skipping this test case with exception");
	}
	@AfterMethod
	public void getTestResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getTestName()+ "FAIL", ExtentColor.RED));
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ "SUCCESS",ExtentColor.GREEN));
		}
	}
    @AfterTest
	public void teardown()
	{
		reports.flush();
	}


}
