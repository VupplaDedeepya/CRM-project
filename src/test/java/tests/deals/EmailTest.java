package tests.deals;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.deals.EmailPage;
import pages.userOnboarding.LoginPage;
import pages.userOnboarding.chooseWorkPlacePage;

public class EmailTest extends BaseTest{
    @Test(priority=1,description="login")
    public void login() throws InterruptedException {
    	LoginPage lp = new LoginPage(driver);
    	lp.login();
    	chooseWorkPlacePage cwsp = new chooseWorkPlacePage(driver);
    	cwsp.ClickNext();
    }
    @Test(priority=2,description="navigate to deals page")
    public void deals() throws InterruptedException {
    	EmailPage ep = new EmailPage(driver);
    	ep.deals_tab();
    	ep.selectDeal();
    	ep.email_tab();
    	ep.compose_email();
    	//ep.draft_email();
    	//ep.schedule_email();
    }
}
