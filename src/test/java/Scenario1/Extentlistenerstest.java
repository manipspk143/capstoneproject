package Scenario1;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import Scenario1.Datadriventest;

public class Extentlistenerstest extends Datadriventest implements ITestListener {
	
	
ExtentReports extent=Extentmanager.getInstance();
	
	ThreadLocal<ExtentTest> parentTest=new ThreadLocal<ExtentTest>();
	
  @Test
  public void onTestStart(ITestResult result) 
	{
		ExtentTest extentTest=extent.createTest(result.getMethod().getMethodName());
	
		parentTest.set(extentTest);
	}
		  
  public void onTestSuccess(ITestResult result) {
	   
		
		
		parentTest.get().pass("Test Passed");
		String pass=result.getName();
		//captureScreenshot(result.getTestClass().getRealClass().getSimpleName()+"_"+pass+"_"+timestamp()+".png");
	  }
	
	  
  private String timestamp()
	{
		return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	}

  public void onTestFailure(ITestResult result) 
	{
		
		
		AssertJUnit.fail("Test Failed "+result.getThrowable().getMessage());
		String fail=result.getName();
		//captureScreenshot(result.getTestClass().getRealClass().getSimpleName()+"_"+fail+"_"+timestamp()+".png");

		
	   
	  }
	
	
	public void onTestSkipped(ITestResult result) {
		parentTest.get().skip("Test Skipped "+result.getThrowable().getMessage());
	   
	  }
	
	
	public  void onFinish(ITestContext context) {
		extent.flush();
	    
	  }

	


}
	  
  

