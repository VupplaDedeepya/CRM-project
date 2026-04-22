package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ActivitiesPage;
import pages.EditLeadPage;
import pages.EmailPage;
import pages.FiltersPage;
import pages.HomePage;
import pages.LeadFormPage;
import pages.LoginPage;
import pages.MeetingPage;
import pages.NotesPage;
import pages.TaskPage;
import pages.chooseWorkPlacePage;

public class LeadFlowTest extends BaseTest{
  @Test(priority=1)
  void login() throws InterruptedException {
		 LoginPage lp = new LoginPage(driver);
		 lp.login();
		 System.out.println("login successful");
		 
		chooseWorkPlacePage cwp = new chooseWorkPlacePage(driver);
	    cwp.ClickNext(); 
	    System.out.println("successfully choosed workspace");
  }
  @Test(priority=2,dependsOnMethods="login")
  void leadCreation() throws InterruptedException {
      LeadFormPage lead = new LeadFormPage(driver);
      lead.submitWithAllDetails();
      System.out.println("Lead created with full details");
  }
  @Test(priority=3)
  void viewCreation() throws InterruptedException{
	  HomePage hp = new HomePage(driver);
	  hp.create_view();
  }
  @Test(priority=4)
  void adv_filters() throws InterruptedException {
	   	FiltersPage fp = new FiltersPage(driver);
    	fp.AdvFilters();
  }
  @Test(priority=5)
  void activities() throws InterruptedException {
	  ActivitiesPage ap = new ActivitiesPage(driver);
	  ap.selectLead("LEAD-1023","Mr Phuong Cronin");
	  ap.notes();
	  ap.tasks();
	  ap.calendar();
	  ap.email();
	  ap.convertToDeal();
  }
  @Test(priority=6)
  void add_activities() throws InterruptedException {
	  NotesPage np = new NotesPage(driver);
	  np.Add_note("Schedule a meeting with Lead");
	  np.choose_alignment("Align Left");
	  np.select_dateAndtime("25", "10","45", "AM");
	  np.submit();
	  TaskPage tp = new TaskPage(driver);
	  tp.add_task();
	  MeetingPage mp = new MeetingPage(driver);
	  mp.navigate_meetingTab();
	  mp.Log_meeting();
	  Thread.sleep(5000);
	 // mp.Add_Meeting();
	  EmailPage ep = new EmailPage(driver);
	  ep.click_email_tab();
	  ep.compose_email();
	  Thread.sleep(3000);
  }
}
