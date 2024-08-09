package Scenario2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Loginpage {

	private WebDriver driver;
	
	//initialization
	public Loginpage(WebDriver driver){
		this.driver=driver;
	}
	
	//locators
  private By username=By.name("username");
  private By password=By.name("password");
  private By btn=By.xpath("//button[@type='submit']");
  
  //methods
 public String geturl() {
	Assert.assertTrue(driver.getCurrentUrl().contains("demo"),"Test fail:The url should not be matched");
			System.out.println("Test Pass:The url should be matched" + driver.getCurrentUrl());
			return driver.getCurrentUrl();
 }
	
 public String gettitle() {
	 Assert.assertTrue(driver.getTitle().contains("HRM"),"Test fail:The title should not be matched");
	 System.out.println("Test Pass:The title should be matched" + driver.getTitle());
	 return driver.getTitle();
 }
 
	 public void dologin(String un,String pwd){
		 driver.findElement(username).sendKeys(un);
		 driver.findElement(password).sendKeys(pwd);
		 driver.findElement(btn).click();
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"),"Loginfail:");
	System.out.println("Loginpass");
	 
	 
	 }
	 
 }
	
	
	
	

