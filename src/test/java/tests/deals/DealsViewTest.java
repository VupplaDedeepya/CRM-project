package tests.deals;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.deals.DealViewPage;
import pages.userOnboarding.LoginPage;
import pages.userOnboarding.chooseWorkPlacePage;

public class DealsViewTest extends BaseTest{
 
     @Test(priority=1,description="login")
     public void login() throws InterruptedException {
    	 LoginPage lp = new LoginPage(driver);
		 lp.login();
		 chooseWorkPlacePage cwsp = new chooseWorkPlacePage(driver);
		 cwsp.ClickNext();
		 }
     @Test(priority=2,description="create a view")
     public void create_view() throws InterruptedException {
    	 DealViewPage dvp = new DealViewPage(driver);
    	 dvp.deals_tab();
    	 dvp.add_view();
     }
}
