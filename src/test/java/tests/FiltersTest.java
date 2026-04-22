package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.FiltersPage;
import pages.LoginPage;
import pages.chooseWorkPlacePage;

public class FiltersTest extends BaseTest{
	@Test(priority=1)
	void login() throws InterruptedException{
		 LoginPage lp = new LoginPage(driver);
		 lp.login();
		 System.out.println("login successful");
		 
		chooseWorkPlacePage cwp = new chooseWorkPlacePage(driver);
	    cwp.ClickNext(); 
	    System.out.println("successfully choosed workspace");
	}
    @Test(priority=2,enabled=true)
    void lead_owner_filter() throws InterruptedException {
    	FiltersPage fp = new FiltersPage(driver);
    	fp.filterByLeadOwner();
    }
    @Test(priority=3,enabled=true)
    void lead_status_filter() throws InterruptedException {
    	FiltersPage fp = new FiltersPage(driver);
    	fp.filterByLeadStatus();
    }
    @Test(priority=4,enabled=true)
    void create_date_filter() throws InterruptedException {
    	FiltersPage fp = new FiltersPage(driver);
    	fp.filterByCreateDate();
    }
    @Test(priority=5,enabled=true)
    void last_activity_filetr() throws InterruptedException {
    	FiltersPage fp = new FiltersPage(driver);
    	fp.filterByLastActivity();
    }
    @Test(priority=6,enabled=true)
    void Adv_filters() throws InterruptedException{
    	FiltersPage fp = new FiltersPage(driver);
    	fp.AdvFilters();
    }
    @Test(priority=7)
    void searchColumn() throws InterruptedException {
    	FiltersPage fp = new FiltersPage(driver);
    	fp.searchByColumnName();
    }
}
