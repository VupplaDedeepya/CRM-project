package tests.leads;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.leads.FiltersPage;
import pages.userOnboarding.LoginPage;
import pages.userOnboarding.chooseWorkPlacePage;

public class FiltersTest extends BaseTest{
	@Test(priority=1)
	public void login() throws InterruptedException{
		 LoginPage lp = new LoginPage(driver);
		 lp.login();
		 System.out.println("login successful");
		 
		chooseWorkPlacePage cwp = new chooseWorkPlacePage(driver);
	    cwp.ClickNext(); 
	    System.out.println("successfully choosed workspace");
	}
    @Test(priority=2,enabled=true)
    public void lead_owner_filter() throws InterruptedException {
    	FiltersPage fp = new FiltersPage(driver);
    	fp.filterByLeadOwner();
    }
    @Test(priority=3,enabled=true)
    public void lead_status_filter() throws InterruptedException {
    	FiltersPage fp = new FiltersPage(driver);
    	fp.filterByLeadStatus();
    }
    @Test(priority=4,enabled=true)
    public void create_date_filter() throws InterruptedException {
    	FiltersPage fp = new FiltersPage(driver);
    	fp.filterByCreateDate();
    }
    @Test(priority=5,enabled=true)
    public void last_activity_filetr() throws InterruptedException {
    	FiltersPage fp = new FiltersPage(driver);
    	fp.filterByLastActivity();
    }
    @Test(priority=6,enabled=true)
    public void Adv_filters() throws InterruptedException{
    	FiltersPage fp = new FiltersPage(driver);
    	fp.AdvFilters();
    }
    @Test(priority=7)
    public void searchColumn() throws InterruptedException {
    	FiltersPage fp = new FiltersPage(driver);
    	fp.searchByColumnName();
    }
}
