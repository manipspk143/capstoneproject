package Scenario1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
//import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Datadriventest {
	public class Extentreport {
		public  WebDriver driver;
	    
		ExtentSparkReporter htmlreporter;
		ExtentReports reports;
		ExtentTest test;

		@BeforeTest
		public void StartReport() {
			htmlreporter = new ExtentSparkReporter("OrangeHrmExtentProjectReport.html");
			reports = new ExtentReports();
			reports.attachReporter(htmlreporter);
			test = reports.createTest("ExtentTest");

			// Environmen deatails if required

			reports.setSystemInfo("user", "Mani");
			reports.setSystemInfo("Browser", "Chrome");
			reports.setSystemInfo("OS", "Window 10+");

			// // //conf.to change theame & feel //
			htmlreporter.config().setDocumentTitle("Capstone Project Automation Test"); //
			htmlreporter.config().setReportName("DataDrivenTest"); //
			htmlreporter.config().setTheme(Theme.DARK); //
		}


		@AfterMethod
		public void extendReport(ITestResult result) {
			if (result.getStatus() == ITestResult.SUCCESS) {
				test.log(Status.PASS, "TestCase Pass Sucessfully");

			} else {
				test.log(Status.FAIL, "TestCase get Fail");
				
				
			}
		}
		
		

		@AfterClass
		public void tearDown() {
			reports.flush();
			Excelutility.capture(driver);
		    
			driver.quit();
		}

	
	
	//public static WebDriver driver;
     @Test(dataProvider="Exceldata",dataProviderClass=Excelutility.class)
	  public void testcase(String username,String password) throws IOException {
		  driver= new ChromeDriver();
		 	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys(username);
		addwait();
			driver.findElement(By.name("password")).sendKeys(password);
		    driver.findElement(By.xpath("//button[@type='submit']")).click();
		    addwait();
		    
		    try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		   //screenshot
		    //Excelutility.capture(driver);
		    //assertion
		    Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"Login fail");
		    System.out.println("Login completed"); 
  
		    }
//     @AfterClass
     public void teardown() {
    	 driver.quit();
     }
     
     public  void addwait() {
 		try {
 			Thread.sleep(1000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 	}

 	
//  public void captureScreenshot(Object fileName)
//	{
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File src=ts.getScreenshotAs(OutputType.FILE);
//		File dest=new File(System.getProperty("user.dir")+"//Screenshots//"+fileName);
//		try {
//			FileHandler.copy(src, dest);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("ScreenShot captured!");
//	}
//  
}}

   

