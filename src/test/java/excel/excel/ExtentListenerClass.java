package excel.excel;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentListenerClass implements ITestListener {
	

	
ExtentSparkReporter htmlReporter;	

ExtentReports reports;

ExtentTest test;

public void configureReport()
{
	htmlReporter = new ExtentSparkReporter("ExtentListenerReportDemo.html");
	reports=new ExtentReports();
	reports.attachReporter(htmlReporter);
}
	

	
	public void onStart(ITestContext Result)
	
	{
		System.out.println("On start method invoked....");
		
	}
	
	public void onFinish(ITestContext Result)
	{
		System.out.println("On Finished method invoked....");
	}
	
	public void onTestFailure(ITestResult Result)
	{		
		System.out.println("name of test method failed :"+ Result.getName());
		
		test=reports.createTest(Result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName(),ExtentColor.BLUE));
    }
     
	public void onTestStart(ITestResult Result)
	{
		System.out.println("name of test method Started :"+ Result.getName());
	}
	
	public void onTestSuccesss(ITestResult Result)
	{
		System.out.println("name of test method Success :"+ Result.getName());
	}
	
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println("name of test method skipped :"+ Result.getName());
		
		test= reports.createTest(Result.getName());
		
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped test case is: " +Result.getName(), ExtentColor.GREEN));
	}
	
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
	{
			
		
	}



	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
		
	}


	
	

}
