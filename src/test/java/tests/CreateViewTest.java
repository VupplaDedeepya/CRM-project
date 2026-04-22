package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.chooseWorkPlacePage;

public class CreateViewTest extends BaseTest{
	@Test(priority=1)
	  void login() throws InterruptedException {
			 LoginPage lp = new LoginPage(driver);
			 lp.login();
			 System.out.println("login successful");
			 
			chooseWorkPlacePage cwp = new chooseWorkPlacePage(driver);
		    cwp.ClickNext(); 
		    System.out.println("successfully choosed workspace");
	  }
  @Test (priority=2 , dependsOnMethods = "login",enabled=true)
  void create_view() throws InterruptedException {
	  HomePage hp = new HomePage(driver);
	  hp.create_view();
	 // hp.Handle_AddView("meghana's vew");
	  //Thread.sleep(5000);
  }
  @Test(priority=3, enabled=false)
  void editView() throws InterruptedException{
	  HomePage hp = new HomePage(driver);
	  hp.edit_view();
  }
  
}
