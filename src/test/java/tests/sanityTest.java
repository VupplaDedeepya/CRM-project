package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LeadFormPage;
import pages.LoginPage;
import pages.chooseWorkPlacePage;

public class sanityTest extends BaseTest{
   @Test(priority=1)
	  void login() throws InterruptedException {
		 LoginPage lp = new LoginPage(driver);
		 lp.login();
		 System.out.println("login successful");
		 
		chooseWorkPlacePage cwp = new chooseWorkPlacePage(driver);
	    cwp.ClickNext(); 
	    System.out.println("successfully choosed workspace");
     }
   @Test(priority=2)
   void createLead() throws InterruptedException {
	  LeadFormPage lp = new LeadFormPage(driver);
	  lp.ClickCreateLead();
	  lp.basicDetails();
      System.out.println("filled basic details");
 	  lp.companyDetails();
 	  System.out.println("filled company details");
	  lp.leadDetails();
	  System.out.println("filled lead details");
	  lp.socialDetails();
	  System.out.println("filled social details");
	  LeadFormPage lfp = new LeadFormPage(driver);
	  lp.clickCreate();
	  System.out.println("successfully create a lead");
   }
   
}
