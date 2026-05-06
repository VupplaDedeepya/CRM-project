package tests.leads;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.leads.EmailPage;
import pages.userOnboarding.LoginPage;
import pages.userOnboarding.chooseWorkPlacePage;

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
