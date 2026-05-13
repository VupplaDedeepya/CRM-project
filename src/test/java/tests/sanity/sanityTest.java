package tests.sanity;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.leads.HomePage;
import pages.leads.LeadFormPage;
import pages.leads.NotesPage;
import pages.userOnboarding.LoginPage;
import pages.userOnboarding.chooseWorkPlacePage;

public class sanityTest extends BaseTest{
   @Test(priority=1,groups={"sanity"} )
	  void login() throws InterruptedException {
		 LoginPage lp = new LoginPage(driver);
		 lp.login();
		 System.out.println("login successful");
		 
		chooseWorkPlacePage cwp = new chooseWorkPlacePage(driver);
	    cwp.ClickNext(); 
	    System.out.println("successfully choosed workspace");
     }
   @Test(priority=2,groups={"sanity"} )
   void createLead() throws InterruptedException {
	  LeadFormPage lp = new LeadFormPage(driver);
	  lp.submitWithAllDetails();
   }
   @Test(priority=3,groups={"sanity"} )
   void createView() throws InterruptedException {
	   HomePage hp = new HomePage(driver);
	   hp.create_view();
   }
   @Test(priority=4,groups={"sanity"} )
   void note() throws InterruptedException {
	   NotesPage np = new NotesPage(driver);
		  np.selectLead();
		  np.note_tab();
		  np.Add_note("Schedule a meeting with Lead");
		  np.choose_alignment("Align Left");
		  np.select_dateAndtime("25", "10","45", "AM");
		  np.submit();
   }
}
