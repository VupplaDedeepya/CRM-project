package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.DealsFiltersPage;
import pages.LoginPage;
import pages.chooseWorkPlacePage;

public class DealsFiltersTest extends BaseTest{
   @Test(priority=1,description="login")
   void login() throws InterruptedException {
	   LoginPage lp = new LoginPage(driver);
	   lp.login();
	   chooseWorkPlacePage cwsp = new chooseWorkPlacePage(driver);
	   cwsp.ClickNext();
   }
   @Test(priority=2,description="navigate to deals tab")
   void deals() throws InterruptedException {
	   	DealsFiltersPage dfp = new DealsFiltersPage(driver);
	  	dfp.dealTab();
   }
   @Test(priority=3,enabled=false,description="filter by deal owner")
   void deal_owner_filter() throws InterruptedException {
   	DealsFiltersPage dfp = new DealsFiltersPage(driver);
   	dfp.filterByDealOwner();
   }
   @Test(priority=4,enabled=false,description="filter by deal status")
   void deal_status_filter() throws InterruptedException {
   	DealsFiltersPage dfp = new DealsFiltersPage(driver);
   	dfp.filterByDealStatus();
   }
   @Test(priority=5,enabled=false,description="filter by close date")
   void close_date_filter() throws InterruptedException {
   	DealsFiltersPage dfp = new DealsFiltersPage(driver);
   	dfp.filterByCloseDate();
   }
   @Test(priority=6,enabled=false,description="filter by created date")
   void created_date_filetr() throws InterruptedException {
   	DealsFiltersPage dfp = new DealsFiltersPage(driver);
   	dfp.filterByCreatedDate();
   }
   @Test(priority=7,enabled=true,description="advanced filters")
   void adv_filters() throws InterruptedException {
	   	DealsFiltersPage dfp = new DealsFiltersPage(driver);
	   	dfp.advanced_filters();
   }
 
}
