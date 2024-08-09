package Scenario1;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreportdemo{ //extends Datadriventest {
  @Test
  public void testreport() {
	  
	  ExtentReports extent=new ExtentReports();
	  
	  //path
	  
	  ExtentSparkReporter spark=new ExtentSparkReporter(System.getProperty("user.dir")+"//Scenario1//Automation.html");
	  
	  //sparkcofig
	  
	  spark.config().setDocumentTitle("Capstone Project Automation Test");
	  spark.config().setReportName("DataDrivenTest");
	  //spark.config().setReportName("Manikanta Konkipudi");
	  spark.config().setTheme(Theme.DARK);
	  
	  //attachment
	  extent.attachReporter(spark);
	  
	  //create test case
	 ExtentTest test= extent.createTest("testcase");
	 
	  
	  //logs
	  
//	test.log(Status.PASS, "Test 1 is pass");
//	
//	test.log(Status.FAIL, "Test 2 is pass");
//	test.log(Status.SKIP, "Test 3 is pass");
//	test.log(Status.INFO, "Test 4 is pass");
//	
	//flush
	extent.flush();
	
	
	
	
	
	
	
	
	
	
	
  }
}
