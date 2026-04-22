package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.UpdateParticularLeadPage;
import pages.chooseWorkPlacePage;

public class UpdateFromLeadCheckboxTest extends BaseTest {
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
	   UpdateParticularLeadPage uplp = new UpdateParticularLeadPage(driver);
	   uplp.leadStatusUpdateFromCheckbox();
	   uplp.leadOwnerUpdateFromCheckbox();
	   uplp.AddTagsFromCheckbox();
   }
}
