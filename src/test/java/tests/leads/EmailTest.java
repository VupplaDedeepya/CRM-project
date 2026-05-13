package tests.leads;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.leads.EmailPage;
import pages.userOnboarding.LoginPage;
import pages.userOnboarding.chooseWorkPlacePage;

public class EmailTest extends BaseTest{
	@Test(priority=1,description="login")
    	public   void login() throws InterruptedException {
		  LoginPage lp = new LoginPage(driver);
		  lp.login();
		  chooseWorkPlacePage cws = new chooseWorkPlacePage(driver);
		  cws.ClickNext();
	  }
	  @Test(priority=2,groups= {"sanity"})
	 public void email() throws InterruptedException {
		  login();
		  EmailPage ep = new EmailPage(driver);
		  ep.selectLead();
		  ep.click_email_tab();
		  //ep.compose_draft();  
		 // ep.compose_schedule_send();
		  ep.compose_email();
	  }
}
