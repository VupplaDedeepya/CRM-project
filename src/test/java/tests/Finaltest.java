package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.FiltersPage;
import pages.HomePage;
import pages.LeadFormPage;
import pages.ListingDetailsUpdatePage;
import pages.LoginPage;
import pages.UpdateParticularLeadPage;
import pages.chooseWorkPlacePage;

public class Finaltest extends BaseTest{
	  //login
	  @Test(priority =1)
	  void login() throws InterruptedException {
		 LoginPage lp = new LoginPage(driver);
		 lp.login();
	  }
	  //choose work space
	  @Test(priority=2)
	  void cws() {
		chooseWorkPlacePage cwp = new chooseWorkPlacePage(driver);
	    cwp.ClickNext(); 
	  }
	  //click create lead button and fill basic details
	  @Test(priority=3)
	  void basic_details() throws InterruptedException {
		  //click create lead button
		  LeadFormPage lp = new LeadFormPage(driver);
		  lp.ClickCreateLead();
		  lp.basicDetails();
		 // Thread.sleep(2000);
	  }
	  @Test(priority=4)
	  void companydetails() throws InterruptedException {
		  LeadFormPage lp = new LeadFormPage(driver);
		 lp.companyDetails();
		// Thread.sleep(2000);
	  }
	  @Test(priority=5)
	  void lead_details() throws InterruptedException {
		  LeadFormPage lp = new LeadFormPage(driver);
		  lp.leadDetails();
		//  Thread.sleep(2000);
	  }
	  @Test(priority=6)
	  void sicial_details() throws InterruptedException {
		  LeadFormPage lp = new LeadFormPage(driver);
		  lp.socialDetails();
		 // Thread.sleep(2000);
	  }
	  @Test(priority=7)
	  void ClickcreateLead() throws InterruptedException {
		  LeadFormPage lp = new LeadFormPage(driver);
		  lp.clickCreate();
	  }
	  @Test (priority=8)
	  void create_view() throws InterruptedException {
		  HomePage hp = new HomePage(driver);
		  hp.Handle_AddView("sai's view");
		  //Thread.sleep(5000);
	  }
	  @Test(priority=9)
	    void ListingChanges() throws InterruptedException {
		  ListingDetailsUpdatePage ldup = new ListingDetailsUpdatePage(driver);
		   ldup.changeStatusFromListing();
		   ldup.textChanges();
		   ldup.tags();
		   ldup.changeSourceFromListing();
		   ldup.changePrefferedChannelFromListing();
		   ldup.leadOwner();
	    }
	    @Test(priority=10)
	    void leadUpdateCheckbox() throws InterruptedException {
	    	UpdateParticularLeadPage uplp = new UpdateParticularLeadPage(driver);
		   uplp.leadStatusUpdateFromCheckbox();
		   uplp.leadOwnerUpdateFromCheckbox();
		   uplp.AddTagsFromCheckbox();
	    }
	    @Test(priority=11,enabled=true)
	    void lead_owner_filter() throws InterruptedException {
	    	FiltersPage fp = new FiltersPage(driver);
	    	fp.filterByLeadOwner();
	    }
	    @Test(priority=12,enabled=true)
	    void lead_status_filter() throws InterruptedException {
	    	FiltersPage fp = new FiltersPage(driver);
	    	fp.filterByLeadStatus();
	    }
	    @Test(priority=13,enabled=true)
	    void create_date_filter() throws InterruptedException {
	    	FiltersPage fp = new FiltersPage(driver);
	    	fp.filterByCreateDate();
	    }
	    @Test(priority=14,enabled=true)
	    void last_activity_filetr() throws InterruptedException {
	    	FiltersPage fp = new FiltersPage(driver);
	    	fp.filterByLastActivity();
	    }
	    @Test(priority=15)
	    void Adv_filters() throws InterruptedException{
	    	FiltersPage fp = new FiltersPage(driver);
	    	fp.AdvFilters();
	    }
}
