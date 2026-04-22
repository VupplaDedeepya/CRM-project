package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ActivitiesPage;
import pages.LoginPage;
import pages.chooseWorkPlacePage;
import pages.newPage;

public class LeadDetailTest extends BaseTest{
	@Test(priority=1)
	void login() throws InterruptedException {
		 LoginPage lp = new LoginPage(driver);
		 lp.login();
		 System.out.println("login successful");
		 
		chooseWorkPlacePage cwp = new chooseWorkPlacePage(driver);
	    cwp.ClickNext(); 
	    System.out.println("successfully choosed workspace");
	}
	@Test(priority=2,dependsOnMethods = "login")
	void edit_profile_info() throws InterruptedException {
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
