package tests.userOnboarding;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.userOnboarding.LoginPage;
import pages.userOnboarding.chooseWorkPlacePage;

public class LoginTest extends BaseTest{
   @Test(priority=1,groups= {"sanity"})
   public void login() throws InterruptedException {
	   LoginPage lp = new LoginPage(driver);
	   lp.login();
	   chooseWorkPlacePage cwsp = new chooseWorkPlacePage(driver);
	   cwsp.ClickNext();
   }
}
