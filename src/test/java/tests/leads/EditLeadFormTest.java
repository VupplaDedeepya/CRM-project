package tests.leads;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.leads.EditLeadPage;
import pages.userOnboarding.LoginPage;
import pages.userOnboarding.chooseWorkPlacePage;

public class EditLeadFormTest extends BaseTest{
  @Test(priority=1)
  void login() throws InterruptedException {
	  LoginPage lp = new LoginPage(driver);
	  lp.login();
	  chooseWorkPlacePage cws = new chooseWorkPlacePage(driver);
	  cws.ClickNext();
  }
  @Test (priority=2,dependsOnMethods="login")
  void editform() throws InterruptedException {
	  EditLeadPage elp = new EditLeadPage(driver);
	  elp.chooserow();
	  elp.basicDetails();
	  elp.companyDetails();
	  elp.leadDetails();
	  elp.socialDetails();
	  elp.ClickUpadteBtn();
  }
}
