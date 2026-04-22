package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.EditLeadPage;
import pages.LoginPage;
import pages.chooseWorkPlacePage;

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
