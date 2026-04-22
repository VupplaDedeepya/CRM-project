package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.EmailPage;
import pages.LoginPage;
import pages.chooseWorkPlacePage;

public class EmailTest extends BaseTest{
	  @Test(priority=1)
	  void login() throws InterruptedException {
		  LoginPage lp = new LoginPage(driver);
		  lp.login();
		  chooseWorkPlacePage cws = new chooseWorkPlacePage(driver);
		  cws.ClickNext();
	  }
	  @Test(dependsOnMethods="login")
	  void email() throws InterruptedException {
		  EmailPage ep = new EmailPage(driver);
		  ep.selectLead();
		  ep.click_email_tab();
		  //ep.compose_draft();  
		 // ep.compose_schedule_send();
		  ep.compose_email();
	  }
}
