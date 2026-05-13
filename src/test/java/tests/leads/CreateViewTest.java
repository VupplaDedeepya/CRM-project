package tests.leads;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.leads.HomePage;
import pages.userOnboarding.LoginPage;
import pages.userOnboarding.chooseWorkPlacePage;

public class CreateViewTest extends BaseTest{
	@Test(priority=1,description="login")
	 public void login() throws InterruptedException {
			 LoginPage lp = new LoginPage(driver);
			 lp.login();
			 System.out.println("login successful");
			 
			chooseWorkPlacePage cwp = new chooseWorkPlacePage(driver);
		    cwp.ClickNext(); 
		    System.out.println("successfully choosed workspace");
	  }
  @Test (priority=2,enabled=true,groups= {"sanity"})
  public void create_view() throws InterruptedException {
	  HomePage hp = new HomePage(driver);
	  hp.create_view();
	
  }
  @Test(priority=3, enabled=false)
  public void editView() throws InterruptedException{
	  HomePage hp = new HomePage(driver);
	  hp.delete_view();
  }
  
}
