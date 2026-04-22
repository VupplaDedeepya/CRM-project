package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ListingDetailsUpdatePage;
import pages.LoginPage;
import pages.chooseWorkPlacePage;

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
