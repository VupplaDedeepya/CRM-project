package tests.leads;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.leads.ListingDetailsUpdatePage;
import pages.userOnboarding.LoginPage;
import pages.userOnboarding.chooseWorkPlacePage;

public class ListingDropdownsTest extends BaseTest {
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
   void dropdowns() throws InterruptedException {
	   ListingDetailsUpdatePage ldup = new ListingDetailsUpdatePage(driver);
	   ldup.changeStatusFromListing();
	   ldup.textChanges();
	   ldup.tags();
	   ldup.changeSourceFromListing();
	   ldup.changePrefferedChannelFromListing();
	   ldup.leadOwner();
   }
}
