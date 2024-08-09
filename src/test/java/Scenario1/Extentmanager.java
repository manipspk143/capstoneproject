package Scenario1;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentmanager 
{
public static ExtentReports extent;
	
	
	public static ExtentReports getInstance()
	{
		
		if(extent==null)
		{
			extent=createInstance();
			return extent;
		}
		else 
		{
			return extent;
		}
		
	}
	

	public static ExtentReports createInstance()
	{
		
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"Scenario1//Automation.html");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Datadriventest");
		sparkReporter.config().setDocumentTitle("Capstone Project");
	
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		return extent;
	}


}