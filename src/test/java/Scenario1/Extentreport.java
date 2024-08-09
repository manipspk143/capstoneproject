package Scenario1;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreport {
	WebDriver driver;
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
		driver.quit();
	}
}




