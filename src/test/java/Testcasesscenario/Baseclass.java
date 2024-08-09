package Testcasesscenario;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Scenario2.Adminpage;
import Scenario2.Loginpage;

public class Baseclass {
public WebDriver driver;
  public Loginpage lp;
  public Adminpage ap;
  
  @BeforeTest
  public void Browsersetup() {
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	 
	  lp=new Loginpage(driver);
	 ap=new Adminpage(driver);
	  
  }
  
 		
	
	  public static void addwait(){
		  try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
	  }
	  
	  @AfterClass
		public void teardown() {
			driver.quit();
		}

  }
  
  
  

