package Testcasesscenario;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminpageTest extends Baseclass{
	
	 @BeforeClass
		public void pageSetup()
		{
			System.out.println("Login Test");
			lp.dologin("Admin","admin123");
		}

  @Test(priority=1)
  public void verifyadmin() {
	  
	  ap.getmenu();
	  addwait();
  }
  
  @Test(priority=2)
  public void verifyusername() {
	  ap.searchbyUserName("Admin"); 
	  addwait();
  }
  
  @Test(priority=3)
  public void verifysearchUserrole() {
	  ap.searchByUSerRole("Admin");
	  addwait();
  }
  
  @Test(priority=4)
  public void verifysearchuserStatus() {
	  ap.searchByUserStatus("Enabled");
	  addwait();
	  
  }
  }
