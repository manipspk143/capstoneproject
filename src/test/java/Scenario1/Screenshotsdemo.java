package Scenario1;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Screenshotsdemo {
	

  @Test
  public static void capture(WebDriver driver,String filename)  {
	  //driver=new ChromeDriver();
	 // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  //driver.get("https:www.amazon.com");
	  
	  TakesScreenshot ts=(TakesScreenshot)driver;
	  
	  File temp=ts.getScreenshotAs(OutputType.FILE);
	  
	  File dest=new File(System.getProperty("user.dir")+"//Screenshots"+filename+System.currentTimeMillis()+".png");
	  
	  try {
		FileHandler.copy(temp, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  System.out.println();
  }
}
