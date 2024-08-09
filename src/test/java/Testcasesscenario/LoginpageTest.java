package Testcasesscenario;

import org.testng.annotations.Test;

public class LoginpageTest extends Baseclass{
  @Test(priority=1)
  public void verifyurl() {
	  lp.geturl();
	  addwait();
	  }
  @Test(priority=2)
  public void gettitle() {
	  lp.gettitle();
	  addwait();
  }
  @Test(priority=3)
  public void validatelogin() {
	  lp.dologin("Admin","admin123");
	  addwait();
  }
}
