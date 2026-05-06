package tests.leads;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.leads.UpdateParticularLeadPage;
import pages.userOnboarding.LoginPage;
import pages.userOnboarding.chooseWorkPlacePage;

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
	   uplp.select_lead("LEAD-1042");
	   uplp.leadStatusUpdateFromCheckbox();
	   uplp.select_lead("LEAD-1042");
	   uplp.leadOwnerUpdateFromCheckbox();
	   uplp.select_lead("LEAD-1042");
	   uplp.AddTagsFromCheckbox();
	   uplp.select_lead("LEAD-1036");
	   uplp.Delete_lead();
   }
}
