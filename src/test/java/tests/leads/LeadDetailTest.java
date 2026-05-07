package tests.leads;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.leads.newPage;
import pages.userOnboarding.LoginPage;
import pages.userOnboarding.chooseWorkPlacePage;

public class LeadDetailTest extends BaseTest{
	@Test(priority=1)
	public void login() throws InterruptedException {
		 LoginPage lp = new LoginPage(driver);
		 lp.login();
		 System.out.println("login successful");
		 
		chooseWorkPlacePage cwp = new chooseWorkPlacePage(driver);
	    cwp.ClickNext(); 
	    System.out.println("successfully choosed workspace");
	}
	@Test(priority=2,dependsOnMethods = "login")
	public void edit_profile_info() throws InterruptedException {
		/*LeadDetailPage ldp = new LeadDetailPage(driver);
		ldp.selectLead();
		ldp.profile_info();
	    ldp.Company_Info();
	  	ldp.Lead_Info();*/
		newPage ldp = new newPage(driver);
		ldp.selectLead();
		ldp.profile_info();
	    ldp.Company_Info();
	  	ldp.Lead_Info();
		
	}
}
