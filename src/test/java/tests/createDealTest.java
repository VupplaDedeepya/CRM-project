package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.CreateDealPage;
import pages.LoginPage;
import pages.chooseWorkPlacePage;

public class createDealTest extends BaseTest{
   @Test(priority=1,description="login")
   void login() throws InterruptedException{
	   LoginPage lp = new LoginPage(driver);
	   lp.login();
	   chooseWorkPlacePage cwsp = new chooseWorkPlacePage(driver);
	   cwsp.ClickNext();
   }
   @Test(priority=2,dependsOnMethods="login",description="create a deal")
   void Deal() throws InterruptedException {
	   CreateDealPage cdp = new CreateDealPage(driver);
	   cdp.ClickDealsTab();
	   cdp.createDeal("Mobile App Development – Healthcare");
   }
   
}
