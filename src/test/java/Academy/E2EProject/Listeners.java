package Academy.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resorces.Base;
import resorces.ExtentReportsNG;

public class Listeners extends Base implements ITestListener {
	ExtentTest test;
	ExtentReports extent=ExtentReportsNG.getReportObject();
	ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//if we run parallely then on test start ,one test will craete test object then another test will override this object as they are running parallelly
		//For that we will create one thread local object which will store all the extent test objects
		test=extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extenttest.get().log(Status.PASS,"Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extenttest.get().fail(result.getThrowable());//this will attach all the failure logs
		WebDriver driver =null;
		String getmethodname=result.getMethod().getMethodName();
		try {
			//this statement is for getting instance of the present driver
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
		{
			
		}
		try {
			//this takescreenshot will take screenshot in the reports folder ,then we will have testcasename.png
			//but now we want the screenshot inextent reports failure part
			//we already have logs when the test is failed,now we want scrrenhot also
			String screenshotpath=takescreenshot(getmethodname,driver);
			extenttest.get().addScreenCaptureFromPath(screenshotpath, getmethodname);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
