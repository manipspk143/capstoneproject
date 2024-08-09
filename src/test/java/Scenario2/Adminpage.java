package Scenario2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Adminpage {
private WebDriver driver
;
//initialization
public Adminpage(WebDriver driver) {
	this.driver=driver;
}

//locators
private By menu=By.xpath("//li[@ class='oxd-main-menu-item-wrapper']");////ul[@class='oxd-main-menu']//li[@xpath='1']
private By uname=By.xpath("(//input[contains(@class,'oxd-input')])[2]");
private By searchbtn=By.xpath("//button[@type='submit']");
private By recordingmsg=By.xpath("//span[@class='oxd-text oxd-text--span']");
private By userrole=By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]");
private By userROptions=By.xpath("//div[@role='listbox']//div[@role='option']");
private By statustext=By.xpath("//div[@role='option']//span");
private By status=By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]");

//private By Status=By.xpath("//div[contains(text(),'-- Select --')]");//div[@role='option']//span[@xpath='1']     ////div[contains(text(),'-- Select --')]or //div[contains(@role,'option')][2]

//methods
public void getmenu() {
	List<WebElement>list=driver.findElements(menu);//div[contains(@role,'option')]) [1]////div[@class='oxd-select-dropdown --positon-bottom']//span[@xpath=1]
	System.out.println("Total elements is:"+list.size());
	for(WebElement i:list)
	{
		System.out.println(i.getText());
		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		if(i.getText().contains("Admin"))
		{
			i.click();
			break;
		}
	}
}
	
	
	public void searchbyUserName(String un) {
	
		System.out.println("search by Employee username");
		
		driver.findElement(uname).sendKeys(un);
		driver.findElement(searchbtn).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String text=driver.findElement(recordingmsg).getText();
		System.out.println(text);
		
		driver.navigate().refresh();
	}
	
public void searchByUSerRole(String name) {                                                   
	System.out.println("search by Employee UserRole");
	driver.findElement(userrole).click();
	
	List<WebElement>list2=driver.findElements(userROptions);
	//System.out.println("List of elements:" +list2.size());
	
	for(WebElement i:list2) {
		System.out.println(i.getText());
	
	if(i.getText().contains(name)){
	i.click();
		break;
	}
	}
	driver.findElement(searchbtn).click();
	
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	String text=driver.findElement(recordingmsg).getText();
	System.out.println(text);
	
	driver.navigate().refresh();
}

public void searchByUserStatus(String stat) {
	
	System.out.println("Search Employee by Status");

	driver.findElement(status).click();
	List<WebElement> list=driver.findElements(statustext);
	for(WebElement i:list)
	{
		if(i.getText().contains(stat))
		{
			i.click();
			break;
		}
	}
	
	driver.findElement(searchbtn).click();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(driver.findElement(recordingmsg).getText());
	
	
	
	////////////
//	System.out.println("search by user Status");
//	driver.findElement(status).click();
//	
//	List<WebElement>list3=driver.findElements(status);
//	System.out.println("The total users are:" +list3.size());
//	
//	for(WebElement i:list3) {
//		System.out.println(i.getText());
//		
//		if(i.getText().contains(stat)) {
//			i.click();
//			break;
//		}
//	}
//	driver.findElement(searchbtn).click();
//	
//	String text=driver.findElement(recordingmsg).getText();
//	System.out.println(text);
//	
	
}

}
